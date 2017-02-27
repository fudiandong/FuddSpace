package com.fudd.live.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by fudd-office on 2017-2-27 09:17.
 * Email: 5036175@qq.com
 * QQ: 5036175
 */

public class SharedPreferencesUtil {
    private static final String spFileName = "live";

    public static Boolean getBoolean(Context context, String strKey,Boolean strDefault){
        SharedPreferences sharedPreferences = context.getSharedPreferences(spFileName,Context.MODE_PRIVATE);
        Boolean result = sharedPreferences.getBoolean(strKey,strDefault);
        return result;
    }

    public static void putBoolean(Context context, String strKey,Boolean strData){
        SharedPreferences sharedPreferences = context.getSharedPreferences(spFileName,Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(strKey, strData);
        edit.commit();
    }

}
