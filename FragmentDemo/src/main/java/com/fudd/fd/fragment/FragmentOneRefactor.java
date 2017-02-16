package com.fudd.fd.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.fudd.fd.R;

/**
 * Created by cetc1 on 2017-2-16.
 */

public class FragmentOneRefactor extends Fragment implements View.OnClickListener {
    private Button button;

    public interface FragmentOneBtnClickListener{
        void onFragmentOneBtnClick();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one,container,false);
        button = (Button)view.findViewById(R.id.button);
        button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (getActivity() instanceof FragmentOneBtnClickListener ){
            ((FragmentOneBtnClickListener) getActivity()).onFragmentOneBtnClick();
        }
    }
}
