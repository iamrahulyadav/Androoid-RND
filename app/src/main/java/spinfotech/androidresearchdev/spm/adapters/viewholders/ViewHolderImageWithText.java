package spinfotech.androidresearchdev.spm.adapters.viewholders;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import spinfotech.androidresearchdev.R;

public class ViewHolderImageWithText extends RecyclerView.ViewHolder {
	@BindView( R.id.imageViewProfileItem )
	CircleImageView   imageViewProfileItem;
	@BindView( R.id.textViewMessageItem )
	AppCompatTextView textViewMessageItem;
	@BindView( R.id.textViewDescItem )
	AppCompatTextView textViewDescItem;

	public ViewHolderImageWithText( View itemView ) {
		super( itemView );
		ButterKnife.bind( this, itemView );
	}

	public void setData( Object object ) {
		updateUi();
	}

	private void updateUi() {

	}
}