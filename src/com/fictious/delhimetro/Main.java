package com.fictious.delhimetro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Main extends ListActivity {

	private static final int HELP_ID = Menu.FIRST;
	private static final int ABOUT_ID = Menu.FIRST + 1;
	private static final int SETTINGS_ID = Menu.FIRST + 2;
	private static String [] metro_lines = {};

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		metro_lines = getResources().getStringArray(
				R.array.metro_lines);
		
//		ListAdapter adapter = new ArrayAdapter<String>(this,
//				R.layout.main_rows, R.id.label, metro_lines);
//		setListAdapter(adapter);
		
		setListAdapter(new SimpleAdapter(this, 
											getData(), 
											R.layout.main_rows, 
											new String[] { "label", "lowerline" }, 
											new int[] { R.id.label, R.id.lowerline }));
	}
	
	protected List getData() {
		List<Map> metrolines = new ArrayList<Map>();
		Map<String, Object> object;
		
		for(String line: metro_lines) {
			object = new HashMap<String, Object>();
			object.put("label", line);
			object.put("lowerline", "ouch! " + line);
			metrolines.add(object);
		}
		
		return metrolines;
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Intent intent = new Intent(this, Stations.class);
		String[] intentArray = {
				"RED_LINE",
				"BLUE_LINE",
				"GREEN_LINE",
				"YELLOW_LINE",
				"ORANGE_LINE",
				"VOILET_LINE"
		};

//		intent.putExtra(intentArray[position], true);
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
//				Intent intent = new Intent(Intent.ACTION_VIEW);
//				intent.setClassName(this, About.class.getName());
//				startActivity(intent);
		        AlertDialog.Builder builder = new AlertDialog.Builder(this);
		        
		        builder.setTitle(R.string.menu_about_title);
		        builder.setMessage(R.string.menu_about_message);
		        builder.setIcon(R.drawable.launcher_icon);
		        builder.setPositiveButton(R.string.menu_about_browser, null);
		        builder.setNegativeButton(R.string.menu_about_cancel, null);
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