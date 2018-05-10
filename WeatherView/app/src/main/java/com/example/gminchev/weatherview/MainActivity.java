package com.example.gminchev.weatherview;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.location.Location;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.gminchev.weatherview.databinding.ActivityMainBinding;
import com.example.gminchev.weatherview.ui.Constants;
import com.example.gminchev.weatherview.ui.OverallFragment;
import com.example.gminchev.weatherview.ui.PagerAdapter;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity  implements OverallFragment.OnFragmentTitleListener{
private ActivityMainBinding binding;
    private PagerAdapter adapter;
    private FusedLocationProviderClient mFusedLocationClient;
    private double mLatitude;
    private double mLongitude;
    private static final int MY_PERMISSIONS_REQUEST_GPS = 4;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.toolbar);
        setupLocation();
        setupTabs();
    }

    public void setupTabs() {
        adapter= new PagerAdapter(this, getSupportFragmentManager());
        binding.viewPager.setAdapter(adapter);
        binding.grpTabs.setupWithViewPager(binding.viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_refresh:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        Log.e("requestCode", String.valueOf(requestCode));
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_GPS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    setupLocation();
                }
                return;
            }
        }
    }

    private void setupLocation() {

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
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

                          //  PreferenceManager.getDefaultSharedPreferences(context).edit().putString(Constants.ShareKeyLongitude, String.valueOf(mLongitude)).commit();
                           // PreferenceManager.getDefaultSharedPreferences(context).edit().putString(Constants.ShareKeyLatitude, String.valueOf(mLatitude)).commit();

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
    public void onTitleChange(String title) {
            binding.toolbar.setTitle(title);
    }

    @Override
    public void onViewPageChange(long date) {
       adapter.onViewPageChange(date);
        binding.viewPager.setCurrentItem(1);

    }
}
