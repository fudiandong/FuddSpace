package com.fudd.fd.fragmentpk;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.fudd.fd.R;

/**
 * Created by fudd-office on 2017-2-20 13:57.
 * Email: 5036175@qq.com
 * QQ: 5036175
 */

public class FragmentA extends Fragment implements View.OnClickListener {

    private static final String TAG = "FragmentA";
    private FragmentAclickListener fragmentAclickListener;
    private Button button;


    public interface FragmentAclickListener{
        void onFragmentAclick();
    }

    public void setFragmentAclickListener(FragmentAclickListener listener){
        this.fragmentAclickListener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e(TAG,"onCreateView");
        View view = inflater.inflate(R.layout.fragment_one,container,false);
        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG,"onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG,"onStart");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG,"onStart");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG,"onStart");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onStart");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG,"onStart");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(TAG,"onStart");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG,"onStart");
    }

    @Override
    public void onClick(View v) {
        Log.e(TAG,"onClick");
        if (fragmentAclickListener != null){
            fragmentAclickListener.onFragmentAclick();
        }
    }
}
