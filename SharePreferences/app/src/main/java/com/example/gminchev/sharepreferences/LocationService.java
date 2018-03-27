package com.example.gminchev.sharepreferences;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by minchev on 27.3.2018 г..
 */

public class LocationService extends Service {
    private static final String TAG = "LocationService";
    LocationManager mLocationManager;
    LocationListener[] mLocationListeners;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        Toast.makeText(this, "OnStartCommand", Toast.LENGTH_SHORT).show();
        Log.v(TAG, "onStartCommand");


        return START_STICKY;
    }


    @Override
    public void onCreate() {

        Log.v(TAG, "onCreate");
        Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();
        initializeLocationManager();
        mLocationListeners = new LocationListener[]{
                new LocationListener(LocationManager.GPS_PROVIDER, this)
        };

        try {
            mLocationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    LocationListener.LOCATION_INTERVAL,
                    LocationListener.LOCATION_DISTANCE,
                    mLocationListeners[0]
            );
        } catch (java.lang.SecurityException ex) {
            Log.i(TAG, "fail to request location update, ignore", ex);
        } catch (IllegalArgumentException ex) {
            Log.d(TAG, "network provider does not exist, " + ex.getMessage());
        }
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.v(TAG, "onBing");
        return null;
    }

    private void initializeLocationManager() {
        Log.e(TAG, "initializeLocationManager - LOCATION_INTERVAL: "+ LocationListener.LOCATION_INTERVAL + " LOCATION_DISTANCE: " + LocationListener.LOCATION_DISTANCE);

        if (mLocationManager == null) {
            mLocationManager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        }
    }


}
