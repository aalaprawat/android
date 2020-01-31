package com.example.jobscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public final static String mymsg = "this message needs to be displayed" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter i = new IntentFilter();
        i.addAction(mymsg);
        registerReceiver(new custom_reciever(),i);

    }

    public void custom(View view) {
        Intent i = new Intent();
        i.setAction(mymsg);
        sendBroadcast(i);

    }
}
