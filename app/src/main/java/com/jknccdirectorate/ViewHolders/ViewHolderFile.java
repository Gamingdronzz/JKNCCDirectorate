package com.jknccdirectorate.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.jknccdirectorate.Adapter.ComplexRecyclerViewAdapter;
import com.jknccdirectorate.R;


/**
 * Created by hp on 30-11-2017.
 */

public class ViewHolderFile extends RecyclerView.ViewHolder {

    private TextView textview;
    public ComplexRecyclerViewAdapter.CustomFileChooser customFileChooser;

    public ViewHolderFile(View itemView, ComplexRecyclerViewAdapter.CustomFileChooser customFileChooser) {
        super(itemView);
        textview = (TextView) itemView.findViewById(R.id.text_view_edit_text);
        this.customFileChooser = customFileChooser;
        textview.setOnClickListener(this.customFileChooser);
    }

    public void setTitle(String value) {
        textview.setText(value);
    }

}
