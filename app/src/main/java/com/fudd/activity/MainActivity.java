package com.fudd.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.fudd.fragment.NavigationFragment;
import com.fudd.fragment.TextTabFragment;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {


    private NavigationFragment mNavigationFragment;
    private TextTabFragment mTextTabFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        mNavigationFragment = NavigationFragment.newInstance(getString(R.string.navigation_navigation_bar));
//        transaction.replace(R.id.frame_content, mNavigationFragment).commit();

        mTextTabFragment = TextTabFragment.newInstance(getString(R.string.navigation_text_tab));
        transaction.replace(R.id.frame_content, mTextTabFragment).commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onClick(View v) {

    }
}
