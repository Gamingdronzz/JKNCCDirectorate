package com.jknccdirectorate.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jknccdirectorate.Model.DownloadHeadingModel;
import com.jknccdirectorate.Model.DownloadItemModel;
import com.jknccdirectorate.Model.DropdownModel;
import com.jknccdirectorate.Model.EditTextModel;
import com.jknccdirectorate.Model.FileModel;
import com.jknccdirectorate.Model.SpaceModel;
import com.jknccdirectorate.R;
import com.jknccdirectorate.ViewHolders.ViewHolderDownloadHeading;
import com.jknccdirectorate.ViewHolders.ViewHolderDropdown;
import com.jknccdirectorate.ViewHolders.ViewHolderEditText;
import com.jknccdirectorate.ViewHolders.ViewHolderFile;
import com.jknccdirectorate.ViewHolders.ViewHolderSpace;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

/**
 * Created by hp on 11-09-2017.
 */

public class ComplexRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int FILE_SELECT_CODE = 1;
    private ArrayList<Object> items;
    FragmentManager fragmentManager;
    Fragment context;
    Activity context1;

    private final int
            HEADING = 0,
            SIMPLEEDITTEXT = 1,
            DROPDOWN = 2,
            DOWNLOADHEADING = 3,
            DOWNLOADITEM = 4,
            DIVIDER = 5,
            SPACE = 6,
            DATE = 7,
            IMAGE = 8,
            FILE = 9;

    public ComplexRecyclerViewAdapter(ArrayList<Object> items, FragmentManager manager, Fragment context) {
        this.items = items;
        this.fragmentManager = manager;
        this.context = context;
    }

    public ComplexRecyclerViewAdapter(ArrayList<Object> items, FragmentManager manager, Activity context) {
        this.items = items;
        this.fragmentManager = manager;
        this.context1 = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof EditTextModel)
            return SIMPLEEDITTEXT;
        else if (items.get(position) instanceof DropdownModel)
            return DROPDOWN;
        else if (items.get(position) instanceof DownloadHeadingModel)
            return DOWNLOADHEADING;
        else if (items.get(position) instanceof DownloadItemModel)
            return DOWNLOADITEM;
        else if (items.get(position) instanceof SpaceModel)
            return SPACE;
        else if (items.get(position) instanceof FileModel)
            return FILE;
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
            case SIMPLEEDITTEXT:
                View v1 = inflater.inflate(R.layout.view_holder_edittext, parent, false);
                viewHolder = new ViewHolderEditText(v1);
                break;
            case DROPDOWN:
                View v2 = inflater.inflate(R.layout.view_holder_spinner, parent, false);
                viewHolder = new ViewHolderDropdown(v2);
                break;
            case DOWNLOADHEADING:
                View downloadHeadingView = inflater.inflate(R.layout.view_holder_download_heading, parent, false);
                viewHolder = new ViewHolderDownloadHeading(downloadHeadingView);
                break;
            case DOWNLOADITEM:
                View downloadItemView = inflater.inflate(R.layout.view_holder_download_item, parent, false);
                viewHolder = new ViewHolderDownloadItem(downloadItemView, new CustomOnClickListener());
                break;
            case SPACE:
                View SpaceView = inflater.inflate(R.layout.view_holder_space, parent, false);
                viewHolder = new ViewHolderSpace(SpaceView);
                break;
            case FILE:
                View fileView = inflater.inflate(R.layout.view_holder_file, parent, false);
                viewHolder = new ViewHolderFile(fileView, new CustomFileChooser());
                break;
        }
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case SIMPLEEDITTEXT:
                ViewHolderEditText vh1 = (ViewHolderEditText) holder;
                configureViewHolderEditText(vh1, position);
                break;
            case DROPDOWN:
                ViewHolderDropdown vh2 = (ViewHolderDropdown) holder;
                configureViewHolderDropDown(vh2, position);
                break;
            case DOWNLOADHEADING:
                ViewHolderDownloadHeading viewHolderDownloadHeading = (ViewHolderDownloadHeading) holder;
                configureViewHolderDownloadHeading(viewHolderDownloadHeading, position);
                break;
            case DOWNLOADITEM:
                ViewHolderDownloadItem viewHolderDownloadItem = (ViewHolderDownloadItem) holder;
                configureViewHolderDownloadItem(viewHolderDownloadItem, position);
                break;
            case FILE:
                ViewHolderFile viewHolderFile = (ViewHolderFile) holder;
                configureViewHolderFile(viewHolderFile, position);
                break;
            default:
                break;

        }
    }

    private void configureViewHolderFile(ViewHolderFile viewHolderFile, int position) {
        FileModel file = (FileModel) items.get(position);
        if (file != null) {
            viewHolderFile.customFileChooser.updatePosition(position);
            viewHolderFile.setTitle(file.getTitle());
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
            //vh1.setHint("Enter " + simpleEditText.getTitle());
            vh1.setTag(simpleEditText.getTitle());
        }
    }

    private void configureViewHolderDownloadHeading(ViewHolderDownloadHeading viewHolderDownloadHeading, int position) {
        DownloadHeadingModel downloadHeadingModel = (DownloadHeadingModel) items.get(position);
        if (downloadHeadingModel != null) {
            viewHolderDownloadHeading.setHeading(downloadHeadingModel.getHeading());
        }
    }

    private void configureViewHolderDownloadItem(ViewHolderDownloadItem viewHolderDownloadItem, int position) {
        DownloadItemModel downloadItemModel = (DownloadItemModel) items.get(position);
        if (downloadItemModel != null) {
            viewHolderDownloadItem.customOnClickListener.updatePosition(position);
            viewHolderDownloadItem.setTitle(downloadItemModel.getTitle());
        }
    }

    private class CustomOnClickListener implements View.OnClickListener {
        private int position;
        private boolean clicked = false;

        public void updatePosition(int position) {
            this.position = position;
        }


        @Override
        public void onClick(View view) {
            DownloadItemModel downloadItemModel = (DownloadItemModel) items.get(position);
            Intent browserIntent = new Intent(Intent.ACTION_VIEW);
            browserIntent.setData(Uri.parse(downloadItemModel.getLink()));
            context.startActivity(browserIntent);
        }


    }

    public class CustomFileChooser implements View.OnClickListener {
        private int position;
        private boolean clicked = false;

        public void updatePosition(int position) {
            this.position = position;
        }


        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("*/*");
            intent.addCategory(Intent.CATEGORY_OPENABLE);

            try {
                context1.startActivityForResult(Intent.createChooser(intent, "Select a File to Upload"), FILE_SELECT_CODE);
            } catch (android.content.ActivityNotFoundException ex) {
            }
        }


    }

    public class ViewHolderDownloadItem extends RecyclerView.ViewHolder {

        private TextView textView;
        private CustomOnClickListener customOnClickListener;

        public ViewHolderDownloadItem(View itemView, CustomOnClickListener customOnClickListener) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.download_item);
            this.customOnClickListener = customOnClickListener;
            textView.setOnClickListener(this.customOnClickListener);

        }

        public void setTitle(String value) {
            textView.setText(value);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case FILE_SELECT_CODE:
                if (resultCode == RESULT_OK) {
                }
                break;
        }
    }
}