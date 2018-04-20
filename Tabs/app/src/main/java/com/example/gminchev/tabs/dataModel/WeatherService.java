package com.example.gminchev.tabs.dataModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    public static final String URL = "http://api.openweathermap.org/";
    @GET("/data/2.5/weather?appid=757a29d8eb6a37161fb81c451e4eb3ff&units=metric")
    Call<CurrentWeather> getCurrentWeather(@Query("lat") String lat, @Query("lot") String lot);

    @GET("/data/2.5/daily?appid=757a29d8eb6a37161fb81c451e4eb3ff&cnt=1&units=metric")
    Call<DailyForecast> getDailyForecast(@Query("lat") String lat, @Query("lot") String lot);
}
