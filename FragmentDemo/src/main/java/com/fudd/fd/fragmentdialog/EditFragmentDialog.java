package com.fudd.fd.fragmentdialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.fudd.fd.R;

/**
 * Created by fudd-office on 2017-2-20 15:16.
 * Email: 5036175@qq.com
 * QQ: 5036175
 */

public class EditFragmentDialog extends DialogFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.dialog,container,false);
        return view;
    }
}
