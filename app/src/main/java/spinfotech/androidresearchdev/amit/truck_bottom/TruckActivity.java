package spinfotech.androidresearchdev.amit.truck_bottom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import spinfotech.androidresearchdev.R;

/**
 * Created by sibaprasad on 14/09/17.
 */

public class TruckActivity extends AppCompatActivity {
	RecyclerView recyclerTruck;
	TruckAdapter truckAdapter;
	List< List< String > > list = new ArrayList<>();

	@Override
	protected void onCreate( @Nullable Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_truck );

		recyclerTruck = findViewById( R.id.recyclerTruck );

		recyclerTruck.setLayoutManager( new LinearLayoutManager( TruckActivity.this, LinearLayoutManager.HORIZONTAL, false ) );

		List< String > listInner = new ArrayList<>();
		for ( int i = 0; i < 10; i++ ) {
			listInner.add( "Row Item " + i );
			if ( i % 2 == 0 ) {
				list.add( listInner );
				listInner.clear();
			}
			else if(i == 9){
				list.add( listInner );
			}
		}

		truckAdapter = new TruckAdapter( TruckActivity.this,list );
		recyclerTruck.setAdapter( truckAdapter );
	}
}
