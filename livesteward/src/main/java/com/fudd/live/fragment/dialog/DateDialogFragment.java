package com.fudd.live.fragment.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.fudd.live.activity.R;
import com.fudd.live.fragment.owner.OwnerFragment;

import java.util.ArrayList;
import java.util.List;

import cn.aigestudio.datepicker.bizs.calendars.DPCManager;
import cn.aigestudio.datepicker.bizs.decors.DPDecor;
import cn.aigestudio.datepicker.cons.DPMode;
import cn.aigestudio.datepicker.views.DatePicker;

/**
 * Created by fudd-office on 2017-3-7 15:04.
 * Email: 5036175@qq.com
 * QQ: 5036175
 * Description:
 */

public class DateDialogFragment extends DialogFragment {

    private List<String> bg;
    private List<String> selectList;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_datepicker,null);
//        Toast.makeText(getActivity().getApplicationContext(),selectList.toString(),Toast.LENGTH_SHORT).show();
        bg = new ArrayList<>();
        if(selectList != null){
            bg.addAll(selectList);
            Toast.makeText(getActivity().getApplicationContext(),selectList.toString(),Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getActivity().getApplicationContext(),"selectList == 0",Toast.LENGTH_SHORT).show();
        }
        DPCManager.getInstance().setDecorBG(bg);
        DatePicker datePicker = (DatePicker) view.findViewById(R.id.datepicker);
        //  获取当前年月 year and month
        datePicker.setDate(2017,4);
        datePicker.setMode(DPMode.MULTIPLE);
        datePicker.setOnDateSelectedListener(new DatePicker.OnDateSelectedListener() {
            @Override
            public void onDateSelected(List<String> date) {
//                Toast.makeText(getActivity().getApplicationContext(),date.toString(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.putExtra("date",date.toString());
                if (getTargetFragment() != null){
                    getTargetFragment().onActivityResult(OwnerFragment.REQUEST_CODE, Activity.RESULT_OK,intent);
                }

                if (selectList == null){
                    selectList = new ArrayList<String>();
                }

                if (date != null){
                    for (int i=0;i<date.size();i++){
                        selectList.add(date.get(i));
                    }
                }
                Toast.makeText(getActivity().getApplicationContext(),selectList.toString(),Toast.LENGTH_SHORT).show();
//                getDialog().cancel();
                getDialog().dismiss();
            }
        });

        datePicker.setDPDecor(new DPDecor(){
            @Override
            public void drawDecorBG(Canvas canvas, Rect rect, Paint paint) {
                paint.setColor(Color.RED);
                canvas.drawCircle(rect.centerX(),rect.centerY(),rect.width()/2,paint);
            }
        });
        builder.setView(view);

        return builder.create();
    }


}
