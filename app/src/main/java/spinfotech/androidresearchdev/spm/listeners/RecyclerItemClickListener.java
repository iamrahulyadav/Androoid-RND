package spinfotech.androidresearchdev.spm.listeners;

/**
 * Created by sibaprasad on 03/09/17.
 */

public interface RecyclerItemClickListener {

	public static int CLICK_ITEM = 1;
	public static int CLICK_EDIT = 2;
	public static int CLICK_DELETE = 3;
	public static int CLICK_UPDATE = 4;
	public static int CLICK_COMMENT = 5;

	void onCLickAction(int actionType,int position);

}
