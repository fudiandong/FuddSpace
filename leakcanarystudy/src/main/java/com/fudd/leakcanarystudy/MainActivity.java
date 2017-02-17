package com.fudd.leakcanarystudy;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.fudd.R;

public class MainActivity extends Activity {

    static  Demo demo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (demo == null){
            demo = new Demo();
        }
        Toast.makeText(this,"hhh",Toast.LENGTH_SHORT).show();
        finish();
    }

    class  Demo{

    }
}
