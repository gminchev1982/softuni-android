package com.example.gminchev.sharepreferences.old;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

/**
 * Created by GMinchev on 27.3.2018 г..
 */

public class LocationListener  implements android.location.LocationListener{

    private LocationManager mLocationManager = null;
    public static final int LOCATION_INTERVAL = 1000;
    public static final float LOCATION_DISTANCE = 10f;
    private Location mLastLocation;
    private static final String TAG = "LocationListener";
    public static  final String ShareKeyLongitude = "Longitude";
    public static  final String ShareKeyLatitude= "Latitude";
    Context context;

    public LocationListener(String provider, Context context) {
        Log.e(TAG, "LocationListener s" + provider);
        mLastLocation = new Location(provider);
        this.context = context;
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.e(TAG, "onLocationChanged: " + location);
        mLastLocation.set(location);

        Log.e(TAG, "onLocationChanged: " + location);
        mLastLocation.set(location);
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        Log.e(TAG, "Longitude: " + longitude);
        Log.e(TAG, "latitude: " + latitude);


    //    Toast.makeText(context,longitude + "/ "+ latitude + " ",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.e(TAG, "onStatusChanged: " + provider);
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.e(TAG, "onProviderEnabled: " + provider);
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.e(TAG, "onProviderDisabled: " + provider);
        Toast.makeText(context,"GPS is de",Toast.LENGTH_LONG).show();

    }
}
