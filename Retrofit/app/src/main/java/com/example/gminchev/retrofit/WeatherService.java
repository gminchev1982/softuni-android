package com.example.gminchev.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by GMinchev on 31.3.2018 г..
 */

public interface WeatherService {
    public  static final String URL = "http://api.openweathermap.org/data/2.5/";
    @GET("forecast?q={city}&appid=757a29d8eb6a37161fb81c451e4eb3ff")
    Call<WeatherModel> getWheatherDay(@Path("city") String city);
}

