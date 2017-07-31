package spinfotech.androidresearchdev.multilevelRecyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import spinfotech.androidresearchdev.R;

/**
 * Created by sibaprasad on 27/07/17.
 */

public class MultiRecyclerActivity extends AppCompatActivity implements LikeClickListener{

	ParentAdapter parentAdapter;
	RecyclerView recyclerParent;
	List<ParentModel> parentModelList = new ArrayList<>(  );
	@Override
	protected void onCreate( @Nullable Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_multirecycler );

		recyclerParent = (RecyclerView)findViewById( R.id.recyclerParent );
		recyclerParent.setLayoutManager( new LinearLayoutManager(   MultiRecyclerActivity.this ));

		for(int i = 0;i < 10;i++){

			List<ChildModel> listChild = new ArrayList<>(  );
			for(int j =0;j<4;j++){
				listChild.add( new ChildModel( "Child "+j,false ) );
			}

			parentModelList.add( new ParentModel(  "parent "+i,listChild ));
		}

		parentAdapter = new ParentAdapter( this,parentModelList,this );

		recyclerParent.setAdapter( parentAdapter );
	}

	@Override
	public void onLikeClicked(int parentPosition, int position ) {

		if(parentModelList.get( parentPosition ).listChild.get( position ).isLiked)
			parentModelList.get( parentPosition ).listChild.get( position ).isLiked = false;
		else
			parentModelList.get( parentPosition ).listChild.get( position ).isLiked = true;
		parentAdapter.notifyDataSetChanged();
	}
}
