package com.fudd.databindingstudy.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.fudd.databindingstudy.BaseActivity;
import com.fudd.databindingstudy.R;
import com.fudd.databindingstudy.databinding.ActivityIncludeBinding;
import com.fudd.databindingstudy.interfaces.BtnListener;
import com.fudd.databindingstudy.model.User;

/**
 * Created by fudd-office on 2017-2-24 15:08.
 * Email: 5036175@qq.com
 * QQ: 5036175
 */

public class IncludeActivity extends BaseActivity implements BtnListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityIncludeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_include);
        binding.setListener(this);
        binding.setText("to toast");
        binding.layoutInput.etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                User user = new User(s.toString(),"fudd");
                binding.setUser(user);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onBtnClick(View view) {
        Toast.makeText(this,"btn is clicked!",Toast.LENGTH_SHORT).show();
    }
}
