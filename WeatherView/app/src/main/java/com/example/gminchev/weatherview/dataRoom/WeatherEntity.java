package com.example.gminchev.weatherview.dataRoom;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity (tableName = "weather")
public class WeatherEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private long dt;
    private String locationName;
    private String imgUrl;
    private int weatherType;
    private String shortDescription;
    private String longDescription;
    private double temperature;
    private double minTemperature;
    private double maxTemperature;
    private double pressure;
    private double humidity;
    private double windSpeed;
    private double windDirectionInDegrees;
    private double cloudinessInPercentage;

    public int getId() {
        return id;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(int  weatherType) {
        this.weatherType = weatherType;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindDirectionInDegrees() {
        return windDirectionInDegrees;
    }

    public void setWindDirectionInDegrees(double windDirectionInDegrees) {
        this.windDirectionInDegrees = windDirectionInDegrees;
    }

    public double getCloudinessInPercentage() {
        return cloudinessInPercentage;
    }

    public void setCloudinessInPercentage(double cloudinessInPercentage) {
        this.cloudinessInPercentage = cloudinessInPercentage;
    }
}
