package spinfotech.androidresearchdev;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.OnClick;
import spinfotech.androidresearchdev.naresh.NareshMainActivity;
import spinfotech.androidresearchdev.nidhi.NidhiMainActivity;
import spinfotech.androidresearchdev.sarika.SarikaMainActivity;
import spinfotech.androidresearchdev.spm.SpmMainActivity;

/**
 * Created by sibaprasad on 27/07/17.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
	@Override
	protected void onCreate( @Nullable Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_main );

		findViewById( R.id.tvSarikaWorkShop ).setOnClickListener( this );
		findViewById( R.id.tvNidhiWorkShop ).setOnClickListener( this );
		findViewById( R.id.tvSpmWorkShop ).setOnClickListener( this );
		findViewById( R.id.tvNareshWorkShop ).setOnClickListener( this );
	}

	@Override
	public void onClick( View view ) {
		switch ( view.getId() ){
			case R.id.tvSarikaWorkShop :
				Intent intentSarikaWork = new Intent( MainActivity.this, SarikaMainActivity.class );
				startActivity( intentSarikaWork );
				break;
			case R.id.tvNidhiWorkShop :
				Intent intentNidhiWork = new Intent( MainActivity.this, NidhiMainActivity.class );
				startActivity( intentNidhiWork );
				break;
			case R.id.tvSpmWorkShop :
				Intent intentSpmWork = new Intent( MainActivity.this, SpmMainActivity.class );
				startActivity( intentSpmWork );
				break;
			case R.id.tvNareshWorkShop :
				Intent intentNareshWork = new Intent( MainActivity.this, NareshMainActivity.class );
				startActivity( intentNareshWork );
				break;
		}
	}
}
