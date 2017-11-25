package com.jknccdirectorate.Activity;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.jknccdirectorate.Adapter.ExpandableListAdapter;
import com.jknccdirectorate.Fragment.AdgCornerFragment;
import com.jknccdirectorate.Fragment.AimFragment;
import com.jknccdirectorate.Fragment.ContactFragment;
import com.jknccdirectorate.Fragment.CoverageFragment;
import com.jknccdirectorate.Fragment.DisclaimerFragment;
import com.jknccdirectorate.Fragment.DownloadsFragment;
import com.jknccdirectorate.Fragment.JammuFragment;
import com.jknccdirectorate.Fragment.KashmirFragment;
import com.jknccdirectorate.Fragment.PledgeFragment;
import com.jknccdirectorate.Fragment.RdcFragment;
import com.jknccdirectorate.Fragment.RtiFragment;
import com.jknccdirectorate.Fragment.SongFragment;
import com.jknccdirectorate.Model.ExpandedMenuModel;
import com.jknccdirectorate.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListAdapter mMenuAdapter;
    ExpandableListView expandableList;
    WebView webView;
    List<ExpandedMenuModel> listDataHeader;
    HashMap<ExpandedMenuModel, List<String>> listDataChild;
    DrawerLayout drawer;
    Toolbar toolbar;
    private FloatingActionButton login, register;
    final String TAG = "Main";

    final String removeHeader = "document.getElementsByClassName('page-banner-section')[0].style.display=\"none\"; ";
    final String removeFirstHeader = "document.getElementsByClassName('firstheader')[0].style.display=\"none\"; ";
    final String removeLogin = "document.getElementsById('logindiv')[0].style.display=\"none\"; ";
    final String removeFooter = "document.getElementsByClassName('footer ')[0].style.display=\"none\"; ";

    //final String removeTopModules = "document.getElementById('top-modules').style.display=\"none\"; ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findviews();
        setupWebview();


        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        prepareListData();

        mMenuAdapter = new ExpandableListAdapter(MainActivity.this, listDataHeader, listDataChild, expandableList);
        expandableList.setAdapter(mMenuAdapter);

        expandableList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Fragment fragment = null;
                getSupportFragmentManager().popBackStack();
                switch (i) {
                    case 2:
                        switch (i1) {
                            case 0:
                                fragment = new AimFragment();
                                //webView.loadUrl("http://jknccdirectorate.com/aim.php");
                                break;
                            case 1:
                                fragment = new SongFragment();
                                //webView.loadUrl("http://jknccdirectorate.com/song.php");
                                break;
                            case 2:
                                fragment = new PledgeFragment();
                                //webView.loadUrl("jknccdirectorate.com/pledge.php");
                                break;
                        }
                        break;
                    case 3:
                        switch (i1) {
                            case 0:
                                fragment = new JammuFragment();
                                //webView.loadUrl("http://jknccdirectorate.com/org-jammu.php");
                                break;
                            case 1:
                                fragment = new KashmirFragment();
                                // webView.loadUrl("http://jknccdirectorate.com/org-srinagar.php");
                                break;
                        }
                        break;
                    case 13:
                        switch (i1) {
                            case 0:
                                //fragment = new EnrollmentFragment();
                                webView.loadUrl("http://jknccdirectorate.com/members.php");
                                break;
                            case 1:
                                //fragment = new AdminEventsFragment();
                                webView.loadUrl("http://jknccdirectorate.com/eventadd.php");
                                break;
                            case 2:
                                //fragment = new VerifyUserFragment();
                                webView.loadUrl("http://jknccdirectorate.com/AddGallery.php");
                                break;
                            case 3:
                                //fragment = new ReportsFragment();
                                webView.loadUrl("http://jknccdirectorate.com/addNotification.php");
                                break;
                            case 4:
                                //fragment = new ReportsFragment();
                                webView.loadUrl("http://jknccdirectorate.com/status.php");
                                break;
                            case 5:
                                //fragment = new ReportsFragment();
                                webView.loadUrl("http://jknccdirectorate.com/training.php");
                                break;
                            case 6:
                                //fragment = new ReportsFragment();
                                webView.loadUrl("http://jknccdirectorate.com/socialActivity.php");
                                break;
                            case 7:
                                //fragment = new ReportsFragment();
                                webView.loadUrl("http://jknccdirectorate.com/report.php");
                                break;
                            case 8:
                                //fragment = new ReportsFragment();
                                webView.loadUrl("http://jknccdirectorate.com/reportTraining.php");
                                break;
                        }
                }
                if (fragment != null) {
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.addToBackStack(null);
                    ft.replace(R.id.content_frame, fragment);
                    ft.commit();
                }
                drawer.closeDrawer(GravityCompat.START);
                return false;
            }
        });
        expandableList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                Fragment fragment = null;

                switch (i) {
                    case 0:
                        //fragment = new HomeFragment();
                        getSupportFragmentManager().popBackStack();
                        webView.loadUrl("http://jknccdirectorate.com/index.php");
                        drawer.closeDrawer(GravityCompat.START);
                        break;

                    case 1:
                        getSupportFragmentManager().popBackStack();
                        fragment = new AdgCornerFragment();
                        //webView.loadUrl("http://jknccdirectorate.com/adg-corner.php");
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case 4:
                        getSupportFragmentManager().popBackStack();
                        fragment = new CoverageFragment();
                        //webView.loadUrl("http://jknccdirectorate.com/coverage.php");
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case 5:
                        //fragment = new GalleryFragment();
                        getSupportFragmentManager().popBackStack();
                        webView.loadUrl("http://jknccdirectorate.com/gallery.php");
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case 6:
                        getSupportFragmentManager().popBackStack();
                        fragment = new RdcFragment();
                        //webView.loadUrl("http://jknccdirectorate.com/rdc2017.php");
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case 7:
                        getSupportFragmentManager().popBackStack();
                        fragment = new RtiFragment();
                        //webView.loadUrl("http://jknccdirectorate.com/rti.php");
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case 8:
                        getSupportFragmentManager().popBackStack();
                        fragment = new DownloadsFragment();
                        //webView.loadUrl("http://jknccdirectorate.com/download.php");
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case 9:
                        getSupportFragmentManager().popBackStack();
                        fragment = new ContactFragment();
                        //webView.loadUrl("http://jknccdirectorate.com/contact-us.php");
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case 10:
                        getSupportFragmentManager().popBackStack();
                        fragment = new DisclaimerFragment();
                        //webView.loadUrl("http://jknccdirectorate.com/disclaimer.php");
                        drawer.closeDrawer(GravityCompat.START);
                        break;

                   /* case 11:
                        //fragment = new FeedbackFragment();
                        webView.loadUrl("http://jknccdirectorate.com/aim.php");
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                   */
                    case 12:
                        getSupportFragmentManager().popBackStack();
                        //fragment = new EventsFragment();
                        webView.loadUrl("http://jknccdirectorate.com/event.php");
                        drawer.closeDrawer(GravityCompat.START);
                        break;

                }

                if (fragment != null) {
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.addToBackStack(null);
                    ft.replace(R.id.content_frame, fragment);
                    ft.commit();
                }
                return false;
            }
        });

        /*login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new FragmentLogin();
                newFragment.show(getSupportFragmentManager(), "LOG_IN");
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
*/
        selectHome();
    }

    private void findviews() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        expandableList = (ExpandableListView) findViewById(R.id.navigationmenu);
        // login = (FloatingActionButton) findViewById(R.id.btn_login);
        //register = (FloatingActionButton) findViewById(R.id.btn_register);
        webView = (WebView) findViewById(R.id.webView);
    }

    private void selectHome() {
        long packedPos = expandableList.getPackedPositionForChild(0, 0);
        int flatPos = expandableList.getFlatListPosition(packedPos);
        int adjustedPos = flatPos - expandableList.getFirstVisiblePosition();

        //If all is well, the adjustedPos should never be < 0
        View childToClick = expandableList.getChildAt(adjustedPos);

        //Now adjust the position based on how far the user has scrolled the list.
        long id = expandableList.getExpandableListAdapter().getChildId(0, 0);

        expandableList.performItemClick(childToClick, flatPos, id);
    }

    private void setupWebview() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {

            @RequiresApi(Build.VERSION_CODES.N)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return super.shouldOverrideUrlLoading(view, request);
            }

            @SuppressWarnings("deprecation")
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                    Log.d("Url", url);
                    view.loadUrl(url);

                }
                return true;
            }

            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                Toast.makeText(getApplicationContext(), "We are getting things fixed..", Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onPageFinished(WebView view, String url) {

            }
        });

        webView.setWebChromeClient
                (
                        new WebChromeClient() {
                            @Override
                            public void onProgressChanged(WebView view, int newProgress) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("javascript:");
                                stringBuilder.append("(function() { ");

                                //This is where we can remove all those classes which we dont need
                                //Just create a variable on top
                                //give it a value ( you can find the samples from other variables
                                //i have used string builder in case we want to remove something only on selected options

                                stringBuilder.append(removeHeader);
                                stringBuilder.append(removeFirstHeader);
                                stringBuilder.append(removeFooter);
                                stringBuilder.append(removeLogin);


                                stringBuilder.append("} ) ()");
                                view.loadUrl(stringBuilder.toString());

                            }


                        }


                );
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

        List<String> admin = new ArrayList<>();
        admin.add(getResources().getString(R.string.enrollment));
        admin.add(getResources().getString(R.string.add_event));
        admin.add(getResources().getString(R.string.add_gallery));
        admin.add(getResources().getString(R.string.add_notification));
        admin.add(getResources().getString(R.string.update));
        admin.add(getResources().getString(R.string.training));
        admin.add(getResources().getString(R.string.social));
        admin.add(getResources().getString(R.string.report));
        admin.add(getResources().getString(R.string.report_training));

        listDataChild.put(listDataHeader.get(2), about);// Header, Child data
        listDataChild.put(listDataHeader.get(3), org);
        listDataChild.put(listDataHeader.get(13), admin);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder
                    .setMessage("Are you sure you want to Exit?")
                    .setCancelable(true)
                    .setPositiveButton("YES",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    finish();
                                }
                            })
                    .setNegativeButton("NO",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.dismiss();
                                }
                            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
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
