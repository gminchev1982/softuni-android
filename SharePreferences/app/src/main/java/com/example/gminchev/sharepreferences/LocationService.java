package com.example.gminchev.sharepreferences;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by minchev on 27.3.2018 г..
 */

public class LocationService extends Service {
    private static final String TAG = "LocationService";
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        Log.v(TAG, "onStartCommand");
        return START_STICKY;
    }


    @Override
    public void onCreate() {

        Log.v(TAG, "onCreate");
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
