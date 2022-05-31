package com.example.json_lab_task;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnGetData;
    ListView listView;
    final String URL = "http://api.aladhan.com/v1/calendarByCity?city=Lahore&country=Pakistan&method=2&month=05&year=2022";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGetData = findViewById(R.id.btnGetData);
        listView = findViewById(R.id.listView);
    }

    public void onClickGetData(View view){

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        ArrayList<Prayer> prayerTimes = new ArrayList<>();
                        JSONObject time = null;
                        Prayer prayerTime = null;

                        try {
                            JSONArray data = response.getJSONArray("data");

                            for(int i=0;i<data.length();i++)
                            {
                                time = data.getJSONObject(i).getJSONObject("timings");
                                prayerTime = new Prayer(
                                        time.getString("Fajr"),
                                        time.getString("Dhuhr"),
                                        time.getString("Asr"),
                                        time.getString("Maghrib"),
                                        time.getString("Isha")
                                );
                                Log.d("PrayerTime","\nFajr : "+prayerTime.getFajrTime()+"\n");
                                prayerTimes.add(prayerTime);
                            }

                            ListAdapter listAdapter = new ListAdapter(MainActivity.this, prayerTimes);
                            listView.setAdapter(listAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d("JSON_APP",e.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("JSON_APP",error.getMessage());
                    }
                });
        requestQueue.add(jsonObjectRequest);

    }
}