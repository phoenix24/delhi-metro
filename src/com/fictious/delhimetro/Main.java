package com.fictious.delhimetro;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Main extends ListActivity {

	private static final int HELP_ID = Menu.FIRST;
	private static final int ABOUT_ID = Menu.FIRST + 1;
	private static final int SETTINGS_ID = Menu.FIRST + 2;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		String[] metro_lines = getResources().getStringArray(
				R.array.metro_lines);
		ListAdapter adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, metro_lines);
		setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Intent intent = new Intent(this, Stations.class);

		if (position == 0)
			intent.putExtra("RED_LINE", true);
		if (position == 1)
			intent.putExtra("BLUE_LINE", true);
		if (position == 2)
			intent.putExtra("GREEN_LINE", true);
		if (position == 3)
			intent.putExtra("YELLOW_LINE", true);
		if (position == 4)
			intent.putExtra("ORANGE_LINE", true);
		if (position == 5)
			intent.putExtra("VOILET_LINE", true);

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
//				Intent intent = new Intent(Intent.ACTION_VIEW);
//				intent.setClassName(this, About.class.getName());
//				startActivity(intent);
		        AlertDialog.Builder builder = new AlertDialog.Builder(this);
		        builder.setTitle("about title");
		        builder.setMessage("about message");
		        builder.setIcon(R.drawable.launcher_icon);
		        builder.setPositiveButton("browser", null);
		        builder.setNegativeButton("cancel", null);
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