package com.jknccdirectorate.Tabs;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jknccdirectorate.R;

/**
 * Created by hp on 14-09-2017.
 */

public class TabHindi extends Fragment {
    public TabHindi() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_hindi, container, false);
        TextView hindi = (TextView) view.findViewById(R.id.hindiSong);
        Typeface fontHindi = Typeface.createFromAsset(getContext().getAssets(), "MANGAL.TTF");
        hindi.setTypeface(fontHindi);
        return view;
    }
}
