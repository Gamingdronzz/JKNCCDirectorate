package com.jknccdirectorate.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.jknccdirectorate.R;

/**
 * Created by Balpreet on 28-Nov-17.
 */

public class ViewHolderDownloadHeading extends RecyclerView.ViewHolder {

    private TextView textView;

    public ViewHolderDownloadHeading(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.download_heading);

    }

    public void setHeading(String value) {
        textView.setText(value);
    }
}
