package spinfotech.androidresearchdev.amit.truck_bottom;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import spinfotech.androidresearchdev.R;
import spinfotech.androidresearchdev.amit.adapter.viewHolder.NormalViewHolder;
import spinfotech.androidresearchdev.spm.adapters.viewholders.ViewHolderFooter;

/**
 * Created by sibaprasad on 10/09/17.
 */

public class TruckAdapter extends RecyclerView.Adapter<TruckAdapter.TruckViewHolder > {

	List<List<String>> mList;
	Context mContext;
	LayoutInflater mInflater;

	public TruckAdapter( Context mContext, List< List<String> > mList ) {
		this.mList = mList;
		this.mContext = mContext;
		mInflater = LayoutInflater.from( mContext );
	}

	@Override
	public TruckViewHolder onCreateViewHolder( ViewGroup parent, int viewType ) {
		View view = mInflater
				.inflate( R.layout.row_item_truck, parent, false );
		return  new TruckViewHolder( view );
	}

	@Override
	public void onBindViewHolder( TruckViewHolder holder, int position ) {
		List<String> listDataItem = new ArrayList<>(  );
		listDataItem = mList.get( position );


		holder.imageView1.setVisibility( View.VISIBLE );
		holder.imageView2.setVisibility( View.VISIBLE );
		holder.imageView3.setVisibility( View.VISIBLE );

		switch ( mList.size() ){

			case 1 :

				// set the image to imageview 1 here

				holder.imageView2.setVisibility( View.GONE );
				holder.imageView3.setVisibility( View.GONE );
				break;
			case 2 :

				// set the image to imageview 1 and 2 here

				holder.imageView3.setVisibility( View.GONE );
				break;
			case 3 :
				// set the image to imageview 1 and 2 and 3 here

				break;

		}
	}

	@Override
	public int getItemCount() {
		return mList.size();
	}


	public class TruckViewHolder extends RecyclerView.ViewHolder{
		AppCompatImageView imageView1;
		AppCompatImageView imageView2;
		AppCompatImageView imageView3;

		public TruckViewHolder( View itemView ) {
			super( itemView );
			 imageView1 = itemView.findViewById( R.id.imageView1 );
			imageView2 = itemView.findViewById( R.id.imageView2 );
			imageView3 = itemView.findViewById( R.id.imageView1 );
		}
	}

}
