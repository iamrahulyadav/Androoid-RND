package spinfotech.androidresearchdev.spm.utility;

/**
 * Created by sibaprasad on 05/09/17.
 */

public class Constants {
	public interface TaskConstants {
		int TASK_MEMORY_MNGMT = 0;
		int TASK_BITMAP_MNGMT = 1;
		int TASK_LAZY_LOADING = 2;
		int TASK_PERFORMANCE = 3;
		int TASK_MVC = 4;
		int TASK_MVP = 5;
		int TASK_MVVM = 6;
		int TASK_RXJAVA = 7;
		int TASK_REALM = 8;
		int TASK_RETROFIT = 9;
		int TASK_VOLLEY = 10;
		int TASK_DATABASE = 11;
		int TASK_SECURITY = 12;
		int TASK_CUSTOM_VIEW = 13;
		int TASK_FRAGMENT = 14;
		int TASK_GCM = 15;
		int TASK_FCM = 16;
		int TASK_FIREBASE = 17;


		int TASK_BROADCAST = 18;
		int TASK_NOTIFICATION = 19;
		int TASK_SERVICE = 20;
		int TASK_INTENT_SERVICE = 21;
		int TASK_RESULT_RECIEVER = 22;
		int TASK_BIND_SERVICE = 23;
		int TASK_CUSTOM_NOTIFICATION = 24;


		int TASK_ALARM = 25;

		int TASK_ANDROID_L = 26;
		int TASK_ANDROID_M =27;
		int TASK_ANDROID_N = 28;
		int TASK_ANDROID_O = 29;

		int TASK_PAYU = 30;
		int TASK_PAYPAL = 31;
		int TASK_INAPP_PURCHASE = 32;

		int TASK_OBSERVER_PATTERN = 33;
		int TASK_LIVE_DATA = 34;



		int TASK_GEOFENCING = 35;
		int TASK_GOOGLEMAP = 36;
		int TASK_ENCRIPTION_DECRIPTION = 37;
		int TASK_NDK = 38;

		int TASK_LIFE_CYCLE_OWNER = 39;
		int TASK_LIFE_CYCLE_ACTIVITY = 40;
		int TASK_ROOM = 41;
		int TASK_UI_PERFORMANCE = 42;
		int TASK_JOB_SCHEDULER = 41;
		int TASK_SYNC_ADAPTER = 41;
		int TASK_ANIMATION = 41;
		int TASK_GOOGLE_VISION = 41;
	}

	public static final int ROW_HEADER                  = 1;
	public static final int ROW_FOOTER                  = 2;
	public static final int ROW_POPULAR_IMAGE           = 3;
	public static final int ROW_IMAGE                   = 4;
	public static final int ROW_MESSAGE                 = 5;
	public static final int ROW_TEXT                    = 6;
	public static final int ROW_IMAGE_WITH_TEXT         = 7;
	public static final int ROW_VIDEO                   = 8;
	public static final int ROW_DEFAULT                 = 9;
	public static final int ROW_POPULAR_GIF           = 10;
	public static final int ROW_POPULAR_TEXT            = 11;
	public static final int ROW_POPULAR_IMAGE_WITH_TEXT = 12;


	public static final int ROW_PENDING                  = 20;
	public static final int ROW_COMPLETED                  = 21;
	public static final int ROW_UPCOMMING           = 22;



	public static final String TAB_NOTIFICATION = "NOTIFICATION";
	public static final String TAB_MESSAGE      = "MESSAGE";
	public static final String TAB_MODMAIL      = "MOD MAIL";
	public static final String TAB_HOME         = "Home";
	public static final String TAB_POPULAR      = "Popular";

	public static final String TAB_POSTS     = "POSTS";
	public static final String TAB_COMMENTS         = "Comments";
	public static final String TAB_ABOUT      = "About";

	public interface BundleKeys {
		public static final String FROM_WHICH_SCREEN = "fromWhichScreen";
		public static final String USER_NAME         = "userName";
		public static final String USER_ID           = "userId";
		public static final String KEY               = "key";
		public static final String TAB_TITLE         = "tabTitle";


		public static final byte   SPLASH_SCREEN  = 0;
		public static final int    HOME_SCREEN    = 1;
		public static final int    ACCOUNT_SCREEN = 2;
		public static final int    MAIL_SCREEN    = 3;
		public static final int    OTHERS_SCREEN  = 4;
		public static final int    COMMENT_SCREEN = 5;


		public static final String TITLE          = "tabTitle";
		public static final String POSITION       = "position";


		public static final String CHILD_OBJECT = "ChildObject";
	}

	public interface ErrorType {
		public static final byte NO_INTERNET_CONNECTION = 0;
		public static final int  INVALID_EMAIL          = 1;
		public static final int  INVALID_PASSWORD       = 2;
		public static final int  NETWORK_ERROR          = 3;
		public static final int  OTHERS_SCREEN          = 4;
		public static final int  INVALID_MOBILE         = 5;
		public static final int  INVALID_NAME           = 6;
	}

	public interface BottomTab {
		public static final int TAB_HOME        = 0;
		public static final int TAB_COMMUNITIES = 1;
		public static final int TAB_EMAIL       = 2;
		public static final int TAB_PROFILE     = 3;
	}
}
