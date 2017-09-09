package spinfotech.androidresearchdev.spm.adapters.viewholders;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import spinfotech.androidresearchdev.R;

public class ViewHolderPopularText extends RecyclerView.ViewHolder {
	@BindView( R.id.profile_image )
	CircleImageView    profileImage;
	@BindView( R.id.textViewPopularFeedName )
	AppCompatTextView  textViewPopularFeedName;
	@BindView( R.id.textViewPopularTime )
	AppCompatTextView  textViewPopularTime;
	@BindView( R.id.textViewPopularTitle )
	AppCompatTextView  textViewPopularTitle;
	@BindView( R.id.imageViewUp )
	AppCompatImageView imageViewUp;
	@BindView( R.id.textViewUpDownCount )
	AppCompatTextView  textViewUpDownCount;
	@BindView( R.id.imageViewDown )
	AppCompatImageView imageViewDown;
	@BindView( R.id.textViewComments )
	AppCompatTextView  textViewComments;
	@BindView( R.id.textViewShare )
	AppCompatTextView  textViewShare;

	public ViewHolderPopularText( View itemView ) {
		super( itemView );
		ButterKnife.bind( this, itemView );
	}
	public void setData(Object object) {
		updateUi();
	}

	private void updateUi(){

	}
}