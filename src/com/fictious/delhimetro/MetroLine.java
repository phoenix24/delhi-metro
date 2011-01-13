package com.fictious.delhimetro;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class MetroLine {
	Bitmap icon;
	String line;
	String[] stations;
	
	public MetroLine(Context context, int line, int stations, int icon) {
		this.line = context.getResources().getString(line);
		this.stations = context.getResources().getStringArray(stations);
		this.icon = BitmapFactory.decodeResource(context.getResources(), icon);
	}
}
