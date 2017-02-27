package com.fudd.live.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.fudd.live.activity.databinding.ActivityWelBinding;
import com.fudd.live.utils.Contants;
import com.fudd.live.utils.SharedPreferencesUtil;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class WelActivity extends AppCompatActivity {

    private ActivityWelBinding binding;
    private static final int ANIM_TIME = 2000;
    private static final float SCALE_END = 1.15F;

    ImageView mIVEntry ;

    private static final int[] Imgs = {R.drawable.welcomimg1,R.drawable.welcomimg2,R.drawable.welcomimg3,R.drawable.welcoming4,R.drawable.welcoming5};

    // 华为云 301199
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 判断是否是第一次开启应用
        boolean isFirstOpen = SharedPreferencesUtil.getBoolean(this, Contants.FIRST_OPEN,true);
        // 如果是第一次启动，则先进入功能引导页
        if (isFirstOpen){
            Intent intent = new Intent(this,GuideActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        binding = DataBindingUtil.setContentView(this,R.layout.activity_wel);
        mIVEntry = (ImageView) findViewById(R.id.iv_entry);
        Random random = new Random();
        int index =random.nextInt(Imgs.length);
        Resources resources = this.getResources();
        Drawable drawable = resources.getDrawable(Imgs[index]);

        binding.setImg(drawable);
//        binding.setHi("今天星期六了！");
        binding.setTime("欢迎使用!");

        startMainActivity();


    }

    private void startMainActivity() {

        Observable.timer(1000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>()
                {

                    @Override
                    public void call(Long aLong)
                    {
                        startAnim();
                    }
                });
    }

    private void startAnim() {

        ObjectAnimator animatorX = ObjectAnimator.ofFloat(mIVEntry, "scaleX", 1f, SCALE_END);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(mIVEntry, "scaleY", 1f, SCALE_END);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(ANIM_TIME).play(animatorX).with(animatorY);
        set.start();

        set.addListener(new AnimatorListenerAdapter()
        {

            @Override
            public void onAnimationEnd(Animator animation)
            {

                startActivity(new Intent(WelActivity.this, MainActivity.class));
                overridePendingTransition(R.anim.screen_zoom_in, R.anim.screen_zoom_out);
                WelActivity.this.finish();
            }
        });
    }
}
