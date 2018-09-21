package com.example.gminchev.tabs;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.location.Location;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.gminchev.tabs.dataRoom.WeatherDatabase;
import com.example.gminchev.tabs.databinding.ActivityMainBinding;
import com.example.gminchev.tabs.service.TestService;
import com.example.gminchev.tabs.service.test;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.gminchev.tabs.OverallFragment.DATE_FORMAT;

public class MainActivity extends AppCompatActivity implements OverallFragment.OnFragmentTitleListener {
    private Toolbar toolbar;
    private FusedLocationProviderClient mFusedLocationClient;
    WeatherDatabase db;
    private double mLatitude;
    private double mLongitude;
    private ActivityMainBinding binding;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //setContentView(R.layout.activity_main);
        //toolbar = findViewById(binding.toolbar);
      //   db = Room.databaseBuilder(getApplicationContext(), WeatherDatabase.class, "weather.db").build();
        context = this;
       setSupportActionBar(binding.toolbar);
       setupLocation();

      // setupData();
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TimeLineFragment fragment = new TimeLineFragment();
        fragmentTransaction.add(R.id.grp_container, fragment);
        fragmentTransaction.disallowAddToBackStack();
        fragmentTransaction.commit();

        //startService(new Intent(this, TestService.class));
    }

    private void setupLocation() {

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        mFusedLocationClient.getLastLocation()


                .addOnSuccessListener(this,  new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            // Logic to handle location object
                            mLatitude = location.getLatitude();
                            mLongitude = location.getLongitude();
                            Log.e("lat", String.valueOf(mLatitude));
                            Log.e("long", String.valueOf(mLongitude));
                            PreferenceManager.getDefaultSharedPreferences(context).edit().putString(Constants.ShareKeyLongitude, String.valueOf(mLongitude)).commit();
                            PreferenceManager.getDefaultSharedPreferences(context).edit().putString(Constants.ShareKeyLatitude, String.valueOf(mLatitude)).commit();

                        }
                    }
                })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Error with GPS!", Toast.LENGTH_SHORT).show();
                    }
                });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_primary, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_refresh:
                Toast.makeText(this, "refresh", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


    @Override
    public void onTitleChange(String title) {
        binding.toolbar.setTitle(title);
    }

    @Override
    public void onViewPageChange(Date date) {
            Log.e ("clickDate" , new SimpleDateFormat(DATE_FORMAT).format(new Date()));
    }


}
