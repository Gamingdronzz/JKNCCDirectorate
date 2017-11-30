package com.jknccdirectorate.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jknccdirectorate.Adapter.ComplexRecyclerViewAdapter;
import com.jknccdirectorate.Model.EditTextModel;
import com.jknccdirectorate.R;

import java.util.ArrayList;

/**
 * Created by hp on 30-11-2017.
 */

public class EventsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ComplexRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        getSupportActionBar().setTitle("EVENT");

        findviews();
        adapter = new ComplexRecyclerViewAdapter(getSampleArrayList(),null,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    private void findviews() {
        recyclerView = (RecyclerView) findViewById(R.id.events_recyclerView);

    }

    private ArrayList<Object> getSampleArrayList() {

        ArrayList<Object> items = new ArrayList<>();

        items.add(new EditTextModel("Event Date"));
        items.add(new EditTextModel("Event Heading"));
        items.add(new EditTextModel("Event Description"));
        return items;
    }

}
