package spinfotech.androidresearchdev.spm.materialAnimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import spinfotech.androidresearchdev.R;
import spinfotech.androidresearchdev.spm.base.BaseFragment;

/**
 * Created by sibaprasad on 03/09/17.
 */

public class AnimationFragment extends BaseFragment {

	@Nullable
	@Override
	public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
		setLayout( R.layout.fragment_animation );
		return super.onCreateView( inflater, container, savedInstanceState );
	}

	@Override
	protected void setTitle( int title ) {

	}

	@Override
	protected void setLayout( int layout ) {

	}

	@Override
	protected void setClickListeners() {

	}

	@Override
	public void setUpUI() {

	}

	private void makeCircularReavelAnim( AppCompatTextView view){


	}
}
