package com.fudd.live.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fudd.live.activity.R;
import com.fudd.live.fragment.BaseFragment;

/**
 * Created by fudd-office on 2017-3-6 13:44.
 * Email: 5036175@qq.com
 * QQ: 5036175
 * Description:
 */

public class HomeFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_home,container,false);
        return view;
    }
}
