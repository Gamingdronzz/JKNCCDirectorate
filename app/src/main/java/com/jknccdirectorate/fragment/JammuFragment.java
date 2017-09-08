package com.jknccdirectorate.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jknccdirectorate.MainActivity;
import com.jknccdirectorate.R;

public class JammuFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jammu, container, false);
    }
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle(getResources().getString(R.string.jammu));
    }

    @Override
    public void onStop() {
        super.onStop();
        ((MainActivity) getActivity()).setActionBarTitle(getResources().getString(R.string.app_name));
    }
}
