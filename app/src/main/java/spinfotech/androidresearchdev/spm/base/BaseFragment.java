package spinfotech.androidresearchdev.spm.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import butterknife.ButterKnife;
import spinfotech.androidresearchdev.R;

/**
 * Created by sibaprasad on 03/09/17.
 */

abstract public class BaseFragment extends Fragment {

	ProgressBar progressbarLoading ;
	private int mLayoutId;
	@Override
	public void onAttach( Context context ) {
		super.onAttach( context );
	}

	@Override
	public void onCreate( @Nullable Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
	}

	@Override
	public void onActivityCreated( @Nullable Bundle savedInstanceState ) {
		super.onActivityCreated( savedInstanceState );
	}

	@Nullable
	@Override
	public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {

		View rootView = inflater.inflate( R.layout.fragment_base,container,false );
		FrameLayout containerBase = (FrameLayout ) rootView.findViewById( R.id.containerBase );
		inflater.inflate(mLayoutId, containerBase);

		ButterKnife.bind( this, rootView);

		return rootView;

	}

	protected void setEmptyView(AppCompatTextView view) {
		view.setVisibility(View.VISIBLE);
		view.setText( R.string.data_not_available);
	}

	protected void setEmptyView( AppCompatTextView view, String message) {
		view.setText(message);
	}

	protected void hideProgressBar() {
		if (progressbarLoading != null)
			progressbarLoading.setVisibility(View.GONE);
	}

	protected void showProgressBar() {
		if (progressbarLoading != null)
			progressbarLoading.setVisibility(View.VISIBLE);
	}

	protected abstract void setTitle( int title );

	protected abstract void setLayout( int layout );

	protected abstract void setClickListeners();

	public abstract void setUpUI();


}
