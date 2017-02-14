package com.fudd.fragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fudd.activity.R;
import com.fudd.fragment.subfragment.HomeFragment;
import com.fudd.fragment.subfragment.LikeFragment;
import com.fudd.fragment.subfragment.LocationFragment;
import com.fudd.fragment.subfragment.PersonFragment;
import com.fudd.utils.Constants;

public class TextTabFragment extends Fragment implements View.OnClickListener {
    private TextView mTHome, mTLocation, mTLike, mTMe, mTextView;
    private HomeFragment mHomeFragment;
    private LocationFragment mLocationFragment;
    private LikeFragment mLikeFragment;
    private PersonFragment mPersonFragment;

    public static TextTabFragment newInstance(String s) {
        TextTabFragment viewPagerFragment = new TextTabFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_ARGS, s);
        viewPagerFragment.setArguments(bundle);
        return viewPagerFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text_tab, container, false);
        mTextView = (TextView) view.findViewById(R.id.activity_text_view);
        mTHome = (TextView) view.findViewById(R.id.tv_home);
        mTLocation = (TextView) view.findViewById(R.id.tv_location);
        mTLike = (TextView) view.findViewById(R.id.tv_like);
        mTMe = (TextView) view.findViewById(R.id.tv_person);
        Log.d("Kevin", mTextView.getText().toString());
        Bundle bundle = getArguments();
        if (bundle != null) {
            String s = bundle.getString(Constants.KEY_ARGS);
            Log.i("Kevin", s + "");
            if (!TextUtils.isEmpty(s)) {
                mTextView.setText("");
            }
        }
        mTHome.setOnClickListener(this);
        mTLocation.setOnClickListener(this);
        mTLike.setOnClickListener(this);
        mTMe.setOnClickListener(this);
        setDefaultFragment();
        return view;
    }

    /**
     * set the default Fragment
     */
    private void setDefaultFragment() {
        switchFrgment(0);
        //set the defalut tab state
        setTabState(mTHome, R.drawable.home_fill, getColor(R.color.green));
    }

    @Override
    public void onClick(View view) {
        resetTabState();//reset the tab state
        switch (view.getId()) {
            case R.id.tv_home:
                setTabState(mTHome, R.drawable.home_fill, getColor(R.color.green));
                switchFrgment(0);
                break;
            case R.id.tv_location:
                setTabState(mTLocation, R.drawable.location_fill, getColor(R.color.green));
                switchFrgment(1);
                break;
            case R.id.tv_like:
                setTabState(mTLike, R.drawable.like_fill, getColor(R.color.green));
                switchFrgment(2);
                break;
            case R.id.tv_person:
                setTabState(mTMe, R.drawable.person_fill, getColor(R.color.green));
                switchFrgment(3);
                break;
        }
    }

    /**
     * switch the fragment accordting to id
     * @param i id
     */
    private void switchFrgment(int i) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        switch (i) {
            case 0:
                if (mHomeFragment == null) {
                    mHomeFragment = mHomeFragment.newInstance(getString(R.string.item_home));
                }
                transaction.replace(R.id.sub_content, mHomeFragment);
                break;
            case 1:
                if (mLocationFragment == null) {
                    mLocationFragment = LocationFragment.newInstance(getString(R.string.item_location));
                }
                transaction.replace(R.id.sub_content, mLocationFragment);
                break;
            case 2:
                if (mLikeFragment == null) {
                    mLikeFragment = LikeFragment.newInstance(getString(R.string.item_like));
                }
                transaction.replace(R.id.sub_content, mLikeFragment);
                break;
            case 3:
                if (mPersonFragment == null) {
                    mPersonFragment = PersonFragment.newInstance(getString(R.string.item_person));
                }
                transaction.replace(R.id.sub_content, mPersonFragment);
                break;
        }
        transaction.commit();
    }

    /**
     * set the tab state of bottom navigation bar
     *
     * @param textView the text to be shown
     * @param image    the image
     * @param color    the text color
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void setTabState(TextView textView, int image, int color) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, image, 0, 0);//Call requires API level 17
        textView.setTextColor(color);
    }


    /**
     * revert the image color and text color to black
     */
    private void resetTabState() {
        setTabState(mTHome, R.drawable.home, getColor(R.color.black_1));
        setTabState(mTLocation, R.drawable.location, getColor(R.color.black_1));
        setTabState(mTLike, R.drawable.like, getColor(R.color.black_1));
        setTabState(mTMe, R.drawable.person, getColor(R.color.black_1));

    }

    /**
     * @param i the color id
     * @return color
     */
    private int getColor(int i) {
        return ContextCompat.getColor(getActivity(), i);
    }
}
