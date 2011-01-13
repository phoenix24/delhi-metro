package com.fictious.delhimetro;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RowLine extends BaseAdapter  {
	
	private ArrayList<MetroLine> metro_lines;
	private LayoutInflater mInflater;
	
	public RowLine(Context context) {
		mInflater = LayoutInflater.from(context);
		metro_lines = new ArrayList<MetroLine>();
		metro_lines.add(new MetroLine(context, R.string.red_line, R.array.red_line_stations, R.drawable.red_line_icon));
		metro_lines.add(new MetroLine(context, R.string.blue_line, R.array.blue_line_stations, R.drawable.blue_line_icon));
		metro_lines.add(new MetroLine(context, R.string.green_line, R.array.green_line_stations, R.drawable.green_line_icon));
		metro_lines.add(new MetroLine(context, R.string.yellow_line, R.array.yellow_line_stations, R.drawable.yellow_line_icon));
		metro_lines.add(new MetroLine(context, R.string.orange_line, R.array.orange_line_stations, R.drawable.orange_line_icon));
		metro_lines.add(new MetroLine(context, R.string.voilet_line, R.array.voilet_line_stations, R.drawable.voilet_line_icon));
	}
	
    /**
     * The number of items in the list is determined by the number of speeches
     * in our array.
     *
     * @see android.widget.ListAdapter#getCount()
     */
    public int getCount() {
        return metro_lines.size();
    }

    /**
     * Since the data comes from an array, just returning the index is
     * sufficent to get at the data. If we were using a more complex data
     * structure, we would return whatever object represents one row in the
     * list.
     *
     * @see android.widget.ListAdapter#getItem(int)
     */
    public Object getItem(int position) {
        return position;
    }

    /**
     * Use the array index as a unique id.
     * @see android.widget.ListAdapter#getItemId(int)
     */
    public long getItemId(int position) {
        return position;
    }

    /**
     * Make a view to hold each row.
     *
     * @see android.widget.ListAdapter#getView(int, android.view.View,
     *      android.view.ViewGroup)
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        // A ViewHolder keeps references to children views to avoid unneccessary calls
        // to findViewById() on each row.
        ViewHolder holder;

        // When convertView is not null, we can reuse it directly, there is no need
        // to reinflate it. We only inflate a new View when the convertView supplied
        // by ListView is null.
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.main_rows, null);

            // Creates a ViewHolder and store references to the two children views
            // we want to bind data to.
            holder = new ViewHolder();
            holder.icon = (ImageView) convertView.findViewById(R.id.icon);
            holder.line = (TextView) convertView.findViewById(R.id.label);
            holder.lowerline = (TextView) convertView.findViewById(R.id.lowerline);

            convertView.setTag(holder);
        } else {
            // Get the ViewHolder back to get fast access to the TextView
            // and the ImageView.
            holder = (ViewHolder) convertView.getTag();
        }

        // Bind the data efficiently with the holder.
        MetroLine mtr = metro_lines.get(position);
        holder.line.setText(mtr.line);
        holder.lowerline.setText(mtr.stations[0] + " - " + mtr.stations[mtr.stations.length - 1]);
        holder.icon.setImageBitmap(mtr.icon);
//        convertView.setBackgroundColor(R.color.solid_green);

        return convertView;
    }

    static class ViewHolder {
    	ImageView icon;
        TextView line;
        TextView lowerline;
    }
}
