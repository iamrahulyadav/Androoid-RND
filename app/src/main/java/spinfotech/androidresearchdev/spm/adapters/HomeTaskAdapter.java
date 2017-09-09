package spinfotech.androidresearchdev.spm.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import spinfotech.androidresearchdev.R;
import spinfotech.androidresearchdev.spm.listeners.HomeTaskCLickListener;
import spinfotech.androidresearchdev.spm.listeners.RecyclerItemClickListener;

/**
 * Created by sibaprasad on 03/09/17.
 */

public class HomeTaskAdapter extends RecyclerView.Adapter<HomeTaskAdapter.ViewHolderText > {

	String[] mListData;
	Context mContext;
	LayoutInflater mLayoutInflater;
	HomeTaskCLickListener mHomeTaskCLickListener;
	public HomeTaskAdapter( Context context, String[] mListData,HomeTaskCLickListener homeTaskCLickListener ) {
		this.mContext = context;
		this.mListData = mListData;
		mLayoutInflater = LayoutInflater.from(mContext);
		this.mHomeTaskCLickListener = homeTaskCLickListener;
	}

	@Override
	public ViewHolderText onCreateViewHolder( ViewGroup parent, int viewType ) {
		View itemView = mLayoutInflater.inflate( R.layout.itemview_home_task,parent,false );
		return new ViewHolderText(itemView);
	}

	@Override
	public void onBindViewHolder( ViewHolderText holder, final int position ) {
		holder.itemView.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick( View view ) {
				mHomeTaskCLickListener.onHomeTaskSelected( position,mListData[position] );
			}
		} );
	}

	@Override
	public int getItemCount() {
		return mListData.length;
	}


	public class ViewHolderText extends RecyclerView.ViewHolder{

		public ViewHolderText( View itemView ) {
			super( itemView );
		}
	}
}
