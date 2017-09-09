package spinfotech.androidresearchdev.spm.listeners;

import spinfotech.androidresearchdev.spm.model.ModelHeader;
import spinfotech.androidresearchdev.spm.model.home.Child;

public interface OnRecyclerItemClickListener {
	public void onCommentClick( Child child );

	public void onFeedClick( Child child );

	public void onShareClick( Child child );

	public void onUpClick( Child child );

	public void onDownClick( Child child );
}