package com.jknccdirectorate.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.jknccdirectorate.R;

/**
 * Created by hp on 30-11-2017.
 */

public class ViewHolderFile extends RecyclerView.ViewHolder{

    private TextView textview;

    public ViewHolderFile(View itemView) {
        super(itemView);
        textview = (TextView) itemView.findViewById(R.id.text_view_edit_text);
    }

    public void setTitle(String value) {
        textview.setText(value);
    }

}
