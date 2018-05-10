package com.example.gminchev.weatherview.dataRoom;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import java.util.List;

public class WeatherViewModel extends AndroidViewModel {
    private WeatherRepository mRepository;
    private LiveData<List<WeatherEntity>> mAllWeather;
    public WeatherViewModel(@NonNull Application application) {
        super(application);
        mRepository = new WeatherRepository(application);
        mAllWeather= mRepository.getAllWords();
    }

    public LiveData<List<WeatherEntity>> getAllWeather() { return mAllWeather; }

    public void insert(WeatherEntity word) { mRepository.insert(word); }
}
