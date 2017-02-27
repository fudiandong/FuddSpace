package com.fudd.live.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.fudd.live.activity.databinding.ActivityMainBinding;

/**
 * Created by Nordpol on 2017/2/25 0025.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;
    private FrameLayout llTitleMenu;
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        llTitleMenu = binding.include.llTitleMenu;
        drawerLayout = binding.drawerLayout;
        llTitleMenu.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ll_title_menu){
//            Toast.makeText(getApplicationContext(),"老婆，我爱你！",Toast.LENGTH_LONG).show();
            drawerLayout.openDrawer(GravityCompat.START);
        }

    }
}
