package com.fudd.fd.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.fudd.fd.R;

/**
 * Created by fudd-office on 2017-2-20 10:43.
 * Email: 5036175@qq.com
 * QQ: 5036175
 */

public class FragmentStudy extends Fragment implements View.OnClickListener {
    private static final String TAG = "FragmentStudy";
    private Button button;

    private  String mArgument;
    public static final String ARGUMENT = "argument";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG,"onCreate");
        // 解耦合
        Bundle bundle = getArguments();
        if (bundle !=null){
            mArgument = bundle.getString(ARGUMENT);
        }
    }

    public static FragmentStudy newInstance(String argument){
        Bundle bundle = new Bundle();
        bundle.putString(ARGUMENT,argument);
        FragmentStudy fragmentStudy = new FragmentStudy();
        // setArguments 方法必须在Fragment 创建以后，添加给activity前完成
        fragmentStudy.setArguments(bundle);
        return fragmentStudy;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e(TAG,"onCreateView");
        View view = inflater.inflate(R.layout.fragment_study,container,false);
        button = (Button) view.findViewById(R.id.buttonstudy);
        button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        Log.e(TAG,"onClick");
        if (fragmentStudyBtnListener != null){
            fragmentStudyBtnListener.onFragmentStudyBtnClick();
        }
    }

    private FragmentStudyBtnListener fragmentStudyBtnListener;

    public interface FragmentStudyBtnListener{
        void onFragmentStudyBtnClick();
    }
    public void setFragmentStudyBtnClickListener(FragmentStudyBtnListener listener){
        this.fragmentStudyBtnListener = listener;
    }
}
