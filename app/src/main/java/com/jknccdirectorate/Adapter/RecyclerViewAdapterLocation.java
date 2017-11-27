package com.jknccdirectorate.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jknccdirectorate.R;

import java.util.ArrayList;

/**
 * Created by hp on 15-09-2017.
 */

public class RecyclerViewAdapterLocation extends RecyclerView.Adapter<RecyclerViewAdapterLocation.MyViewHolder> {

    ArrayList<String> locationArray;

    public RecyclerViewAdapterLocation(ArrayList<String> locationArray) {
        setHasStableIds(true);
        this.locationArray = locationArray;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_locations, parent, false));
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String location = locationArray.get(position);
        holder.tv.setText(location);
    }

    @Override
    public int getItemCount() {
        return locationArray.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.tv = (TextView) itemView.findViewById(R.id.loc);
        }
    }
}
