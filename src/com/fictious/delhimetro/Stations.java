package com.fictious.delhimetro;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Stations extends ListActivity {

	private static final int RED_LINE = 0;
	private static final int BLUE_LINE = 1;
	private static final int GREEN_LINE = 2;
	private static final int YELLOW_LINE = 3;
	private static final int ORANGE_LINE = 4;
	private static final int VOILET_LINE = 5;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.main);

		Intent intent = getIntent();
		int position = intent.getIntExtra("METRO_LINE", 0);
		String[] metro_line_stations = new String[] {};

		switch (position) {
		case RED_LINE: {
			metro_line_stations = getResources().getStringArray(
					R.array.red_line_stations);
			break;
		}
		case BLUE_LINE: {
			metro_line_stations = getResources().getStringArray(
					R.array.blue_line_stations);
			break;
		}
		case GREEN_LINE: {
			metro_line_stations = getResources().getStringArray(
					R.array.green_line_stations);
			break;
		}
		case YELLOW_LINE: {
			metro_line_stations = getResources().getStringArray(
					R.array.yellow_line_stations);
			break;
		}
		case ORANGE_LINE: {
			metro_line_stations = getResources().getStringArray(
					R.array.orange_line_stations);
			break;
		}
		case VOILET_LINE: {
			metro_line_stations = getResources().getStringArray(
					R.array.voilet_line_stations);
			break;
		}
		}

		ListAdapter adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, metro_line_stations);
		setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// Map map = (Map) l.getItemAtPosition(position);
		Intent intent = new Intent(this, StationView.class);
		startActivity(intent);
		// Toast.makeText(getApplicationContext(), ((TextView) v).getText(),
		// Toast.LENGTH_SHORT).show();
	}
}