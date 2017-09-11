package com.jknccdirectorate.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jknccdirectorate.Adapter.NoticeAdapter;
import com.jknccdirectorate.Activity.MainActivity;
import com.jknccdirectorate.Model.Notice;
import com.jknccdirectorate.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    RecyclerView recyclerViewNotices, recyclerViewImportantLinks;
    RecyclerView.Adapter noticesAdapter,importantLinksAdapter;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerViewNotices = (RecyclerView) view.findViewById(R.id.recycler_view_notices);
        recyclerViewImportantLinks = (RecyclerView) view.findViewById(R.id.recycler_view_important_links);

        init();
        return view;
    }

    private void init()
    {
        List<Notice> noticeList = new ArrayList<Notice>();
        for(int i=0;i<15;i++)
        {
            noticeList.add(new Notice("Notice " + (i+1)));
        }

        NoticeAdapter adapter = new NoticeAdapter(noticeList);
        recyclerViewNotices.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewNotices.setAdapter(adapter);
        recyclerViewImportantLinks.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewImportantLinks.setAdapter(adapter);
    }
    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle(getResources().getString(R.string.app_name));
    }

    @Override
    public void onStop() {
        super.onStop();
        ((MainActivity) getActivity()).setActionBarTitle(getResources().getString(R.string.app_name));
    }
}
