package spinfotech.androidresearchdev.spm.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import spinfotech.androidresearchdev.R;
import spinfotech.androidresearchdev.spm.listeners.RecyclerItemClickListener;

/**
 * Created by sibaprasad on 03/09/17.
 */

public class CommonAdapter extends RecyclerView.Adapter<CommonAdapter.ViewHolderText > {

	List<String> mListData;
	Context mContext;
	LayoutInflater mLayoutInflater;
	RecyclerItemClickListener mRecyclerItemClickListener;
	public CommonAdapter( Context context, List< String > mListData,RecyclerItemClickListener recyclerItemClickListener ) {
		this.mContext = context;
		this.mListData = mListData;
		mLayoutInflater = LayoutInflater.from(mContext);
		this.mRecyclerItemClickListener = recyclerItemClickListener;
	}

	@Override
	public ViewHolderText onCreateViewHolder( ViewGroup parent, int viewType ) {
		View itemView = mLayoutInflater.inflate( R.layout.itemview_text,parent,false );
		return new ViewHolderText(itemView);
	}

	@Override
	public void onBindViewHolder( ViewHolderText holder, int position ) {

	}

	@Override
	public int getItemCount() {
		return mListData.size();
	}


	public class ViewHolderText extends RecyclerView.ViewHolder{

		public ViewHolderText( View itemView ) {
			super( itemView );
		}
	}
}
