package com.example.gminchev.sharepreferences.old;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.*;
import android.os.Bundle;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;

import com.example.gminchev.sharepreferences.Constants;

/**
 * Created by GMinchev on 30.3.2018 г..
 */

public class LocService extends Service  implements android.location.LocationListener{
    private static final String TAG = "LocationService";
    public static final int LOCATION_INTERVAL = 1000;
    public static final float LOCATION_DISTANCE = 1f;
    LocationManager mLocationManager;
    private Location mLastLocation;
    private String provider  = LocationManager.GPS_PROVIDER;

    @Override
    public void onCreate() {
        super.onCreate();
        mLastLocation = new Location(provider);
        initializeLocationManager();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
       // Toast.makeText(this, "OnStartCommand", Toast.LENGTH_SHORT).show();
        Log.v(TAG, "onStartCommand");

        try {
            mLocationManager.requestLocationUpdates(
                    provider,
                    LOCATION_INTERVAL,
                    LOCATION_DISTANCE,
                    this
            );
            //showCurrentLocation();

        } catch (java.lang.SecurityException ex) {
            Log.i(TAG, "fail to request location update, ignore", ex);
        } catch (IllegalArgumentException ex) {
            Log.d(TAG, "network provider does not exist, " + ex.getMessage());
        }

        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();

       //sendBroadcastMessage(location);
        PreferenceManager.getDefaultSharedPreferences(this).edit().putString(Constants.ShareKeyLongitude, String.valueOf(longitude)).commit();
        PreferenceManager.getDefaultSharedPreferences(this).edit().putString(Constants.ShareKeyLatitude, String.valueOf(latitude)).commit();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    private void initializeLocationManager() {
       // Log.e(TAG, "initializeLocationManager - LOCATION_INTERVAL: " + LOCATION_INTERVAL + " LOCATION_DISTANCE: " + LOCATION_DISTANCE);

        if (mLocationManager == null) {
            mLocationManager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        }
    }

    private void sendBroadcastMessage(Location location) {
        if (location != null) {
            Intent intent = new Intent(Constants.BROADCAST_ACTION);
            intent.putExtra(Constants.EXTRA_LATITUDE, location.getLatitude());
            intent.putExtra(Constants.EXTRA_LONGITUDE, location.getLongitude());
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mLocationManager = null;
        mLastLocation = null;
    }
}
