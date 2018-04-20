package com.example.gminchev.tabs.dataRoom;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface  WeatherDao {

    @Query("SELECT * FROM weather WHERE dt  like :day")
    WeatherEntity  getWeatherDay(String day);

    @Insert
    long insert(WeatherEntity weatherEntity);

}
