package com.example.gminchev.retrofit;

import java.util.List;

/**
 * Created by GMinchev on 31.3.2018 г..
 */
public class WeatherModel {
   // private  Integer cod;
    private double message;
    private List<Day> list;


   /* public Integer getCod() {
        return cod;
    }*/

    public Double getMessage() {
        return message;
    }


    public class Weather {
        public String main;
        public String description;

        public String getDescription() {
            return description;
        }
    }

    public class Day {
        public int dt;
        public Weather[] weather;

        public Weather[] getWeather() {
            return weather;
        }
    }

    public List <Day> getDay() {
        return list;
    }

    @Override
    public String toString() {
        return "Weather : "   + "\n"
                            + getMessage()
                ;
    }
}
