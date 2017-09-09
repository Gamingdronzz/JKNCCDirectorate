package com.jknccdirectorate.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jknccdirectorate.Model.Notice;
import com.jknccdirectorate.R;

import java.util.List;

/**
 * Created by Balpreet on 09-Sep-17.
 */

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.MyViewHolder> {

    List<Notice> notices;

    public NoticeAdapter(List<Notice> notices) {
        this.notices = notices;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_notices, parent, false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Notice model = (Notice) this.notices.get(position);
        holder.title.setText(model.getTitle());
    }

    @Override
    public int getItemCount() {
        return notices.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title;

        private MyViewHolder(View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
