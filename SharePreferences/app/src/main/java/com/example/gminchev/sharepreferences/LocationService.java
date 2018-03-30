package com.example.gminchev.sharepreferences;

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

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by GMinchev on 30.3.2018 г..
 */

public class LocationService extends Service implements android.location.LocationListener {
    private static final String TAG = "LocationService";
    public static final int LOCATION_INTERVAL = 1000;
    public static final float LOCATION_DISTANCE = 1f;
    LocationManager mLocationManager;
    private Location mLastLocation;
    private String provider = LocationManager.GPS_PROVIDER;

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

        Geocoder geoCoder = new Geocoder(this, Locale.getDefault());
        StringBuilder builder = new StringBuilder();
        try {
            List<Address> address = geoCoder.getFromLocation(latitude, longitude, 1);
            Log.e(TAG, "List : " + address.toString());
            String adminArea = address.get(0).getAdminArea();
            String[] arrayArea = adminArea.split(" ");
            String cityName = null;
            if (arrayArea.length>0){
                cityName = arrayArea[0];
            }
            Log.e(TAG, "Index : " +  arrayArea[0]);
            /*for (int i=0; i<maxLines; i++) {
                String addressStr = address.get(0).getAddressLine(i);
                builder.append(addressStr);
                builder.append(" ");
            }*/

            String finalAddress = builder.toString(); //This is the complete address.
            Log.e(TAG, "Logitude : " + longitude);
            Log.e(TAG, "finalAddress: " + finalAddress);
           // Toast.makeText(this, "fnialAddress : "  + fnialAddress, Toast.LENGTH_SHORT).show();
            PreferenceManager.getDefaultSharedPreferences(this).edit().putString(Constants.ShareKeyAddress, String.valueOf(cityName)).commit();
           

        } catch (IOException e) {
            // Handle IOException
        } catch (NullPointerException e) {
            // Handle NullPointerException
        }

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
