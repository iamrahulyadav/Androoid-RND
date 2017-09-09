package spinfotech.androidresearchdev.spm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import spinfotech.androidresearchdev.R;
import spinfotech.androidresearchdev.spm.adapters.HomeTaskAdapter;
import spinfotech.androidresearchdev.spm.listeners.HomeTaskCLickListener;

/**
 * Created by sibaprasad on 04/09/17.
 */

public class SpmMainActivity extends AppCompatActivity implements View.OnClickListener,HomeTaskCLickListener {

	@BindView( R.id.recyclerViewHome )
	RecyclerView recyclerViewHome;

	HomeTaskAdapter mHomeTaskAdapter;
	String[] array;


	@Override
	protected void onCreate( @Nullable Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_spm_main );
		ButterKnife.bind( this );

		array = getResources().getStringArray( R.array.modules );
		mHomeTaskAdapter = new HomeTaskAdapter( SpmMainActivity.this,array,this );
		recyclerViewHome.setLayoutManager( new GridLayoutManager( SpmMainActivity.this,2 ) );
		recyclerViewHome.setAdapter( mHomeTaskAdapter );
	}

	@Override
	public void onClick( View view ) {
		switch ( view.getId() ){
			case R.id.tvCustomView :

				break;

		}
	}

	@Override
	public void onHomeTaskSelected( int position, String title ) {
		switch ( position ){
			case 0 :

				break;
		}
	}
}
