package spinfotech.androidresearchdev.spm.multilevelRecyclerview;

/**
 * Created by sibaprasad on 28/07/17.
 */

public class ChildModel {
	public boolean isLiked = false;
	public String title;

	public ChildModel(  String title,boolean isLiked ) {
		this.isLiked = isLiked;
		this.title = title;
	}
}
