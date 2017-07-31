package spinfotech.androidresearchdev.multilevelRecyclerview;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
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

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ParentViewHolder>{

	List<ParentModel> mListParentList;
	LayoutInflater inflater;
	int mRefreshPosition = -1;
	int mselectedChildPosition = -1;
	LikeClickListener mLikeClickListener;
Context mContext;


	public ParentAdapter( Context context, List< ParentModel > mListParentList,LikeClickListener likeClickListener ) {
		this.mListParentList = mListParentList;
		this.mLikeClickListener = likeClickListener;
		this.mContext = context;
		inflater = LayoutInflater.from( mContext);
	}

	@Override
	public ParentViewHolder onCreateViewHolder( ViewGroup parent, int viewType ) {
		View view = inflater.inflate( R.layout.row_item_parent, parent, false);
		ParentViewHolder holder = new ParentViewHolder(view);
		return holder;
	}

	@Override
	public void onBindViewHolder( ParentViewHolder holder, int position ) {

		if(mRefreshPosition != -1 && mRefreshPosition == position ){
			holder.rootParent.setBackgroundColor( ContextCompat.getColor( holder.rootParent.getContext(),R.color.colorAccent ) );

			ChildAdapter childAdapter = new ChildAdapter( mContext,
			                                              mListParentList.get( position ).listChild,
			                                              position,
			                                              mselectedChildPosition,
			                                              this.mLikeClickListener );
			holder.recyclerViewChild.setLayoutManager( new LinearLayoutManager( holder.recyclerViewChild.getContext(),LinearLayoutManager.HORIZONTAL,false ) );
			holder.recyclerViewChild.setAdapter( childAdapter );
			holder.tvTitleParent.setText( mListParentList.get( position ).title );
		}
		else{
			holder.rootParent.setBackgroundColor( ContextCompat.getColor( holder.rootParent.getContext(),R.color.colorWhite ) );

			ChildAdapter childAdapter = new ChildAdapter( mContext,
			                                              mListParentList.get( position ).listChild,
			                                              position,
			                                              -1,
			                                              this.mLikeClickListener );
			holder.recyclerViewChild.setLayoutManager( new LinearLayoutManager( holder.recyclerViewChild.getContext(),LinearLayoutManager.HORIZONTAL,false ) );
			holder.recyclerViewChild.setAdapter( childAdapter );
			holder.tvTitleParent.setText( mListParentList.get( position ).title );
		}


	}

	@Override
	public int getItemCount() {
		return mListParentList.size();
	}

	public class ParentViewHolder extends RecyclerView.ViewHolder{
		LinearLayout      rootParent;
		AppCompatTextView tvTitleParent;
		RecyclerView recyclerViewChild;
		public ParentViewHolder( View itemView ) {
			super( itemView );
			rootParent = (LinearLayout ) itemView.findViewById( R.id.rootParent);
			tvTitleParent = (AppCompatTextView ) itemView.findViewById( R.id.tvTitleParent );
			recyclerViewChild = (RecyclerView ) itemView.findViewById( R.id.recyclerViewChild);
		}
	}
	public void setRowToRefresh(int refreshPosition,int selectedChildPosition){
		this.mRefreshPosition = refreshPosition;
		this.mselectedChildPosition = selectedChildPosition;
		notifyDataSetChanged();
	}
}
