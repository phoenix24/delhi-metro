package com.fictious.delhimetro;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

public class Main extends ListActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        
        ListAdapter adapter = createAdapter();
        setListAdapter(adapter);
        
    }
    
    private ListAdapter createAdapter() {
    	String[] lines = new String[] {
    			"red line",
    			"blue line",
    			"green line",
    			"orange line",
    			"voilet line",
    			"yellow line"
    	};
    	
    	ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lines);
        return adapter;
    }
    
    private ListAdapter lineAdapter() {
    	String[] redline = new String[] {
    			"Central Secretariat",
    			"Khan Market",
    			"Jawaharlal Nehru Stadium",
    			"Jangpura",
    			"Lajpat Nagar",
    			"Moolchand",
    			"Kailash Colony",
    			"Nehru Place",
    			"Kalkaji Mandir",
    			"Govind Puri",
    			"Okhla",
    			"Jasola",
    			"Sarita Vihar",
    			"Mohan Estate",
    			"Tughlakabad",
    			"Badarpur"
    	};
    	
    	return null;
    }
}