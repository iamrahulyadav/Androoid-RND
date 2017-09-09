package spinfotech.androidresearchdev.amit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import spinfotech.androidresearchdev.R;
import spinfotech.androidresearchdev.spm.adapters.amitAdapters.CommonAdapter;
import spinfotech.androidresearchdev.spm.listeners.OnRecyclerItemClickListener;
import spinfotech.androidresearchdev.spm.model.home.Child;
import spinfotech.androidresearchdev.spm.utility.Constants;

/**
 * Created by sibaprasad on 04/09/17.
 */

public class AmitMainActivity extends AppCompatActivity implements View.OnClickListener,OnRecyclerItemClickListener {


	@BindView( R.id.tvPendingTab )
	AppCompatTextView tvPendingTab;
	@BindView( R.id.tvUpcomingTab )
	AppCompatTextView tvUpcomingTab;
	@BindView( R.id.tvCompletedTab )
	AppCompatTextView tvCompletedTab;
	@BindView( R.id.recyclerViewDriverStatus )
	RecyclerView      recyclerViewDriverStatus;
	@BindView( R.id.rootLayout )
	LinearLayout      rootLayout;

	CommonAdapter mCommonAdapter;
	List<Object> mListData = new ArrayList<>(  );

	@Override
	protected void onCreate( @Nullable Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_amit_main );
		ButterKnife.bind( this );


		tvPendingTab.setOnClickListener( this );
		tvUpcomingTab.setOnClickListener( this );
		tvCompletedTab.setOnClickListener( this );

		recyclerViewDriverStatus.setLayoutManager( new LinearLayoutManager( AmitMainActivity.this ) );

		for(int i = 0;i<10;i++){
			mListData.add( new Child() );
		}

		mCommonAdapter = new CommonAdapter( AmitMainActivity.this, mListData,
		                                    Constants.ROW_PENDING,
		                                    this );
		recyclerViewDriverStatus.setAdapter( mCommonAdapter );

		tvPendingTab.setBackgroundColor( ContextCompat.getColor( AmitMainActivity.this,
		                                                         R.color.color_D3D3D3
		) );
		tvPendingTab.setTextColor( ContextCompat.getColor( AmitMainActivity.this,
		                                                   R.color.white
		)  );

	}

	@Override
	public void onClick( View view ) {
		switch ( view.getId() ) {
			case R.id.tvPendingTab:
				setTabListener(Constants.ROW_PENDING);
				break;
			case R.id.tvUpcomingTab:
				setTabListener(Constants.ROW_UPCOMMING);
				break;
			case R.id.tvCompletedTab:
				setTabListener(Constants.ROW_COMPLETED);
				break;
		}
	}

	@Override
	public void onCommentClick( Child child ) {

	}

	@Override
	public void onFeedClick( Child child ) {

	}

	@Override
	public void onShareClick( Child child ) {

	}

	@Override
	public void onUpClick( Child child ) {

	}

	@Override
	public void onDownClick( Child child ) {

	}

	private void setTabListener(int tabType){


		tvPendingTab.setBackgroundColor( ContextCompat.getColor( AmitMainActivity.this,
		                                                           R.color.white
		) );
		tvPendingTab.setTextColor( ContextCompat.getColor( AmitMainActivity.this,
		                                                     R.color.black
		)  );
		tvUpcomingTab.setBackgroundColor( ContextCompat.getColor( AmitMainActivity.this,
		                                                           R.color.white
		) );
		tvUpcomingTab.setTextColor( ContextCompat.getColor( AmitMainActivity.this,
		                                                     R.color.black
		)  );
		tvCompletedTab.setBackgroundColor( ContextCompat.getColor( AmitMainActivity.this,
		                                                           R.color.white
		) );
		tvCompletedTab.setTextColor( ContextCompat.getColor( AmitMainActivity.this,
		                                                     R.color.black
		)  );

		switch ( tabType ){
			case Constants.ROW_PENDING :
				tvPendingTab.setBackgroundColor( ContextCompat.getColor( AmitMainActivity.this,
				                                                         R.color.color_D3D3D3
				) );
				tvPendingTab.setTextColor( ContextCompat.getColor( AmitMainActivity.this,
				                                                   R.color.white
				)  );
				break;
			case Constants.ROW_UPCOMMING :
				tvUpcomingTab.setBackgroundColor( ContextCompat.getColor( AmitMainActivity.this,
				                                                         R.color.color_D3D3D3
				) );
				tvUpcomingTab.setTextColor( ContextCompat.getColor( AmitMainActivity.this,
				                                                   R.color.white
				)  );
				break;
			case Constants.ROW_COMPLETED :
				tvCompletedTab.setBackgroundColor( ContextCompat.getColor( AmitMainActivity.this,
				                                                         R.color.color_D3D3D3
				) );
				tvCompletedTab.setTextColor( ContextCompat.getColor( AmitMainActivity.this,
				                                                   R.color.white
				)  );
				break;
		}
		mListData.clear();
		for(int i = 0;i<10;i++){
			mListData.add( new Child() );
		}
		if(mCommonAdapter!=null){
			mCommonAdapter.setDataAndRow( mListData,tabType );
		}

	}
}
