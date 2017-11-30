package com.jknccdirectorate.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jknccdirectorate.Adapter.ComplexRecyclerViewAdapter;
import com.jknccdirectorate.Model.DropdownModel;
import com.jknccdirectorate.Model.EditTextModel;
import com.jknccdirectorate.R;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ComplexRecyclerViewAdapter adapter;
    String[] cadreList = {"Choose Cadre", "Army", "GCI","ANO","Civilian","Cadet"};
    String[] levelList = {"Choose Level", "DTE", "GP","Unit","Institute"};
    String[] monthlyIncomeList = {"Choose Monthly Income", "Less Than 5000"};
    String[] designationList = {"Choose Designation"};
    String[] categoryList = {"Choose Category"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Register");

        findviews();
        adapter = new ComplexRecyclerViewAdapter(getSampleArrayList(),null,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    private void findviews() {
        recyclerView = (RecyclerView) findViewById(R.id.registration_recyclerView);

    }

    private ArrayList<Object> getSampleArrayList() {

        ArrayList<Object> items = new ArrayList<>();

        items.add(new EditTextModel("Name",R.drawable.ic_action_person));

        items.add(new EditTextModel("Father Name",R.drawable.ic_action_person));
        items.add(new EditTextModel("Address",R.drawable.ic_action_address));
        items.add(new EditTextModel("Service Number",R.drawable.ic_action_settings));
        items.add(new EditTextModel("E-Mail",R.drawable.ic_action_email));
        items.add(new EditTextModel("Mobile Number",R.drawable.ic_action_contact));
        items.add(new EditTextModel("Machine Number",R.drawable.ic_action_machine));
        items.add(new DropdownModel("Monthly Income from all sources", monthlyIncomeList,R.drawable.ic_action_income));
        items.add(new DropdownModel("Cadre", cadreList,R.drawable.ic_action_designation));
        items.add(new DropdownModel("Level", levelList,R.drawable.ic_action_designation));
        items.add(new DropdownModel("Designation", designationList,R.drawable.ic_action_designation));
        items.add(new DropdownModel("Category", categoryList,R.drawable.ic_action_category));
        items.add(new DropdownModel("Category", categoryList,R.drawable.ic_action_category));
        return items;
    }
}
