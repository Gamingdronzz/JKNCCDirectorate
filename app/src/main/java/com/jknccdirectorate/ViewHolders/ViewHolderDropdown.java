package com.jknccdirectorate.ViewHolders;

import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jknccdirectorate.R;

/**
 * Created by hp on 11-09-2017.
 */

public class ViewHolderDropdown extends RecyclerView.ViewHolder {
    private TextView textview;
    private AppCompatSpinner dropdownlist;
    ArrayAdapter<String> arrayAdapter;


    public ViewHolderDropdown(View v) {
        super(v);
        arrayAdapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_dropdown_item_1line);
        textview = (TextView) v.findViewById(R.id.text_view_dropdown_title);
        dropdownlist = (AppCompatSpinner) v.findViewById(R.id.spinner_dropdown);
    }

    public void setTitle(String value) {
        this.textview.setText(value);
        this.dropdownlist.setTag(value);
    }

    public String getTitle() {
        return this.textview.getText().toString();
    }

    public void setDropdownlist(String[] list) {
        arrayAdapter.clear();
        arrayAdapter.addAll(list);
        dropdownlist.setAdapter(arrayAdapter);
    }

    public void setSelectedItem(int selectedPosition) {
        this.dropdownlist.setSelection(selectedPosition);
    }
}

