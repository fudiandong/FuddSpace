package com.fudd.live.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.fudd.live.activity.databinding.ActivityMainBinding;

/**
 * Created by Nordpol on 2017/2/25 0025.
 */

public class MainActivity extends Activity implements View.OnClickListener {

    private ActivityMainBinding binding;
    private FrameLayout llTitleMenu;
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        llTitleMenu = binding.include.llTitleMenu;
        drawerLayout = binding.drawerLayout;
        llTitleMenu.setOnClickListener(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
            if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
                //将侧边栏顶部延伸至status bar
                drawerLayout.setFitsSystemWindows(true);
                //将主页面顶部延伸至status bar;虽默认为false,但经测试,DrawerLayout需显示设置
                drawerLayout.setClipToPadding(false);
            }
        }
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ll_title_menu){
//            Toast.makeText(getApplicationContext(),"老婆，我爱你！",Toast.LENGTH_LONG).show();
            drawerLayout.openDrawer(GravityCompat.START);
        }

    }
}
