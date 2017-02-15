package com.fudd.fd.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.fudd.fd.R;

/**
 * Created by cetc1 on 2017-2-15.
 */

public class FragmentThree extends Fragment implements View.OnClickListener {
    private Button btn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three,container,false);
        btn = (Button) view.findViewById(R.id.button_three);
        btn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getActivity(),"btn in fragment three",Toast.LENGTH_SHORT).show();
    }
}
