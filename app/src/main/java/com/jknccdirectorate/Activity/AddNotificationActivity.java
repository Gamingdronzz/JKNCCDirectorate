package com.jknccdirectorate.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jknccdirectorate.Adapter.ComplexRecyclerViewAdapter;
import com.jknccdirectorate.Model.FileModel;
import com.jknccdirectorate.R;

import java.util.ArrayList;

public class AddNotificationActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ComplexRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notification);
        getSupportActionBar().setTitle("NOTIFICATION");

        findviews();
        adapter = new ComplexRecyclerViewAdapter(getSampleArrayList(), null, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    private void findviews() {
        recyclerView = (RecyclerView) findViewById(R.id.notification_recyclerView);

    }

    private ArrayList<Object> getSampleArrayList() {

        ArrayList<Object> items = new ArrayList<>();

        items.add(new FileModel("Choose File"));

        return items;
    }
}
