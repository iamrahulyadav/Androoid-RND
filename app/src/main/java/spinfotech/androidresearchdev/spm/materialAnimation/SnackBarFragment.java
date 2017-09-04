package spinfotech.androidresearchdev.spm.materialAnimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import spinfotech.androidresearchdev.R;
import spinfotech.androidresearchdev.spm.base.BaseFragment;

/**
 * Created by sibaprasad on 03/09/17.
 */

public class SnackBarFragment extends BaseFragment implements View.OnClickListener{

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		setLayout( R.layout.fragment_snackbar);
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
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

	@Override
	public void onClick( View view ) {

	}
}
