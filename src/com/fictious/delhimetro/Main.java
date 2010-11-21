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

public class Main extends ListActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    	String[] metro_lines = getResources().getStringArray(R.array.metro_lines);
    	ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, metro_lines);
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
}