package com.fudd.live.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.fudd.live.activity.databinding.ActivityMainBinding;
import com.fudd.live.adapter.ListFragmentPagerAdaper;
import com.fudd.live.fragment.home.HomeFragment;
import com.fudd.live.fragment.live.LiveFragment;
import com.fudd.live.fragment.owner.OwnerFragment;
import com.fudd.live.utils.ImageUtil;
import com.fudd.live.utils.StatusBarUtil;

import java.util.ArrayList;

/**
 * Created by Nordpol on 2017/2/25 0025.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private ActivityMainBinding mBinding;
    private FrameLayout llTitleMenu;
    private DrawerLayout drawerLayout;
    private NavigationView navView;
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private ViewPager vpContent;

    // 工具栏的三个图标
    private ImageView llTitleHome;
    private ImageView llTitleLive;
    private ImageView llTitleOwner;

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
        initContentFragment();
    }

    private void initContentFragment() {
        ArrayList<Fragment> mFragmentList = new ArrayList<>();
        mFragmentList.add(new HomeFragment());
        mFragmentList.add(new LiveFragment());
        mFragmentList.add(new OwnerFragment());

        ListFragmentPagerAdaper listFragmentPagerAdaper = new ListFragmentPagerAdaper(getSupportFragmentManager(),mFragmentList);
        vpContent.setAdapter(listFragmentPagerAdaper);
        // 设置ViewPager最大缓存的页面数量
        vpContent.setOffscreenPageLimit(2);
        vpContent.addOnPageChangeListener(this);
        // 设置默认选中第一项
        mBinding.include.ivTitleHome.setSelected(true);
        vpContent.setCurrentItem(0);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayShowTitleEnabled(false);
        }

    }

    private void initNavigationView() {
        navView.inflateHeaderView(R.layout.nav_header_main);
        View headerView = navView.getHeaderView(0);
        //　获取头像imageview
        ImageView imageView = (ImageView) headerView.findViewById(R.id.iv_avatar);
        //  将头像设置为圆形
        ImageUtil.displayCircle(imageView,R.drawable.welcoming4);
        LinearLayout navHome = (LinearLayout) headerView.findViewById(R.id.nav_ll_home);
        LinearLayout navWork = (LinearLayout) headerView.findViewById(R.id.nav_ll_work);
        LinearLayout navHelp = (LinearLayout) headerView.findViewById(R.id.nav_ll_help);
        LinearLayout navService = (LinearLayout) headerView.findViewById(R.id.nav_ll_service);
        LinearLayout navSetting = (LinearLayout) headerView.findViewById(R.id.nav_ll_setting);
        LinearLayout navExit = (LinearLayout) headerView.findViewById(R.id.nav_ll_exit);

        navHome.setOnClickListener(this);
        navWork.setOnClickListener(this);
        navHelp.setOnClickListener(this);
        navService.setOnClickListener(this);
        navSetting.setOnClickListener(this);
        navExit.setOnClickListener(this);
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
        llTitleHome = mBinding.include.ivTitleHome;
        llTitleLive = mBinding.include.ivTitleLive;
        llTitleOwner = mBinding.include.ivTitleOwner;
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

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        switch (position){
            case 0:
                llTitleHome.setSelected(true);
                llTitleLive.setSelected(false);
                llTitleOwner.setSelected(false);
                break;
            case 1:
                llTitleHome.setSelected(false);
                llTitleLive.setSelected(true);
                llTitleOwner.setSelected(false);
                break;
            case 2:
                llTitleHome.setSelected(false);
                llTitleLive.setSelected(false);
                llTitleOwner.setSelected(true);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
