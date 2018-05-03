package com.example.gminchev.weatherview.dataModel;


import com.example.gminchev.weatherview.dataModel.helper_models.Forecast;
import com.example.gminchev.weatherview.dataModel.helper_models.LocationInfo;

import java.util.List;

public class DailyForecast {

    private LocationInfo city;
    private List<Forecast> list;

    public String getLocationName() {
        return city.name;
    }

    public Forecast getForecastForDay(int dayIndex) {
        return list.get(dayIndex);
    }
}
