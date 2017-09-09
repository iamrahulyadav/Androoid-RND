package spinfotech.androidresearchdev.spm.bottomsheet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import spinfotech.androidresearchdev.R;

/**
 * Created by sibaprasad on 09/09/17.
 */

public class BottomsheetMainActivity extends AppCompatActivity implements View.OnClickListener{

	@BindView( R.id.bgLayout )
	CoordinatorLayout bgLayout;

	@BindView( R.id.button_1 )
	AppCompatButton button_1;

	@BindView( R.id.button_2 )
	AppCompatButton button_2;

	@BindView( R.id.button_3 )
	AppCompatButton button_3;

	AppCompatTextView tvShowHide;
	LinearLayout      llBotom;
	private BottomSheetDialog bottomSheetDialog;
	BottomSheetBehavior mBottomSheetBehavior1;

	@Override
	protected void onCreate( @Nullable Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_bottomsheet_main );
		ButterKnife.bind( this );
		button_1.setOnClickListener( this );

	}

	@Override
	public void onClick( View view ) {
		switch ( view.getId() ) {

			case R.id.button_1:
				showBottomsheet1();
				break;

			case R.id.button_2:

				break;

			case R.id.button_3:

				break;

		}
	}
	private void showBottomsheet1() {

		if ( bottomSheetDialog == null ) {
			bottomSheetDialog = new BottomSheetDialog( BottomsheetMainActivity.this );
		}

		bottomSheetDialog.setCanceledOnTouchOutside( false );
		bottomSheetDialog.setCancelable( false );

		bottomSheetDialog.setContentView( R.layout.bottomsheet_layout );
//		View view = findViewById( R.id.rootBottomSheet );
//		mBottomSheetBehavior1 = BottomSheetBehavior.from(view);
//

		llBotom    = (LinearLayout ) bottomSheetDialog.findViewById( R.id.llBotom );
		 tvShowHide = (AppCompatTextView ) bottomSheetDialog.findViewById( R.id.tvShowHide );

		 if(tvShowHide!=null) {
			 tvShowHide.setOnClickListener( new View.OnClickListener() {
				 @Override
				 public void onClick( View view ) {
					 if ( tvShowHide.getText().toString().equalsIgnoreCase( "Show" ) ) {
						 tvShowHide.setText( "Hide" );
						 llBotom.setVisibility( View.GONE );
					 }
					 else{
						 tvShowHide.setText( "Show" );
						 llBotom.setVisibility( View.VISIBLE );
					 }
				 }
			 } );
		 }


		bottomSheetDialog.show();
	}

}
