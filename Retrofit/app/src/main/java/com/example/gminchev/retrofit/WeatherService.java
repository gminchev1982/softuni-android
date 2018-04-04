package com.example.gminchev.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by GMinchev on 31.3.2018 г..
 */

public interface WeatherService {
    public static final String URL = "http://api.openweathermap.org/";

    @GET("/data/2.5/forecast?q=Sofia&appid=757a29d8eb6a37161fb81c451e4eb3ff")
    Call <WeatherModel> getWeatherDay();
    //@GET("users/list")
    @GET("/data/2.5/forecast?q={ct}&appid=757a29d8eb6a37161fb81c451e4eb3ff&cnt=2")
    Call <WeatherModel> getDay(@Path("ct") String ct);

}

