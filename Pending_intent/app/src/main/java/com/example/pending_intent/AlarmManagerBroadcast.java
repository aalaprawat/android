package com.example.pending_intent;

import android.app.AlarmManager;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

public class AlarmManagerBroadcast extends BroadcastReceiver {

    MediaPlayer mp;
    @Override
    public void onReceive(Context context, Intent intent) {
        mp = MediaPlayer.create(context,R.raw.alarm);
        mp.start();
        Toast.makeText(context,"Alarm Rang 2222",Toast.LENGTH_LONG).show();


    }
}