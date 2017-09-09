package spinfotech.androidresearchdev.spm.adapters.amitAdapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import spinfotech.androidresearchdev.R;
import spinfotech.androidresearchdev.spm.adapters.viewholders.ViewHolderDefault;
import spinfotech.androidresearchdev.spm.adapters.viewholders.ViewHolderFooter;
import spinfotech.androidresearchdev.spm.adapters.viewholders.ViewHolderHeader;
import spinfotech.androidresearchdev.spm.adapters.viewholders.ViewHolderManager;
import spinfotech.androidresearchdev.spm.adapters.viewholders.ViewHolderPopularImage;
import spinfotech.androidresearchdev.spm.listeners.OnRecyclerItemClickListener;
import spinfotech.androidresearchdev.spm.model.ModelHeader;
import spinfotech.androidresearchdev.spm.utility.Constants;


/**
 * Created by sibaprasad on 23/06/17.
 */

public class CommonAdapter extends RecyclerView.Adapter< RecyclerView.ViewHolder > {

	private static final String TAG = "CommonRecyclerViewAdapt";

	int rowType = -1;
	List< Object > objectList;
	boolean        isRowPreFixed = true;

	OnRecyclerItemClickListener onRecyclerItemClickListener;
	int visiblePosition = -1;
	LayoutInflater mInflater;

	public CommonAdapter( Context context, List< Object > listData, int rowType,  OnRecyclerItemClickListener onRecyclerItemClickListener ) {
		super();
		this.objectList = listData;
		this.rowType = rowType;
		this.isRowPreFixed = isRowPreFixed;
		this.onRecyclerItemClickListener = onRecyclerItemClickListener;
		mInflater = LayoutInflater.from( context );
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType ) {
		RecyclerView.ViewHolder holder = null;

		View view;

		switch ( viewType ) {

			case Constants.ROW_PENDING:

				view = mInflater
						.inflate( R.layout.row_item_header, parent, false );
				holder = new ViewHolderHeader( view );

				break;

			case Constants.ROW_COMPLETED:
				view = mInflater
						.inflate( R.layout.row_item_footer, parent, false );
				holder = new ViewHolderFooter( view );

				break;
			case Constants.ROW_UPCOMMING:

				view = mInflater
						.inflate( R.layout.row_item_popular_image, parent, false );
				holder = new ViewHolderPopularImage( view );

				break;

			default:
				view = mInflater
						.inflate( R.layout.row_item_default, parent, false );

				holder = new ViewHolderDefault( view );
		}

		return holder;
	}

	@Override
	public void onBindViewHolder( RecyclerView.ViewHolder holder, int position ) {

		Object object = objectList.get( position );

		switch ( holder.getItemViewType() ) {
			case Constants.ROW_PENDING:
				ViewHolderHeader viewHolderHeader = (ViewHolderHeader)holder;
				ModelHeader modelHeader = (ModelHeader )object;
				viewHolderHeader.setData( modelHeader );
				break;
			case Constants.ROW_COMPLETED:

				break;

			case Constants.ROW_UPCOMMING:

				break;
		}

	}

	@Override
	public int getItemViewType( int position ) {

		return rowType;

		/*int TYPE = 0;
		if ( isRowPreFixed ) {
			return rowType;
		}
		else {
			rowType = ViewHolderManager.getRowType( objectList.get( position ) );
		}
		return rowType;*/
	}

	@Override
	public int getItemCount() {
		return objectList.size();
	}

	public void setVisiblePosition( int completelyVisibleposition ) {
		this.visiblePosition = completelyVisibleposition;
		notifyDataSetChanged();
	}

	public void setDataAndRow( List< Object > listData, int rowType ) {
		this.objectList = listData;
		this.rowType = rowType;
		notifyDataSetChanged();
	}
}