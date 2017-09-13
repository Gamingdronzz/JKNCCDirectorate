package com.jknccdirectorate.Fragment;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jknccdirectorate.Activity.MainActivity;
import com.jknccdirectorate.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongFragment extends Fragment {


    public SongFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_song, container, false);
        TextView hindi = (TextView) view.findViewById(R.id.hindiSong);
        TextView english = (TextView) view.findViewById(R.id.englishSong);
        Typeface fontHindi = Typeface.createFromAsset(getContext().getAssets(), "MANGAL.TTF");
        hindi.setTypeface(fontHindi);
        hindi.setMovementMethod(new ScrollingMovementMethod());
        english.setMovementMethod(new ScrollingMovementMethod());
        return view;
    }

    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle(getResources().getString(R.string.song));
    }

    @Override
    public void onStop() {
        super.onStop();
        ((MainActivity) getActivity()).setActionBarTitle(getResources().getString(R.string.app_name));
    }
}
