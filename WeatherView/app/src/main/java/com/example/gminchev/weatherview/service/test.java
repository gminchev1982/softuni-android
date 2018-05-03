package com.example.gminchev.weatherview.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

public class test extends Service {
    private Handler mHandler;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        mHandler = new Handler();
        ping();

   return START_STICKY;
    }

    private void ping() {
        try {
            //Your code here or call a method
            Toast.makeText(this, "Ehooo", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.e("Error", "In onStartCommand");
            e.printStackTrace();
        }
        scheduleNext();
    }

    private void scheduleNext() {

        mHandler.postDelayed(new Runnable() {
            public void run() { ping(); }
        }, 6000);
    }
}
