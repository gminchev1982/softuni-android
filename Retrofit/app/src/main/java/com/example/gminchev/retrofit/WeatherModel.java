package com.example.gminchev.retrofit;

/**
 * Created by GMinchev on 31.3.2018 г..
 */
public class WeatherModel {
    private  Integer code;

    public Integer getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Weather : " + getCode();
    }
}
