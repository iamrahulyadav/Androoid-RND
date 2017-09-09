package spinfotech.androidresearchdev.spm.adapters.viewholders;

import spinfotech.androidresearchdev.spm.model.ModelImage;
import spinfotech.androidresearchdev.spm.model.ModelImageText;
import spinfotech.androidresearchdev.spm.model.ModelMessage;
import spinfotech.androidresearchdev.spm.model.ModelText;
import spinfotech.androidresearchdev.spm.model.ModelVideo;
import spinfotech.androidresearchdev.spm.model.home.Child;
import spinfotech.androidresearchdev.spm.utility.Constants;

public class ViewHolderManager {

	public static int getRowType( Object object ) {
		int rowType = 0;

		if ( object instanceof ModelText ) {
			rowType = Constants.ROW_TEXT;
		}
		else if ( object instanceof ModelImageText ) {
			rowType = Constants.ROW_IMAGE_WITH_TEXT;
		}
		else if ( object instanceof ModelMessage ) {
			rowType = Constants.ROW_MESSAGE;
		}
		else if ( object instanceof ModelImage ) {
			rowType = Constants.ROW_IMAGE;
		}
		else if ( object instanceof ModelVideo ) {
			rowType = Constants.ROW_VIDEO;
		}
		else if ( object instanceof Child ) {
			Child feedData = ( Child ) object;

			if ( feedData.getData().getIsVideo() ) {
				rowType = Constants.ROW_POPULAR_IMAGE_WITH_TEXT;
			}

			if ( feedData != null && feedData.getData() != null && feedData.getData().getPreview() != null && feedData.getData().getPreview().getImages() != null && feedData.getData().getPreview().getImages().size() > 0 ) {
				rowType = Constants.ROW_POPULAR_GIF;
			}
			else {
				rowType = Constants.ROW_POPULAR_IMAGE_WITH_TEXT;
			}
		}

		return rowType;
	}

}