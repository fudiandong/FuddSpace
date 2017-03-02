package com.fudd.live.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.fudd.live.activity.databinding.ActivityMainBinding;
import com.fudd.live.utils.StatusBarUtil;

/**
 * Created by Nordpol on 2017/2/25 0025.
 */

public class MainActivity extends Activity implements View.OnClickListener {

    private ActivityMainBinding mBinding;
    private FrameLayout llTitleMenu;
    private DrawerLayout drawerLayout;
    private NavigationView navView;
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private ViewPager vpContent;

    // 工具栏的三个图标
    private ImageView llTitleGank;
    private ImageView llTitleOne;
    private ImageView llTitleDou;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        // 　初始化视图
        initId();
        // 　设置沉浸式状态栏
        StatusBarUtil.setColorNoTranslucentForDrawerLayout(MainActivity.this, drawerLayout, getResources().getColor(R.color.colorTheme));
//        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.KITKAT) {
//            WindowManager.LayoutParams localLayoutParams
//                    = getWindow().getAttributes();
//            localLayoutParams.flags =
//                    (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
//                            | localLayoutParams.flags);
//            if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
//                drawerLayout.setFitsSystemWindows(true);
//                drawerLayout.setClipToPadding(false);
//            }
//        }
        //   初始化侧滑栏NavigationView
        initNavigationView();
    }

    private void initNavigationView() {
//        navView.inflateHeaderView(R.layout.nav_header_main);
    }

    /**
     * 初始化视图
     */
    private void initId() {
        // llTitleMenu  为menu图标的父布局  菜单
        llTitleMenu = mBinding.include.llTitleMenu;
        // 侧滑栏
        drawerLayout = mBinding.drawerLayout;
        // 导航布局
        navView = mBinding.navView;
        // 工具栏
        toolbar = mBinding.include.toolbar;
        // 邮件图标
        fab = mBinding.include.fab;
        // ViewPager
        vpContent = mBinding.include.vpContent;

        // 工具栏三个 ImageView 图标
        llTitleOne = mBinding.include.ivTitleOne;
        llTitleDou = mBinding.include.ivTitleDou;
        llTitleGank = mBinding.include.ivTitleGank;
        // 暂时禁用 右下角 邮件图标
        fab.setVisibility(View.GONE);
        llTitleMenu.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ll_title_menu){
//            Toast.makeText(getApplicationContext(),StatusBarUtil.getStatusBarHeight(getBaseContext())+"",Toast.LENGTH_LONG).show();
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }

}
