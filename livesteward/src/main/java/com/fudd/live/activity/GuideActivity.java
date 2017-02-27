package com.fudd.live.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.fudd.live.adapter.GuideViewPagerAdapter;
import com.fudd.live.utils.Contants;
import com.fudd.live.utils.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fudd-office on 2017-2-27 09:48.
 * Email: 5036175@qq.com
 * QQ: 5036175
 * Description: 引导界面
 */

public class GuideActivity extends AppCompatActivity implements View.OnClickListener{

    private List<View> views;
    private Button startBtn;
    private ViewPager vp;
    private GuideViewPagerAdapter guideViewPagerAdapter;
    // 底部小点图片
    private ImageView[] dots;
    // 记录当前选中位置
    private int currentIndex;
    // 三张引导图片
    private static final int[] pics = { R.layout.guide_view1,
            R.layout.guide_view2, R.layout.guide_view3};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_guide);

        views = new ArrayList<View>();

        for (int i =0;i< pics.length;i++){
            View view =LayoutInflater.from(this).inflate(pics[i],null);
            // 设置第三张引导图的点击事件
            if (i == pics.length -1){
                startBtn = (Button) view.findViewById(R.id.btn_enter);
                startBtn.setTag("enter");
                startBtn.setOnClickListener(this);
            }
            // 将view 加入图片列表list
            views.add(view);
        }
        vp = (ViewPager) findViewById(R.id.vp_guide);
        guideViewPagerAdapter = new GuideViewPagerAdapter(views);
        vp.setAdapter(guideViewPagerAdapter);
        vp.addOnPageChangeListener(new PageListener());

        initDots();

    }

    private void initDots() {
        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
        dots = new ImageView[pics.length];// 底部小圆点和引导页数量一致
        // 循环得到小图片 并初始化
        for (int i = 0; i<pics.length;i++){
            dots[i] = (ImageView) ll.getChildAt(i);
            // 设置初始状态
            dots[i].setEnabled(false);
            dots[i].setOnClickListener(this);
            // 设置位置tag，方便取出与当前位置对应
            dots[i].setTag(i);
        }
        currentIndex = 0;
        // 设置为白色，即选中状态
        dots[currentIndex].setEnabled(true);


    }

    @Override
    public void onClick(View v) {
        // 第三张图 点击事件
        if (v.getTag().equals("enter")) {
            enterMainActivity();
            return;
        }

        int position = (Integer) v.getTag();
        setCurView(position);
        setCurDot(position);
    }

    private void enterMainActivity() {
        Intent intent = new Intent(this,
                MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.screen_zoom_in, R.anim.screen_zoom_out);
        SharedPreferencesUtil.putBoolean(this, Contants.FIRST_OPEN, false);
        finish();
    }

    private void setCurView(int position) {
        if (position < 0 || position >= pics.length) {
            return;
        }
        vp.setCurrentItem(position);
    }


    private class PageListener implements ViewPager.OnPageChangeListener {


        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            // 设置底部小点选中状态
            setCurDot(position);
        }

        @Override
        public void onPageScrollStateChanged(int position) {
//
        }
    }

    private void setCurDot(int position) {
        if (position < 0 || position > pics.length || currentIndex == position) {
            return;
        }
        dots[position].setEnabled(true);
        dots[currentIndex].setEnabled(false);
        currentIndex = position;

    }
}
