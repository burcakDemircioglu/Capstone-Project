package com.example.burcakdemircioglu.wannabeer.ui;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.burcakdemircioglu.wannabeer.R;
import com.example.burcakdemircioglu.wannabeer.ui.util.menuUtils;

public class SearchActivity extends AppCompatActivity {
    private boolean mTwoPane;
    private static final String DETAILFRAGMENT_TAG="TLTAG";

    private Toolbar mToolbar;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        if(findViewById(R.id.tracks_container)!=null){
            mTwoPane=true;
            if(savedInstanceState==null){
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.tracks_container, new BeerDetailActivityWithoutPagerFragment(),DETAILFRAGMENT_TAG)
                        .commit();
            }
        }
        else{
            mTwoPane=false;
        }
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        menuUtils.setupActionBarAndNavigation(drawerLayout, "Search", getSupportActionBar(), this, getResources());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
