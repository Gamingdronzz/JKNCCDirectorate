package com.jknccdirectorate;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;

import com.jknccdirectorate.Model.ExpandedMenuModel;
import com.jknccdirectorate.adapter.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListAdapter mMenuAdapter;
    ExpandableListView expandableList;
    List<ExpandedMenuModel> listDataHeader;
    HashMap<ExpandedMenuModel, List<String>> listDataChild;
    DrawerLayout drawer;


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
                drawer.closeDrawer(GravityCompat.START);
                return false;
            }
        });
        expandableList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                return false;
            }
        });

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
