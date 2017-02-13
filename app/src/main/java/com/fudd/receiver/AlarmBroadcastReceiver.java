package com.fudd.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by Nordpol on 2017/2/13 0013.
 */

public class AlarmBroadcastReceiver extends BroadcastReceiver {
    Uri ringUri;

    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("msg");
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        MediaPlayer mp = new MediaPlayer();
        String uri = intent.getStringExtra("ringURI");
        if (uri!=null) {
            ringUri = Uri.parse(uri);
            Log.d("AlarmActivity", ringUri.toString());
        }

        try {
            mp.setDataSource(context, ringUri);
            mp.prepare();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mp.start();
    }
}
