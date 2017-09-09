package spinfotech.androidresearchdev.spm.adapters;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import spinfotech.androidresearchdev.R;

public class ViewHolderText extends RecyclerView.ViewHolder {

	@BindView( R.id.textViewMessageItem )
	AppCompatTextView textViewMessageItem;

	public ViewHolderText( View itemView ) {
		super( itemView );
		ButterKnife.bind( this, itemView );
	}
}