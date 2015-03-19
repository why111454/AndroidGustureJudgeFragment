package com.yun.context;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidmovejudge.R;
import com.yun.gusture.GustureJudgeFragment;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends GustureJudgeFragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			container.setOnTouchListener(this);
			return rootView;
		}
		@Override
		public void leftGlide(int glideLevel) {
			Log.v("yunye", "leftGlide level:"+glideLevel);
		}

		@Override
		public void rightGlide(int glideLevel) {
			Log.v("yunye", "rightGlide level:"+glideLevel);
		}

		@Override
		public void upGlide(int glideLevel) {
			Log.v("yunye", "upGlide level:"+glideLevel);
		}

		@Override
		public void downGlide(int glideLevel) {
			Log.v("yunye", "downGlide level:"+glideLevel);
		}
	}

}
