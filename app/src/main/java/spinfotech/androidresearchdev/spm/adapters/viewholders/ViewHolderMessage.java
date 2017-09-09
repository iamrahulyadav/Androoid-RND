package spinfotech.androidresearchdev.spm.adapters.viewholders;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import spinfotech.androidresearchdev.R;

public class ViewHolderMessage extends RecyclerView.ViewHolder {
	@BindView( R.id.textViewTitleMessage )
	public AppCompatTextView  textViewTitleMessage;
	@BindView( R.id.textViewDescMessage )
	public AppCompatTextView  textViewDescMessage;
	@BindView( R.id.imageViewUp )
	public AppCompatImageView imageViewUp;
	@BindView( R.id.textViewUpDownCount )
	public AppCompatTextView  textViewUpDownCount;
	@BindView( R.id.imageViewDown )
	public AppCompatImageView imageViewDown;
	@BindView( R.id.textViewComments )
	public AppCompatTextView  textViewComments;
	@BindView( R.id.textViewShare )
	public AppCompatTextView  textViewShare;
	@BindView( R.id.layoutInc )
	public LinearLayout       layoutFooterToolbar;

	public ViewHolderMessage( View itemView ) {
		super( itemView );
		ButterKnife.bind( this, itemView );
	}
	public void setData(Object object) {
		updateUi();
	}

	private void updateUi(){

	}
}