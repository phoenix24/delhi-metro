package com.fictious.delhimetro;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class Main extends ListActivity {

	private static final int HELP_ID = Menu.FIRST;
	private static final int ABOUT_ID = Menu.FIRST + 1;
	private static final int SETTINGS_ID = Menu.FIRST + 2;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new RowLine(this));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Intent intent = new Intent(this, Stations.class);
		intent.putExtra("METRO_LINE", position);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);

		menu.add(0, HELP_ID, Menu.NONE, R.string.menu_help).setIcon(
				android.R.drawable.ic_menu_help);
		menu.add(0, ABOUT_ID, Menu.NONE, R.string.menu_about).setIcon(
				android.R.drawable.ic_dialog_info);
		menu.add(0, SETTINGS_ID, Menu.NONE, R.string.menu_settings).setIcon(
				android.R.drawable.ic_menu_preferences);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
			case HELP_ID: {
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setClassName(this, Help.class.getName());
				startActivity(intent);
				break;
			}
			case ABOUT_ID: {
		        AlertDialog.Builder builder = new AlertDialog.Builder(this);
		        builder.setMessage(R.string.menu_about_message);
		        builder.setNegativeButton(R.string.menu_about_close, null);
		        builder.show();
				break;
			}
			case SETTINGS_ID: {
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setClassName(this, Settings.class.getName());
				startActivity(intent);
				break;
			}
		}
		return super.onOptionsItemSelected(item);
	}
}