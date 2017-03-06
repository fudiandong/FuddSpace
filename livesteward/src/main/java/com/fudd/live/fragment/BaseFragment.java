package com.fudd.live.fragment;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.fudd.live.activity.R;
import com.fudd.live.utils.PerfectClickListener;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by fudd-office on 2017-3-6 11:49.
 * Email: 5036175@qq.com
 * QQ: 5036175
 * Description: 没有title的Fragment   暂时未用
 */

public abstract class BaseFragment extends Fragment {

    protected ViewDataBinding bindingView;
    protected RelativeLayout mContainer;
    // 加载
    private LinearLayout llProgressBar;
    // 加载失败 -- 刷新
    private LinearLayout mRefresh;
    // fragment是否显示了
    protected boolean mIsVisible = false;

    private AnimationDrawable animationDrawable;

    public abstract int setContent();
    private CompositeSubscription mCompositeSubscription;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base,null);
        bindingView = DataBindingUtil.inflate(getActivity().getLayoutInflater(),setContent(),null,false);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        bindingView.getRoot().setLayoutParams(params);
        mContainer = (RelativeLayout) view.findViewById(R.id.container);
        mContainer.addView(bindingView.getRoot());
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        llProgressBar = (LinearLayout) getView().findViewById(R.id.ll_progress_bar);
        ImageView imageView = (ImageView) getView().findViewById(R.id.img_progress);

        animationDrawable = (AnimationDrawable) imageView.getDrawable();

        if (!animationDrawable.isRunning()){
            animationDrawable.start();
        }
        mRefresh = (LinearLayout) getView().findViewById(R.id.ll_error_refresh);
        mRefresh.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                showLoading();
            }
        });
        bindingView.getRoot().setVisibility(View.GONE);

    }

    //  ????
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()){
            mIsVisible =true;
            onVisible();
        } else {
            mIsVisible = false;
            onInvisible();
        }


    }

    private void onInvisible() {
    }

    protected void onVisible() {
        loadData();
    }

    /**
     * 加载完成的状态
     */
    protected void showContentView() {
        if (llProgressBar.getVisibility() != View.GONE) {
            llProgressBar.setVisibility(View.GONE);
        }
        // 停止动画
        if (animationDrawable.isRunning()) {
            animationDrawable.stop();
        }
        if (mRefresh.getVisibility() != View.GONE) {
            mRefresh.setVisibility(View.GONE);
        }
        if (bindingView.getRoot().getVisibility() != View.VISIBLE) {
            bindingView.getRoot().setVisibility(View.VISIBLE);
        }
    }

    /**
     * 显示时加载数据,需要这样的使用
     * 注意声明 isPrepared，先初始化
     * 生命周期会先执行 setUserVisibleHint 再执行onActivityCreated
     * 在 onActivityCreated 之后第一次显示加载数据，只加载一次
     */
    protected void loadData() {
    }


    protected void showLoading(){
        if (llProgressBar.getVisibility() != View.VISIBLE){
            llProgressBar.setVisibility(View.VISIBLE);
        }
        if (!animationDrawable.isRunning()){
            animationDrawable.start();
        }
        if (bindingView.getRoot().getVisibility() != View.GONE) {
            bindingView.getRoot().setVisibility(View.GONE);
        }
        if (mRefresh.getVisibility() != View.GONE) {
            mRefresh.setVisibility(View.GONE);
        }

    }

    /**
     * 加载失败点击重新加载的状态
     */
    protected void showError() {
        if (llProgressBar.getVisibility() != View.GONE) {
            llProgressBar.setVisibility(View.GONE);
        }
        // 停止动画
        if (animationDrawable.isRunning()) {
            animationDrawable.stop();
        }
        if (mRefresh.getVisibility() != View.VISIBLE) {
            mRefresh.setVisibility(View.VISIBLE);
        }
        if (bindingView.getRoot().getVisibility() != View.GONE) {
            bindingView.getRoot().setVisibility(View.GONE);
        }
    }

    public void addSubscription(Subscription s) {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeSubscription();
        }
        this.mCompositeSubscription.add(s);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (this.mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            this.mCompositeSubscription.unsubscribe();
        }
    }
}
