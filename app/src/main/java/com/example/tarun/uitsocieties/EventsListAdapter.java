package com.example.tarun.uitsocieties;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tarun on 16-Sep-17.
 */

public class EventsListAdapter extends ArrayAdapter<EventsDataModel> {

    private Context con;
    private ArrayList<EventsDataModel> events_data;
    private TextView name, month, date, day, time, place, city;

    public EventsListAdapter(Context context, ArrayList<EventsDataModel> data) {
        super(context, 0, data);
        con = context;
        events_data = data;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View eventListItemView = convertView;
        if(eventListItemView==null){
            eventListItemView = LayoutInflater.from(con).inflate(R.layout.event_list_item,parent,false);
        }

        name = eventListItemView.findViewById(R.id.ename);
        month = eventListItemView.findViewById(R.id.emonth);
        date = eventListItemView.findViewById(R.id.edate);
        day = eventListItemView.findViewById(R.id.eday);
        time = eventListItemView.findViewById(R.id.etime);
        place = eventListItemView.findViewById(R.id.eplace);
        city = eventListItemView.findViewById(R.id.ecity);

        EventsDataModel curr_obj = getItem(position);

        //  TODO --> ADD TEXT VIEW FOR "PAST EVENTS" AND "UPCOMING EVENTS"

        try {
            name.setText(curr_obj.getEvent_name());
            month.setText(curr_obj.getMonth());
            date.setText(curr_obj.getDate());
            day.setText(curr_obj.getDay());
            time.setText(curr_obj.getTime());
            place.setText(curr_obj.getPlace_name());
            city.setText(curr_obj.getCity());

        }
        catch (Exception e){
            Log.v("Exception---",e.toString());
        }

        eventListItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  TODO -->  DETAILED EVENTS ACTIVITY
            }
        });
        return eventListItemView;
    }
}