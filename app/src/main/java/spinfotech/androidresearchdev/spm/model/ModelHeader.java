package spinfotech.androidresearchdev.spm.model;


import spinfotech.androidresearchdev.spm.utility.Constants;

/**
 * Created by sibaprasad on 23/06/17.
 */

public class ModelHeader /*extends Object implements Parcelable */{

	public String textTitle;
	public String comment;
	public int rowType = Constants.ROW_TEXT;

	public ModelHeader(   ) {

	}

	public ModelHeader( String textTitle, String comment, int rowType ) {
		this.textTitle = textTitle;
		this.comment = comment;
		this.rowType = rowType;
	}


	/*@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel( Parcel dest, int flags ) {
		dest.writeString( this.textTitle );
		dest.writeInt( this.rowType );
	}

	protected ModelText( Parcel in ) {
		this.textTitle = in.readString();
		this.rowType = in.readInt();
	}

	public static final Creator< ModelText > CREATOR = new Creator< ModelText >() {
		@Override
		public ModelText createFromParcel( Parcel source ) {
			return new ModelText( source );
		}

		@Override
		public ModelText[] newArray( int size ) {
			return new ModelText[size];
		}
	};*/
}
