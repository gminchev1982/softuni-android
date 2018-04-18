package com.example.gminchev.tabs;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements TimeLineFragment.OnFragmentDataReceived {
    private Toolbar toolbar;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);

        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Log.e("Test", "IHUU");
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        if (location!=null){
            Toast.makeText(this, "Lat: " + location.getLatitude() + "Lot " + location.getLongitude(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Location null: ", Toast.LENGTH_SHORT).show();
        }


        setupToolbar();

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TimeLineFragment fragment = new TimeLineFragment();
        fragmentTransaction.add(R.id.grp_container, fragment);
        fragmentTransaction.disallowAddToBackStack();
        fragmentTransaction.commit();
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
