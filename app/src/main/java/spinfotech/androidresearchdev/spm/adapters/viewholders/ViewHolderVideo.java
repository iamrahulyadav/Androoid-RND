package spinfotech.androidresearchdev.spm.adapters.viewholders;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.devbrackets.android.exomedia.listener.OnPreparedListener;
import com.devbrackets.android.exomedia.ui.widget.EMVideoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import spinfotech.androidresearchdev.R;
import spinfotech.androidresearchdev.spm.model.ModelVideo;

public class ViewHolderVideo extends RecyclerView.ViewHolder implements MediaPlayer.OnPreparedListener {

	private static final String TAG = "ViewHolderVideo";
	@BindView( R.id.profile_image )
	CircleImageView    profileImage;
	@BindView( R.id.textViewPopularFeedName )
	AppCompatTextView  textViewPopularFeedName;
	@BindView( R.id.textViewPopularTime )
	AppCompatTextView  textViewPopularTime;
	@BindView( R.id.textViewPopularTitle )
	AppCompatTextView  textViewPopularTitle;
	@BindView( R.id.video_view )
	EMVideoView        emVideoView;
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
	@BindView( R.id.layoutFooterToolbar )
	LinearLayout       layoutFooterToolbar;

	@BindView( R.id.imageViewThumbnail_video )
	AppCompatImageView imageViewThumbnail_video;

	int visiblePosition;
	String thumbNailImage = "http://www.gstatic.com/webp/gallery/1.jpg";
	private ModelVideo modelVideo;

	public ViewHolderVideo( View itemView ) {
		super( itemView );
		ButterKnife.bind( this, itemView );
	}

	public void setData( ModelVideo object ) {
		this.modelVideo = object;
		this.visiblePosition = visiblePosition;
		updateUi();
	}

	public void setupVideoView() {
		String videoUrl = "https://archive.org/download/Popeye_forPresident/Popeye_forPresident_512kb.mp4";
		emVideoView.setVideoURI( Uri.parse( videoUrl ) );
		emVideoView.setOnPreparedListener( new OnPreparedListener() {
			@Override
			public void onPrepared() {
				emVideoView.start();
			}
		} );
	}


	private void updateUi() {
		textViewPopularTitle.setText( modelVideo.videoName );
		textViewUpDownCount.setText( "123" );
		textViewPopularFeedName.setText( modelVideo.videoDesc );


		/*Glide.with( imageViewThumbnail_video.getContext() ).load( thumbNailImage )
				.thumbnail( 0.5f )
				.crossFade()
				.diskCacheStrategy( DiskCacheStrategy.ALL )
				.into( imageViewThumbnail_video );*/

	}

	@Override
	public void onPrepared( MediaPlayer mediaPlayer ) {

	}
}