package spinfotech.androidresearchdev.multilevelRecyclerview;

import java.util.List;

/**
 * Created by sibaprasad on 27/07/17.
 */

public class ParentModel {
	public String       title;
	public List<ChildModel> listChild;

	public ParentModel( String title, List< ChildModel > listChild ) {
		this.title = title;
		this.listChild = listChild;
	}

}
