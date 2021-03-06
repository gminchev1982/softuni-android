package com.example.gminchev.sharepreferences;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by GMinchev on 26.3.2018 г..
 */

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.txt_location)    TextView txtLocation;
    @BindView(R.id.txt_weather)    TextView txtWeather;
    private static final String TAG = "MainActivity";
    private static final String ShareKey = "Location";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Log.v(TAG, "OnCreate Main");
        startService(new Intent(this, LocationService.class));


    }

    @Override
    protected void onResume() {
        super.onResume();
        String longitude = PreferenceManager.getDefaultSharedPreferences(this).getString(Constants.ShareKeyLongitude, "00");
        String latitude = PreferenceManager.getDefaultSharedPreferences(this).getString(Constants.ShareKeyLatitude, "00");
        String address = PreferenceManager.getDefaultSharedPreferences(this).getString(Constants.ShareKeyAddress, "00");
        txtLocation.setText(longitude + "/" + latitude);
        Toast.makeText(this, "Address : "  + address, Toast.LENGTH_SHORT).show();





    }
}
