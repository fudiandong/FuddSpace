package com.fudd.databindingstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.fudd.databindingstudy.activity.BasicActivity;
import com.fudd.databindingstudy.activity.CustomBindingActivity;
import com.fudd.databindingstudy.activity.IncludeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void  btnOne(View view){
//        Toast.makeText(getApplicationContext(),"One",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, BasicActivity.class));
    }
    public void  btnTwo(View view){
//        Toast.makeText(getApplicationContext(),"Two",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, CustomBindingActivity.class));
    }
    public void  btnThree(View view){
//        Toast.makeText(getApplicationContext(),"Three",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, IncludeActivity.class));
    }
    public void  btnFour(View view){
        Toast.makeText(getApplicationContext(),"Four",Toast.LENGTH_SHORT).show();
    }
}
