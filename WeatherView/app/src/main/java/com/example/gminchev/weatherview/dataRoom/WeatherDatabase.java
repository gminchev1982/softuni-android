package com.example.gminchev.weatherview.dataRoom;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {WeatherEntity.class}, version = 1)
public abstract class WeatherDatabase extends RoomDatabase {

    public abstract  WeatherDao WeatherDao();


}
