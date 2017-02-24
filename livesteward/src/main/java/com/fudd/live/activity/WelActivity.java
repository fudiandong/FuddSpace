package com.fudd.live.activity;

import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fudd.live.activity.databinding.ActivityWelBinding;

import java.util.Random;

public class WelActivity extends AppCompatActivity {

    private ActivityWelBinding binding;

    private static final int[] Imgs = {R.drawable.wel1,R.drawable.welcoming4,R.drawable.welcoming5};

    // 华为云 301199
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_wel);
        Random random = new Random();
        int index =random.nextInt(Imgs.length);
        Resources resources = this.getResources();
        Drawable drawable = resources.getDrawable(Imgs[index]);


        binding.setImg(drawable);
        binding.setHi("今天星期六了！");
        binding.setTime("早上好，付先生！");

    }
}
