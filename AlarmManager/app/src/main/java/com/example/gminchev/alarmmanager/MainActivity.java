package com.example.gminchev.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;
    final int FIFTEEN_SEC_MILLIS = 6000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmMgr = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, SampleBootReceiver.class);
        alarmIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

// Set the alarm to start at 8:30 a.m.
        //10 seconds later
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, 10);

// setRepeating() lets you specify a precise custom interval--in this case,
// 20 minutes.
        alarmMgr.setRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime() + FIFTEEN_SEC_MILLIS,
                FIFTEEN_SEC_MILLIS , alarmIntent);
        Toast.makeText(this, "ddd", Toast.LENGTH_SHORT).show();

    }
}
