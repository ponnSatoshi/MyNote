package com.example.satoshiueno.mynote;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class MainActivity extends Activity implements LoaderManager.LoaderCallbacks {

	private SimpleCursorAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		String[] from = {
			MyMemoContract.Memos.COLUMN_TITLE,
			MyMemoContract.Memos.COLUMN_UPDATED
		};
		int[] to = {
			android.R.id.text1,
			android.R.id.text2
		};

		adapter = new SimpleCursorAdapter(
			this,
			android.R.layout.simple_list_item_2,
			null,
			from,
			to,
			0
		);

		ListView myListView = (ListView) findViewById(R.id.myListView);
		myListView.setAdapter(adapter);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
		//test
		//
	}

	@Override
	public Loader onCreateLoader(int id, Bundle args) {
		return null;
	}

	@Override
	public void onLoadFinished(Loader loader, Object data) {

	}

	@Override
	public void onLoaderReset(Loader loader) {

	}
}
