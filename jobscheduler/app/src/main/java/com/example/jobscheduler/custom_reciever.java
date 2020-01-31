package com.example.jobscheduler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class custom_reciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentstring = intent.getAction();
        switch(intentstring){
            case MainActivity.mymsg:
                Toast.makeText(context, MainActivity.mymsg,Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
