package com.fudd.fd.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.fudd.fd.R;

/**
 * Created by cetc1 on 2017-2-16.
 */

public class FragmentPeriod extends Fragment implements View.OnClickListener {
    private Button button;
    private Bundle bundle;
    private FragmentPeriodBtnClickListener fragmentPeriodBtnClickListener;

    @Override
    public void onClick(View v) {
        if (fragmentPeriodBtnClickListener != null){
            fragmentPeriodBtnClickListener.onFragmentPeriodBtnClick();
        }
    }

    public interface FragmentPeriodBtnClickListener{
        void onFragmentPeriodBtnClick();

    }

    public void setFragmentPeriodBtnClickListener(FragmentPeriodBtnClickListener listener){
        this.fragmentPeriodBtnClickListener = listener;
    }



    // 保存临时数据的方法
    private Bundle saveState(){
        Bundle state = new Bundle();
        state.putString("author","fudiandong");
        return state;
    }

    private void saveStateToArg(){
        bundle = saveState();
        if (bundle != null){
            Bundle b = getArguments();
            b.putBundle("saveViewState",bundle);
        }
    }

    // 取出临时数据
    private String restoreState(){
        if (bundle != null){
            String val = bundle.getString("author");
            return val;
        }
        return "";
    }

    private boolean restorStateFromArg(){
        Bundle b = getArguments();
        bundle = b.getBundle("saveViewState");
        if (bundle != null){
            restoreState();
            return true;
        }
        return false;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG,"onActivityCreated");
//        if (!restorStateFromArg()){
//
//        }
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.e(TAG,"onViewStateRestored");
        if (savedInstanceState != null){
            Log.e(TAG,"onViewStateRestored----"+savedInstanceState.getString("tx"));
            editText.setText(savedInstanceState.getString("tx"));
        }

    }

    private static final String TAG = "FragmentPeriod";
    private EditText editText;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG,editText.getText().toString());
        outState.putString("tx",editText.getText().toString());


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG,"onCreate");
        bundle = savedInstanceState;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG,"onDestroyView");
        if (bundle != null){
            bundle.putString("tx",editText.getText().toString());
        }

    }

    @Override
    public void onPause() {
        super.onPause();
//        Log.e(TAG,"onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
//        Log.e(TAG,"onStop");
    }

    @Override
    public void onStart() {
        super.onStart();
//        Log.e(TAG,"onStart");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e(TAG,"onCreateView");
        View view = inflater.inflate(R.layout.fragment_one,container,false);
        editText = (EditText) view.findViewById(R.id.edittext);

        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(this);
//        if (savedInstanceState.getString("tx") != null){
//
//        }
        return view;
    }
}
