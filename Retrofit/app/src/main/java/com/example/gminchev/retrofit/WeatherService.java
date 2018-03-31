package com.example.gminchev.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by GMinchev on 31.3.2018 г..
 */

public interface WeatherService {
    public  static final String URL = "http://api.openweathermap.org/data/2.5/";
    public  static final String URLGame = "http://minchev.info/";
    @GET("forecast?q=Sofia&appid=757a29d8eb6a37161fb81c451e4eb3ff")
    Call<WeatherModel> getWeatherDay();

    @GET("forecast?q={city}&appid=757a29d8eb6a37161fb81c451e4eb3ff")
    Call<WeatherModel> getDay(@Part("city") String city );

    @GET ("games.json")
    Call<GameModel> getGame();
}

