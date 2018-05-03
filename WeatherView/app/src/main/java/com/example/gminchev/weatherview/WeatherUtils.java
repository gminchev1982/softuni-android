package com.example.gminchev.weatherview;

import static com.example.gminchev.weatherview.dataModel.WeatherType.CLEAR;
import static com.example.gminchev.weatherview.dataModel.WeatherType.CLOUDS;
import static com.example.gminchev.weatherview.dataModel.WeatherType.DRIZZLE;
import static com.example.gminchev.weatherview.dataModel.WeatherType.EXTREME;
import static com.example.gminchev.weatherview.dataModel.WeatherType.FOG;
import static com.example.gminchev.weatherview.dataModel.WeatherType.RAIN;
import static com.example.gminchev.weatherview.dataModel.WeatherType.SNOW;
import static com.example.gminchev.weatherview.dataModel.WeatherType.THUNDERSTORM;
import static com.example.gminchev.weatherview.dataModel.WeatherType.VARIOUS;

public class WeatherUtils {

    public static int getColorByTemperature(double temperatureInCelsius) {
        if(temperatureInCelsius > 25) {
            return R.color.yellow;
        } else if(temperatureInCelsius > 15) {
            return R.color.green;
        } else {
            return R.color.blue;
        }
    }

    public static int getImageByWeatherType(int weatherType) {
        switch (weatherType) {
            case THUNDERSTORM: return R.drawable.ic_wi_lightning;
            case DRIZZLE: return R.drawable.ic_wi_sleet;
            case RAIN: return R.drawable.ic_wi_rain;
            case SNOW: return R.drawable.ic_wi_snow;
            case FOG: return R.drawable.ic_wi_fog;
            case CLOUDS: return R.drawable.ic_wi_cloudy;
            case VARIOUS: return R.drawable.ic_wi_meteor;
            case EXTREME: return R.drawable.ic_wi_meteor;
            case CLEAR: return R.drawable.ic_wi_day_sunny;
            default: return R.drawable.ic_wi_day_sunny;
        }
    }
}
