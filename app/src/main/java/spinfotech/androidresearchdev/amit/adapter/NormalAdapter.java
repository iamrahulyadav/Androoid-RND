package spinfotech.androidresearchdev.amit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import spinfotech.androidresearchdev.R;
import spinfotech.androidresearchdev.amit.adapter.viewHolder.NormalViewHolder;
import spinfotech.androidresearchdev.spm.adapters.viewholders.ViewHolderFooter;

/**
 * Created by sibaprasad on 10/09/17.
 */

public class NormalAdapter extends RecyclerView.Adapter<NormalViewHolder > {

	List<String> mList;
	Context mContext;
	LayoutInflater mInflater;

	public NormalAdapter(  Context mContext, List< String > mList ) {
		this.mList = mList;
		this.mContext = mContext;
		mInflater = LayoutInflater.from( mContext );
	}

	@Override
	public NormalViewHolder onCreateViewHolder( ViewGroup parent, int viewType ) {
		View view = mInflater
				.inflate( R.layout.row_item_footer, parent, false );
		return  new NormalViewHolder( view );
	}

	@Override
	public void onBindViewHolder( NormalViewHolder holder, int position ) {
		holder.setData();
	}

	@Override
	public int getItemCount() {
		return mList.size();
	}
}
