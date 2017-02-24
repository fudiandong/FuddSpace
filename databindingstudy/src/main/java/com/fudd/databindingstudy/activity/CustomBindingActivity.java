package com.fudd.databindingstudy.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.fudd.databindingstudy.BaseActivity;
import com.fudd.databindingstudy.CustomBinding;
import com.fudd.databindingstudy.R;
import com.fudd.databindingstudy.model.User;

/**
 * Created by fudd-office on 2017-2-24 11:41.
 * Email: 5036175@qq.com
 * QQ: 5036175
 */

/**
 * 自定义DataBinding
 */
public class CustomBindingActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomBinding customBinding = DataBindingUtil.setContentView(this, R.layout.activity_custom);
        User user = new User("fudd","dongda");
        customBinding.setUser(user);

    }
}
