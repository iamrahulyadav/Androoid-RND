package spinfotech.androidresearchdev.spm.adapters.viewholders;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import spinfotech.androidresearchdev.R;
import spinfotech.androidresearchdev.spm.model.ModelHeader;

public class ViewHolderHeader extends RecyclerView.ViewHolder {
	private static final String TAG = "ViewHolderHeader";
	@BindView( R.id.textViewName_header )
	AppCompatTextView textViewNameHeader;
	@BindView( R.id.textViewComment_header )
	AppCompatTextView textViewCommentHeader;
	private ModelHeader modelHeaderData;

	public ViewHolderHeader( View itemView ) {
		super( itemView );
		ButterKnife.bind( this, itemView );
	}

	public void setData( ModelHeader data ) {
		this.modelHeaderData = data;
		updateUi();
	}

	private void updateUi() {
		textViewNameHeader.setText( modelHeaderData.textTitle );
		textViewCommentHeader.setText( modelHeaderData.comment );
	}
}
