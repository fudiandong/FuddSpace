package com.fudd.databindingstudy.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.fudd.databindingstudy.BaseActivity;
import com.fudd.databindingstudy.R;
import com.fudd.databindingstudy.databinding.ActivityBasicBinding;
import com.fudd.databindingstudy.model.User;

/**
 * Created by fudd-office on 2017-2-23 15:18.
 * Email: 5036175@qq.com
 * QQ: 5036175
 */

public class BasicActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBasicBinding basicBinding = DataBindingUtil.setContentView(this, R.layout.activity_basic);
        User user = new User("fudd","dongdong",32);
        basicBinding.setUser(user);
    }
}
