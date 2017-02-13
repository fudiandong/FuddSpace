package com.fudd.fragment.subfragment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.fudd.activity.R;
import com.fudd.receiver.AlarmBroadcastReceiver;
import com.fudd.utils.Constants;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static android.app.Activity.RESULT_OK;
import static android.content.ContentValues.TAG;
import static android.content.Context.ALARM_SERVICE;


/**
 * Created by fudd 2017年2月13日 23:20:10
 *
 * 闹铃管理类
 */

public class LocationFragment extends Fragment{
    AlarmManager alarmManager;
    Calendar calendar = Calendar.getInstance(Locale.CHINESE);
    Button setTime;
    Button setRing;
    Button setOver;
    Uri ringUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);


    public static LocationFragment newInstance(String s){
        LocationFragment homeFragment = new LocationFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_ARGS,s);
        homeFragment.setArguments(bundle);
        return homeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_location, container, false);
//        Bundle bundle = getArguments();
//        String s = bundle.getString(Constants.KEY_ARGS);
//        TextView textView = (TextView) view.findViewById(R.id.fragment_text_view);
//        textView.setText(s);

        alarmManager = (AlarmManager) getActivity().getSystemService(ALARM_SERVICE);
        setTime = (Button) view.findViewById(R.id.setTime);
        setRing = (Button) view.findViewById(R.id.setRing);
        setOver = (Button) view.findViewById(R.id.setOver);
        setTimeAndRing();
        return view;
    }
    private void setTimeAndRing(){
        setTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                setTime();
            }
        });
        setRing.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                setRingtone();
            }
        });

        setOver.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                setAlarm(calendar);
            }
        });
    }
    //启动闹玲，设置闹玲
    private void setAlarm(Calendar calendar){
        Intent intent = new Intent();
        intent.setClass(this.getActivity(), AlarmBroadcastReceiver.class);
        intent.putExtra("msg", "Get up!Get up!");
        intent.putExtra("ringURI", ringUri.toString());
        Log.d(TAG, ringUri.toString());
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getActivity(), 0, intent, 0);
        alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(), pendingIntent);
    }
    //设置时间
    private void setTime(){
        Date date = new Date();
        calendar.setTime(date);
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        new TimePickerDialog(this.getActivity(), new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                calendar.set(Calendar.HOUR,hour);
                calendar.set(Calendar.MINUTE,minute);
            }
        }, hour, minute, true).show();
    }


    //设置闹玲铃声
    private void setRingtone(){
        Intent intent = new Intent();
        intent.setAction(RingtoneManager.ACTION_RINGTONE_PICKER);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_DEFAULT, false);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TITLE, "设置闹玲铃声");
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, RingtoneManager.TYPE_ALL);
        Uri pickedUri = RingtoneManager.getActualDefaultRingtoneUri(this.getActivity(),RingtoneManager.TYPE_ALARM);
        if (pickedUri!=null) {
            intent.putExtra(RingtoneManager.EXTRA_RINGTONE_EXISTING_URI,pickedUri);
            ringUri = pickedUri;
        }
        getActivity().startActivityForResult(intent, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode!=RESULT_OK) {
            return;
        }
        switch (requestCode) {
            case 1:
                //获取选中的铃声的URI
                Uri pickedURI = data.getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI);
                Log.i(TAG,pickedURI.toString());
                RingtoneManager.setActualDefaultRingtoneUri(this.getActivity(), RingtoneManager.TYPE_ALARM, pickedURI);
                getName(RingtoneManager.TYPE_ALARM);
                break;

            default:
                break;
        }
    }

    private void getName(int type){
        Uri pickedUri = RingtoneManager.getActualDefaultRingtoneUri(this.getActivity(), type);
        Log.i(TAG,pickedUri.toString());
        Cursor cursor = this.getActivity().getContentResolver().query(pickedUri, new String[]{MediaStore.Audio.Media.TITLE}, null, null, null);
        if (cursor!=null) {
            if (cursor.moveToFirst()) {
                String ring_name = cursor.getString(0);
                Log.i(TAG,ring_name);
                String[] c = cursor.getColumnNames();
                for (String string : c) {
                    Log.i(TAG,string);
                }
            }
            cursor.close();
        }
    }

}
