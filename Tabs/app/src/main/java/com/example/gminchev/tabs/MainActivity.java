package com.example.gminchev.tabs;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
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
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity implements TimeLineFragment.OnFragmentDataReceived {
    private Toolbar toolbar;
    private FusedLocationProviderClient mFusedLocationClient;
    WeatherDatabase db;
    private double mLatitude;
    private double mLongitude;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
      //   db = Room.databaseBuilder(getApplicationContext(), WeatherDatabase.class, "weather.db").build();
       setupLocation();
       setupToolbar();
       setupData();
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TimeLineFragment fragment = new TimeLineFragment();
        fragmentTransaction.add(R.id.grp_container, fragment);
        fragmentTransaction.disallowAddToBackStack();
        fragmentTransaction.commit();
    }

    private void setupData() {
        long s = 1524208410;
        String date = getTimestampToDate(s);
        Log.e("date", date.toString());
    }

    public static String toISO8601UTC(Date date) {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        df.setTimeZone(tz);
        return df.format(date);
    }

    public String getTimestampToDate(long  time){
        Date date = new Date(time*1000L); // *1000 is to convert seconds to milliseconds
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // the format of your date
        sdf.setTimeZone(TimeZone.getTimeZone("GMT-3"));

        return sdf.format(date);

    }

    private void setupLocation() {

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        
        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            // Logic to handle location object
                            mLatitude = location.getLatitude();
                            mLongitude = location.getLongitude();
                            Log.e("lat", String.valueOf(mLatitude));
                            Log.e("long", String.valueOf(mLongitude));
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

    private void setupToolbar() {
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_primary, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.item_refresh) {
            Toast.makeText(this, "Stories", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onDataReceived(Integer position) {

        String title = null;
        switch (position) {
            case 0:
                title = "Overall";
                break;
            case 1:
                title = "Detail";
                break;
            default:
                break;
        }

        toolbar.setTitle(title);
    }

    private Location getLastKnownLocation(){
        if( ActivityCompat.checkSelfPermission( this, Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission( this, Manifest.permission.ACCESS_COARSE_LOCATION ) != PackageManager.PERMISSION_GRANTED ){
            return null;
        }
        LocationManager locationManager =
                (LocationManager) this.getSystemService( LOCATION_SERVICE );

        List<String> providers = locationManager.getProviders( true );
        Location bestLocation = null;
        for( String provider : providers ){
            Location l = locationManager.getLastKnownLocation( provider);

            if( l == null ){
                continue;
            }
            if( bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy() ){
                Log.e("Loc", String.valueOf(l.getLatitude()));
                bestLocation = l; // Found best last known location;
            }
        }
        return bestLocation;
    }
}
