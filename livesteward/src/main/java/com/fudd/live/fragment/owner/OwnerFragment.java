package com.fudd.live.fragment.owner;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.fudd.live.activity.R;
import com.fudd.live.fragment.BaseFragment;
import com.fudd.live.fragment.dialog.DateDialogFragment;

import java.util.List;

import cn.aigestudio.datepicker.cons.DPMode;
import cn.aigestudio.datepicker.views.DatePicker;

/**
 * Created by fudd-office on 2017-3-6 13:44.
 * Email: 5036175@qq.com
 * QQ: 5036175
 * Description:
 */

public class OwnerFragment extends Fragment implements View.OnClickListener {

    public static final int REQUEST_CODE = 0;

    private TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_owner,container,false);
        textView = (TextView) view.findViewById(R.id.tv_date);
        Button btn = (Button) view.findViewById(R.id.btn_show_date);
        btn.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        DateDialogFragment dateDialogFragment = new DateDialogFragment();
        dateDialogFragment.setTargetFragment(OwnerFragment.this,REQUEST_CODE);
        dateDialogFragment.show(getActivity().getSupportFragmentManager(),"date");
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            textView.setText(data.getStringExtra("date"));
        }
    }
}
