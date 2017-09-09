package com.jknccdirectorate;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;

import com.jknccdirectorate.Model.ExpandedMenuModel;
import com.jknccdirectorate.adapter.ExpandableListAdapter;
import com.jknccdirectorate.fragment.AdgCornerFragment;
import com.jknccdirectorate.fragment.AimFragment;
import com.jknccdirectorate.fragment.ContactFragment;
import com.jknccdirectorate.fragment.CoverageFragment;
import com.jknccdirectorate.fragment.DisclaimerFragment;
import com.jknccdirectorate.fragment.DownloadsFragment;
import com.jknccdirectorate.fragment.EventsFragment;
import com.jknccdirectorate.fragment.FeedbackFragment;
import com.jknccdirectorate.fragment.GalleryFragment;
import com.jknccdirectorate.fragment.HomeFragment;
import com.jknccdirectorate.fragment.JammuFragment;
import com.jknccdirectorate.fragment.KashmirFragment;
import com.jknccdirectorate.fragment.PledgeFragment;
import com.jknccdirectorate.fragment.RdcFragment;
import com.jknccdirectorate.fragment.RtiFragment;
import com.jknccdirectorate.fragment.SongFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListAdapter mMenuAdapter;
    ExpandableListView expandableList;
    List<ExpandedMenuModel> listDataHeader;
    HashMap<ExpandedMenuModel, List<String>> listDataChild;
    DrawerLayout drawer;
    final String TAG = "Main";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        expandableList = (ExpandableListView) findViewById(R.id.navigationmenu);

        prepareListData();
        mMenuAdapter = new ExpandableListAdapter(MainActivity.this, listDataHeader, listDataChild, expandableList);
        expandableList.setAdapter(mMenuAdapter);
        /*if (navigationView != null) {
            setupDrawerContent(navigationView);
        }
*/
        expandableList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Fragment fragment = new Fragment();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft;
                switch (i) {
                    case 2:
                        switch (i1) {
                            case 0:
                                fragment = new AimFragment();
                                break;
                            case 1:
                                fragment = new SongFragment();
                                break;
                            case 2:
                                fragment = new PledgeFragment();
                                break;
                        }
                        break;
                    case 3:
                        switch (i1) {
                            case 0:
                                fragment = new JammuFragment();
                                break;
                            case 1:
                                fragment = new KashmirFragment();
                                break;
                        }
                }
                drawer.closeDrawer(GravityCompat.START);
                ft = fm.beginTransaction();
                ft.replace(R.id.content_frame, fragment);
                ft.commit();
                return false;
            }
        });
        expandableList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {

                Fragment fragment = new Fragment();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft;
                ft = fm.beginTransaction();
                switch (i) {
                    case 0:
                        fragment = new HomeFragment();
                        drawer.closeDrawer(GravityCompat.START);
                        break;

                    case 1:
                        fragment = new AdgCornerFragment();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case 4:
                        fragment = new CoverageFragment();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case 5:
                        fragment = new GalleryFragment();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case 6:
                        fragment = new RdcFragment();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case 7:
                        fragment = new RtiFragment();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case 8:
                        fragment = new DownloadsFragment();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case 9:
                        fragment = new ContactFragment();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case 10:
                        fragment = new DisclaimerFragment();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case 11:
                        fragment = new FeedbackFragment();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case 12:
                        fragment = new EventsFragment();
                        drawer.closeDrawer(GravityCompat.START);
                        break;

                }

                ft.replace(R.id.content_frame, fragment);
                ft.commit();

                return false;
            }
        });


        selectHome();


    }

    private void selectHome()
    {
        long packedPos = expandableList.getPackedPositionForChild(0,0);
        int flatPos = expandableList.getFlatListPosition(packedPos);
        int adjustedPos = flatPos - expandableList.getFirstVisiblePosition();

//If all is well, the adjustedPos should never be < 0
        View childToClick = expandableList.getChildAt(adjustedPos);

//Now adjust the position based on how far the user has scrolled the list.
        long id = expandableList.getExpandableListAdapter().getChildId(0,0);

        expandableList.performItemClick(childToClick, flatPos, id);
    }


    private void prepareListData() {
        listDataHeader = new ArrayList<ExpandedMenuModel>();
        listDataChild = new HashMap<ExpandedMenuModel, List<String>>();
        String menu[] = getResources().getStringArray(R.array.menu);

        //heading data
        for (int i = 0; i < menu.length; i++) {
            ExpandedMenuModel item = new ExpandedMenuModel();
            item.setName(menu[i]);
            listDataHeader.add(item);
        }
        // Adding child data
        List<String> about = new ArrayList<String>();
        about.add(getResources().getString(R.string.aim));
        about.add(getResources().getString(R.string.song));
        about.add(getResources().getString(R.string.pledge));

        List<String> org = new ArrayList<String>();
        org.add(getResources().getString(R.string.jammu));
        org.add(getResources().getString(R.string.kashmir));

        listDataChild.put(listDataHeader.get(2), about);// Header, Child data
        listDataChild.put(listDataHeader.get(3), org);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
  /*  private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        drawer.closeDrawers();
                        return true;
                    }
                });
    }
*/

}
