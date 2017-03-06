package com.fudd.live.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by fudd-office on 2017-3-6 15:50.
 * Email: 5036175@qq.com
 * QQ: 5036175
 * Description:
 */

public class ListFragmentPagerAdaper extends FragmentPagerAdapter {

    private List<?> mFragments;
    private List<String> mTitleList;


    public ListFragmentPagerAdaper(FragmentManager fm) {
        super(fm);
    }

    public ListFragmentPagerAdaper(FragmentManager fm, List<?> mFragment){
        super(fm);
        this.mFragments = mFragment;

    }



    @Override
    public Fragment getItem(int position) {
        return (Fragment) mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (mTitleList != null){
            return mTitleList.get(position);
        }else {
            return "";
        }
    }
}
