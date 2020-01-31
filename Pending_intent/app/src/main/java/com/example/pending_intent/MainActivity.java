package com.example.pending_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    PendingIntent pendingIntent;
    Intent intent;
    EditText edt;
    Date date;
    AlarmManager alm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        date = new Date();
        setContentView(R.layout.activity_main);
        edt = findViewById(R.id.edittext);
        intent = new Intent(MainActivity.this,AlarmManagerBroadcast.class);
        pendingIntent = PendingIntent.getBroadcast(MainActivity.this,234,intent,0);
    }

    public void start(View view) {
        int i = Integer.parseInt(edt.getText().toString());
        alm = (AlarmManager) getSystemService(ALARM_SERVICE);
        alm.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (i * 3600 * 1000), pendingIntent);
            Toast.makeText(MainActivity.this, "alarm set for " + i + "hours Time:" + (date.getHours() + i)%24 + ":" + (date.getMinutes()), Toast.LENGTH_LONG).show();

    }
        public void snooze (View view){
        }

    public void stop(View view) {
    }
}
