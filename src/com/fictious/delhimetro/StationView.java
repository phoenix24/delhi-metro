package com.fictious.delhimetro;

import android.app.Activity;
import android.os.Bundle;

public class StationView extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
//        Intent intent = getIntent();
        setContentView(R.layout.main);
    }
}