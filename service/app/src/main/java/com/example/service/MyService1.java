package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService1 extends Service {
    public MyService1() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
