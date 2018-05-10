package com.example.gminchev.weatherview.dataRoom;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.gminchev.weatherview.dataModel.helper_models.Forecast;

import java.util.List;

@Dao
public interface  WeatherDao {

    @Query("SELECT * FROM weather WHERE dt  like :day")
    WeatherEntity  getWeatherDay(String day);

    @Insert
    long insert(WeatherEntity weatherEntity);

    @Query("DELETE FROM weather")
    void deleteAll();

    @Query("SELECT * from weather ORDER BY dt ASC")
    LiveData<List<WeatherEntity>> getAllWeather();
}
