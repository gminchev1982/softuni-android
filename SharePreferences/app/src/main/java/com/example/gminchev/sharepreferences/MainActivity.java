package com.example.gminchev.sharepreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by GMinchev on 26.3.2018 г..
 */

public class MainActivity extends AppCompatActivity {
 @BindView(R.id.txt_location)  TextView txtLocation;
    private static final String TAG = "MainActivity";
    private static  final String ShareKey = "Location";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Log.v(TAG, "OnCreate");
        startService(new Intent(this,LocationService .class));


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(ShareKey," Locations");
        editor.commit();


        String Location = PreferenceManager.getDefaultSharedPreferences(this).getString(ShareKey, "");
        txtLocation.setText(Location);

    }


}
