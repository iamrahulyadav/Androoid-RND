package spinfotech.androidresearchdev.spm.adapters.amitAdapters.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by sibaprasad on 10/09/17.
 */

public class CompleteViewholder extends RecyclerView.ViewHolder {

	private static final String TAG = "PendingViewHolder";

	public CompleteViewholder( View itemView ) {
		super( itemView );
		ButterKnife.bind( this, itemView );
	}

	public void setData( Object object ) {

	}
}