package com.jknccdirectorate.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jknccdirectorate.Model.DropdownModel;
import com.jknccdirectorate.Model.EditTextModel;
import com.jknccdirectorate.R;
import com.jknccdirectorate.ViewHolders.ViewHolderDropdown;
import com.jknccdirectorate.ViewHolders.ViewHolderEditText;

import java.util.ArrayList;

/**
 * Created by hp on 11-09-2017.
 */

public class ComplexRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Object> items;
    private final int EDITTEXT = 0, DROPDOWN = 1;

    public ComplexRecyclerViewAdapter(ArrayList<Object> items) {
        this.items = items;
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof EditTextModel)
            return EDITTEXT;
        if (items.get(position) instanceof DropdownModel)
            return DROPDOWN;
        else
            return -1;
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case EDITTEXT:
                View v1 = inflater.inflate(R.layout.view_holder_edittext, parent, false);
                viewHolder = new ViewHolderEditText(v1);
                break;
            case DROPDOWN:
                View v2 = inflater.inflate(R.layout.view_holder_spinner, parent, false);
                viewHolder = new ViewHolderDropdown(v2);
                break;
        }
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case EDITTEXT:
                ViewHolderEditText vh1 = (ViewHolderEditText) holder;
                configureViewHolderEditText(vh1, position);
                break;
            case DROPDOWN:
                ViewHolderDropdown vh2 = (ViewHolderDropdown) holder;
                configureViewHolderDropDown(vh2, position);
                break;
            default:
                break;
        }

    }

    private void configureViewHolderDropDown(ViewHolderDropdown vh2, int position) {
        DropdownModel dropDown = (DropdownModel) items.get(position);
        if (dropDown != null) {
            vh2.setTitle(dropDown.getHeading());
            vh2.setDropdownlist(dropDown.getList());
        }
    }

    private void configureViewHolderEditText(ViewHolderEditText vh1, int position) {
        EditTextModel simpleEditText = (EditTextModel) items.get(position);
        if (simpleEditText != null) {
            vh1.setTitle(simpleEditText.getTitle());
            vh1.setHint("Enter " + simpleEditText.getTitle());
            vh1.setTag(simpleEditText.getTitle());
        }
    }

}
