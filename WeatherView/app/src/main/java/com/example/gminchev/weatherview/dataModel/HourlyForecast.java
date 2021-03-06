package com.example.gminchev.weatherview.dataModel;


import com.example.gminchev.weatherview.dataModel.helper_models.LocationInfo;
import com.example.gminchev.weatherview.dataModel.helper_models.ShortForecast;

import java.util.List;

public class HourlyForecast {

    private LocationInfo city;
    private List<ShortForecast> list;

    public String getLocationName() {
        return city.name;
    }

    public List<ShortForecast> getForecasts() {
        return list;
    }
}
