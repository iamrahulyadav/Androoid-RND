package spinfotech.androidresearchdev.multilevelRecyclerview;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

import spinfotech.androidresearchdev.R;

/**
 * Created by sibaprasad on 27/07/17.
 */

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ParentViewHolder>{

	List<ChildModel> mListChild;
	LayoutInflater inflater;
	int mSelectedChildPosition;
	int mParentPosition;
	LikeClickListener mLikeClickListener;
	public ChildAdapter( Context mContext, List< ChildModel > mListChildList,int parentPosition,
	                     int selectedChildPosition,LikeClickListener likeClickListener ) {
		this.mListChild = mListChildList;
		inflater = LayoutInflater.from( mContext);
		this.mParentPosition= parentPosition;
		this.mSelectedChildPosition = selectedChildPosition;
		this.mLikeClickListener = likeClickListener;
	}

	@Override
	public ParentViewHolder onCreateViewHolder( ViewGroup parent, int viewType ) {
		View view = inflater.inflate( R.layout.row_item_child, parent, false);
		ParentViewHolder holder = new ParentViewHolder(view);
		return holder;
	}

	@Override
	public void onBindViewHolder( ParentViewHolder holder, final int position ) {

		if(mListChild.get( position ).isLiked /*mSelectedChildPosition != -1 && mSelectedChildPosition == position*/ ){
			holder.tvLiked.setTextColor( ContextCompat.getColor( holder.tvLiked.getContext(),R.color.colorBlack ) );
			holder.tvLiked.setText( "Liked" );
			holder.imageViewLike.setImageResource( R.mipmap.ic_not_wishlist );
			holder.imageViewLike.setColorFilter(ContextCompat.getColor(holder.tvLiked.getContext(),R.color.colorAccent));
		}
		else{
			holder.tvLiked.setTextColor( ContextCompat.getColor( holder.tvLiked.getContext(),R.color.colorBlack ) );
			holder.tvLiked.setText( "Not Liked" );
			holder.imageViewLike.setImageResource( R.mipmap.ic_not_wishlist );
			holder.imageViewLike.setColorFilter(ContextCompat.getColor(holder.tvLiked.getContext(),R.color.colorBlack));

		}

		holder.imageViewLike.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick( View view ) {
				mLikeClickListener.onLikeClicked( mParentPosition,position );
			}
		} );

		holder.tvTitleChild.setText( mListChild.get( position ).title );
	}

	@Override
	public int getItemCount() {
		return mListChild.size();
	}

	public class ParentViewHolder extends RecyclerView.ViewHolder{
		AppCompatTextView tvLiked;
		AppCompatTextView tvTitleChild;
		AppCompatImageView imageViewLike;
		public ParentViewHolder( View itemView ) {
			super( itemView );
			tvTitleChild = (AppCompatTextView ) itemView.findViewById( R.id.tvTitleChild);
			tvLiked = (AppCompatTextView ) itemView.findViewById( R.id.tvLiked );
			imageViewLike = (AppCompatImageView ) itemView.findViewById( R.id.imageViewLike );
		}
	}
}
