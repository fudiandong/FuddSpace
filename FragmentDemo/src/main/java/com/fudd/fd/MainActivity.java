package com.fudd.fd;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import com.fudd.fd.fragment.FragmentOne;
import com.fudd.fd.fragment.FragmentOneRefactor;
import com.fudd.fd.fragment.FragmentPeriod;
import com.fudd.fd.fragment.FragmentStudy;
import com.fudd.fd.fragment.FragmentThree;
import com.fudd.fd.fragment.FragmentTwoRefactor;

public class MainActivity extends Activity implements FragmentStudy.FragmentStudyBtnListener, FragmentPeriod.FragmentPeriodBtnClickListener, FragmentTwoRefactor.FragmentTwoBtnClickListener,FragmentOneRefactor.FragmentOneBtnClickListener{

    private static final String TAG = "MainActivity";
    private FragmentOneRefactor fragmentOneRefactor;
    private FragmentTwoRefactor fragmentTwoRefactor;
    private FragmentThree fragmentThree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null){
//            setFragmentA();
//            setFragmentB();
            setFragmentC();

        }


    }

    private void setFragmentC(){
        Log.e(TAG,"setFragmentC");
        FragmentStudy fragmentStudy = new FragmentStudy();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.id_content,fragmentStudy,"study");
        fragmentTransaction.commit();

    }


    private void setFragmentB() {
        FragmentPeriod fragmentPeriod = new FragmentPeriod();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.id_content,fragmentPeriod,"period");
        ft.commit();

    }

    private void setFragmentA(){
        fragmentOneRefactor = new FragmentOneRefactor();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.id_content,fragmentOneRefactor,"one");
//        fragmentTransaction.addToBackStack(null); 加到回退栈中  再按回退back键 会出显示R.layout.activity_main布局白屏页面
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentTwoBtnClick() {
        if (fragmentThree == null){
            fragmentThree = new FragmentThree();
        }
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.hide(fragmentTwoRefactor);
        fragmentTransaction.add(R.id.id_content,fragmentThree,"three");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentOneBtnClick() {
        if (fragmentTwoRefactor == null){
            fragmentTwoRefactor = new FragmentTwoRefactor();
            fragmentTwoRefactor.setFragmentTwoBtnClickListener(this);
        }
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.hide(fragmentOneRefactor);
        fragmentTransaction.add(R.id.id_content,fragmentTwoRefactor,"two");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentPeriodBtnClick() {
        Log.d("ff","---------");
//        onFragmentOneBtnClick();
    }

    @Override
    public void onFragmentStudyBtnClick() {
        Log.e(TAG,"onFragmentStudyBtnClick");
    }
}
