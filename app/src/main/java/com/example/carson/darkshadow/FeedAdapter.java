package com.example.carson.darkshadow;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Carson on 1/30/2017.
 */

public class FeedAdapter extends ArrayAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private ArrayList<FeedItem> items;

    public FeedAdapter(Activity activity, int resource, ArrayList<FeedItem> items) {
        super(activity, resource);
        this.activity = activity;
        this.items = items;
    }

    public int getCount(){
        return items.size();
    }

    public View getView(int position, View convertView, ViewGroup parent){
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.feed_item, null);

        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView status = (TextView) convertView.findViewById(R.id.status);
        //TextView time = (TextView) convertView.findViewById(R.id.time);
        ImageView profile = (ImageView) convertView.findViewById(R.id.profilepic);

        FeedItem item = items.get(position);
        name.setText(item.getName());
        status.setText(item.getStatus());
        //time.setText(item.getTimeStamp());
        profile.setImageDrawable(item.getProfilePic());

        return convertView;

    }
}
