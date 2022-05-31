package com.example.json_lab_task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    TextView tvFajrTime,tvDhuhrTime,tvAsrTime,tvMaghribTime,tvIshaTime;
    TextView tvDayNumber;
    ArrayList<Prayer> prayerTimes;
    Context context;
    LayoutInflater layoutInflater;

    public ListAdapter(Context context, ArrayList<Prayer> prayerTimes) {
        this.prayerTimes = prayerTimes;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return prayerTimes.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View newView = layoutInflater.inflate(R.layout.listview_item,null);

        tvFajrTime = newView.findViewById(R.id.tvFajrTime);
        tvDhuhrTime = newView.findViewById(R.id.tvDhuhrTime);
        tvAsrTime = newView.findViewById(R.id.tvAsrTime);
        tvMaghribTime = newView.findViewById(R.id.tvMaghribTime);
        tvIshaTime = newView.findViewById(R.id.tvIshaTime);
        tvDayNumber = newView.findViewById(R.id.tvDayNumber);

        tvFajrTime.setText(prayerTimes.get(i).getFajrTime());
        tvDhuhrTime.setText(prayerTimes.get(i).getDhuhrTime());
        tvAsrTime.setText(prayerTimes.get(i).getAstTime());
        tvMaghribTime.setText(prayerTimes.get(i).getMaghribTime());
        tvIshaTime.setText(prayerTimes.get(i).getIshaTime());
        tvDayNumber.setText(""+(i+1));

        return newView;
    }
}
