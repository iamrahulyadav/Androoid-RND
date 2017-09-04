package spinfotech.androidresearchdev.nidhi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import spinfotech.androidresearchdev.R;

/**
 * Created by sibaprasad on 04/09/17.
 */

public class NidhiMainActivity extends AppCompatActivity implements View.OnClickListener{

	@BindView( R.id.tvCustomView )
	AppCompatTextView tvCustomView;


	@Override
	protected void onCreate( @Nullable Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_nidhi_main );
		ButterKnife.bind( this );

	}

	@Override
	public void onClick( View view ) {
		switch ( view.getId() ){

			case R.id.tvCustomView :

				break;

		}
	}
}
