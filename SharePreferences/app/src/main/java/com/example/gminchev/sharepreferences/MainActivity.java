package com.example.gminchev.sharepreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by GMinchev on 26.3.2018 г..
 */

public class MainActivity extends AppCompatActivity {

    private static  final String ShareKey = "Location";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(ShareKey," Locations");
        editor.commit();


        String Location = PreferenceManager.getDefaultSharedPreferences(this).getString(ShareKey, "");


    }
}
