package com.fudd.live.fragment;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.fudd.live.activity.R;

/**
 * Created by fudd-office on 2017-3-6 11:49.
 * Email: 5036175@qq.com
 * QQ: 5036175
 * Description: 没有title的Fragment
 */

public abstract class BaseFragment<BF extends ViewDataBinding> extends Fragment {

    protected BF bingView;
    protected RelativeLayout mContainer;


    public abstract int setContent();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base,null);
        bingView = DataBindingUtil.inflate(getActivity().getLayoutInflater(),setContent(),null,false);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        bingView.getRoot().setLayoutParams(params);
        mContainer = (RelativeLayout) view.findViewById(R.id.container);
        mContainer.addView(bingView.getRoot());
        return view;
    }
}
