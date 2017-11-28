package com.jknccdirectorate.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jknccdirectorate.Activity.MainActivity;
import com.jknccdirectorate.Adapter.ComplexRecyclerViewAdapter;
import com.jknccdirectorate.Model.DownloadHeadingModel;
import com.jknccdirectorate.Model.DownloadItemModel;
import com.jknccdirectorate.Model.SpaceModel;
import com.jknccdirectorate.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DownloadsFragment extends Fragment {

    RecyclerView recyclerView;
    ComplexRecyclerViewAdapter adapter;
    ArrayList<Object> items;
    public DownloadsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_downloads, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.downloads);
        adapter = new ComplexRecyclerViewAdapter(getSampleArrayList(), getFragmentManager(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle(getResources().getString(R.string.downloads));
    }

    @Override
    public void onStop() {
        super.onStop();
        ((MainActivity) getActivity()).setActionBarTitle(getResources().getString(R.string.app_name));
    }

    private ArrayList<Object> getSampleArrayList() {
        items = new ArrayList<>();


        items.add(new DownloadHeadingModel("HAND BOOK"));
        items.add(new DownloadItemModel("ANO HANDBOOK","http://jknccdirectorate.com/downloads/handbooks/ano-handbook.pdf"));
        items.add(new DownloadItemModel("PI STAFF HANDBOOK HINDI","http://jknccdirectorate.com/downloads/handbooks/pi-staff-handbook-hindi.pdf"));
        items.add(new SpaceModel());
        items.add(new DownloadHeadingModel("NCC ACT AND RULES"));
        items.add(new DownloadItemModel("NCC ACT 1948","http://jknccdirectorate.com/downloads/ncc-act-rules/ncc-act-1948.pdf"));
        items.add(new DownloadItemModel("NCC RULES","http://jknccdirectorate.com/downloads/ncc-act-rules/ncc-rules.pdf"));
        items.add(new SpaceModel());
        items.add(new DownloadHeadingModel("SYLLABUS"));
        items.add(new DownloadItemModel("COMMON SUBJECTS JD JW","http://jknccdirectorate.com/downloads/syllabus/common-subjects-jd-jw.pdf"));
        items.add(new DownloadItemModel("COMMON SUBJECTS SD SW","http://jknccdirectorate.com/downloads/syllabus/common-subjects-sd-sw.pdf"));
        items.add(new DownloadItemModel("SPECIALISED SUBJECTS JD JW","http://jknccdirectorate.com/downloads/syllabus/specialised-subjects-jd-jw.pdf"));
        items.add(new DownloadItemModel("SPECIALISED SUBJECTS SD SW","http://jknccdirectorate.com/downloads/syllabus/specialised-subjects-sd-sw.pdf"));
        items.add(new DownloadItemModel("PERSONALITY DEVELOPMENT SYLLABUS","http://jknccdirectorate.com/downloads/syllabus/personality-devp-syllabus.pdf"));
        items.add(new DownloadItemModel("TRAINING SYLLABUS CONSOLIDATED","http://jknccdirectorate.com/downloads/syllabus/trg-syllabus-consolidated.pdf"));
        items.add(new SpaceModel());
        items.add(new DownloadHeadingModel("OTHER"));
        items.add(new DownloadItemModel("ELIGIBILITY CERTIFICATE EXAMS","http://jknccdirectorate.com/downloads/others/eligibility-cert-exams.docx"));
        items.add(new DownloadItemModel("NCC GENERAL INFO","http://jknccdirectorate.com/downloads/others/ncc-gen-info.docx"));
        items.add(new DownloadItemModel("RED BOOK","http://jknccdirectorate.com/downloads/others/red-book.pdf"));



        return items;
    }
}
