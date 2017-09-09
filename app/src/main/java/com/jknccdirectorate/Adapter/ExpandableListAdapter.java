package com.jknccdirectorate.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.jknccdirectorate.Model.ExpandedMenuModel;
import com.jknccdirectorate.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by hp on 07-09-2017.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context mContext;
    private List<ExpandedMenuModel> mListDataHeader;                    // header titles
    private HashMap<ExpandedMenuModel, List<String>> mListDataChild;    // child data in format of header title, child title
    ExpandableListView expandList;

    public ExpandableListAdapter(Context context, List<ExpandedMenuModel> listDataHeader, HashMap<ExpandedMenuModel, List<String>> listChildData, ExpandableListView mView) {
        this.mContext = context;
        this.mListDataHeader = listDataHeader;
        this.mListDataChild = listChildData;
        this.expandList = mView;
    }

    @Override
    public int getGroupCount() {
        return mListDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        List<String> result = mListDataChild.get(this.mListDataHeader.get(groupPosition));
        if (result == null)
            return 0;
        else
            return result.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mListDataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mListDataChild.get(mListDataHeader.get(groupPosition))
                .get(childPosition);

    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ExpandedMenuModel headerTitle = (ExpandedMenuModel) getGroup(groupPosition);

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.group_header, null);
        ImageView iview = (ImageView) convertView.findViewById(R.id.icon_item);
        TextView lblListHeader = (TextView) convertView.findViewById(R.id.heading);
        if (getChildrenCount(groupPosition) == 0) {
            iview.setVisibility(View.GONE);
        }
        else{
            if(isExpanded)
                iview.setImageResource(android.R.drawable.ic_menu_close_clear_cancel);
            else
                iview.setImageResource(android.R.drawable.ic_input_add);
        }
        lblListHeader.setText(headerTitle.getName());
        return convertView;

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.sub_menu, null);
        }
        TextView txtListChild = (TextView) convertView.findViewById(R.id.submenu);
        txtListChild.setText(childText);

        return convertView;

    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
