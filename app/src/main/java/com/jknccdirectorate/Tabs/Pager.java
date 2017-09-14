package com.jknccdirectorate.Tabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by hp on 14-09-2017.
 */

public class Pager extends FragmentStatePagerAdapter {
    int tabCount;
    TabEnglish tab1;
    TabHindi tab2;

    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
        tab1 = new TabEnglish();
        tab2 = new TabHindi();
    }

    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                return tab1;
            case 1:
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }

}
