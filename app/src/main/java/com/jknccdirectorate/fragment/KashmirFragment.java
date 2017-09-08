package com.jknccdirectorate.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jknccdirectorate.MainActivity;
import com.jknccdirectorate.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class KashmirFragment extends Fragment {


    public KashmirFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kashmir, container, false);
    }

    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle(getResources().getString(R.string.kashmir));
    }

    @Override
    public void onStop() {
        super.onStop();
        ((MainActivity) getActivity()).setActionBarTitle(getResources().getString(R.string.app_name));
    }
}
