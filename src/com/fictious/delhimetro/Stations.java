package com.fictious.delhimetro;

import java.util.Map;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Stations extends ListActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        
        Intent intent = getIntent();
        boolean red = intent.getBooleanExtra("RED_LINE", false);
        boolean blue = intent.getBooleanExtra("BLUE_LINE", false);
        boolean green = intent.getBooleanExtra("GREEN_LINE", false);
        boolean yellow = intent.getBooleanExtra("YELLOW_LINE", false);
        boolean orange = intent.getBooleanExtra("ORANGE_LINE", false);
        boolean voilet = intent.getBooleanExtra("VOILET_LINE", false);
        
    	String[] metro_line_stations = new String[] {};
    	
    	if (red)
    		metro_line_stations = getResources().getStringArray(R.array.red_line_stations);
    	
    	if (blue)
    		metro_line_stations = getResources().getStringArray(R.array.blue_line_stations);
    	
    	if (green)
    		metro_line_stations = getResources().getStringArray(R.array.green_line_stations);
    	
    	if (yellow)
    		metro_line_stations = getResources().getStringArray(R.array.yellow_line_stations);
    	
    	if (orange)
    		metro_line_stations = getResources().getStringArray(R.array.orange_line_stations);
    	
    	if (voilet)
    		metro_line_stations = getResources().getStringArray(R.array.voilet_line_stations);

    	ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, metro_line_stations);
        setListAdapter(adapter);
    }
    
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
//        Map map = (Map) l.getItemAtPosition(position);
//
//        Intent intent = (Intent) map.get("intent");
//        startActivity(intent);
        Toast.makeText(getApplicationContext(), ((TextView) v).getText(),
                Toast.LENGTH_SHORT).show();
    }
    
}