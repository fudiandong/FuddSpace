package com.fudd.fd;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

import com.fudd.fd.fragmentdialog.EditFragmentDialog;
import com.fudd.fd.fragmentpk.FragmentA;

/**
 * Created by fudd-office on 2017-2-20 13:50.
 * Email: 5036175@qq.com
 * QQ: 5036175
 */

public class FragmentActivity extends Activity implements FragmentA.FragmentAclickListener{

    private static final String TAG = "FragmentActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 测试机 为华为荣耀6，暂不知道为何布显示log d 等日志，只显示 w e 级别日志
        Log.e(TAG,"onCreate");
        setContentView(R.layout.activity_main);
        Log.e(TAG,savedInstanceState+"===");
        FragmentA fragmentA = new FragmentA();
        fragmentA.setFragmentAclickListener(this);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.id_content,fragmentA,"fragmentA");
        fragmentTransaction.commit();


    }

    @Override
    public void onFragmentAclick() {
        Log.e(TAG,"onFragmentAclick");
        showDialog();

    }
    public void showDialog(){
        EditFragmentDialog fragmentDialog = new EditFragmentDialog();
        fragmentDialog.show(getFragmentManager(),"dialog");
    }
}
