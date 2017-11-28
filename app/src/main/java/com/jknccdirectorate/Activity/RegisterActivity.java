package com.jknccdirectorate.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ExpandableListView;

import com.jknccdirectorate.Adapter.ComplexRecyclerViewAdapter;
import com.jknccdirectorate.Model.DropdownModel;
import com.jknccdirectorate.Model.EditTextModel;
import com.jknccdirectorate.R;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ComplexRecyclerViewAdapter adapter;
    String[] cadreList = {"abc", "xyz", "pqr"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Register");

        findviews();
        adapter = new ComplexRecyclerViewAdapter(getSampleArrayList(),null,null);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    private void findviews() {
        recyclerView = (RecyclerView) findViewById(R.id.registration_recyclerView);

    }

    private ArrayList<Object> getSampleArrayList() {

        ArrayList<Object> items = new ArrayList<>();

        items.add(new EditTextModel("Name"));
        items.add(new DropdownModel("Cadre", cadreList));
        items.add(new DropdownModel("Level", cadreList));
        items.add(new DropdownModel("Designation", cadreList));
        items.add(new EditTextModel("Father Name"));
        items.add(new EditTextModel("Address"));
        items.add(new EditTextModel("Service Number"));
        items.add(new EditTextModel("E-Mail"));
        items.add(new EditTextModel("Mobile Number"));
        items.add(new EditTextModel("Machine Number"));
        items.add(new DropdownModel("Monthly Income from all sources", cadreList));
        items.add(new DropdownModel("Category", cadreList));
        items.add(new DropdownModel("Category", cadreList));
        return items;
    }
}
