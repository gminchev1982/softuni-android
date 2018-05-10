package com.example.gminchev.weatherview.ui.daily;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.gminchev.weatherview.R;
import com.example.gminchev.weatherview.dataModel.helper_models.Forecast;
import com.example.gminchev.weatherview.dataRoom.WeatherEntity;
import com.example.gminchev.weatherview.databinding.WeatherCardBinding;
import com.example.gminchev.weatherview.ui.WeatherUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.gminchev.weatherview.ui.OverallFragment.DATE_FORMAT;

public class DailyHolder extends RecyclerView.ViewHolder{
    WeatherCardBinding binding;
    public DailyHolder(WeatherCardBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(WeatherEntity tomorrowForecast) {
        binding.grpCard.setBackgroundColor(binding.getRoot().getContext().getResources().getColor(WeatherUtils.getColorByTemperature(tomorrowForecast.getTemperature())));
        binding.txtToday.setText("Day");
        binding.txtTodayDate.setText(new SimpleDateFormat(DATE_FORMAT).format(new Date(tomorrowForecast.getDt() + 24 * 60 * 60 * 1000)));
        binding.txtShortWeather.setText(tomorrowForecast.getShortDescription());
        binding.imgWeather.setImageResource(WeatherUtils.getImageByWeatherType(tomorrowForecast.getWeatherType()));
        binding.txtTemp.setText(binding.getRoot().getContext().getString(R.string.temperature_holder, (int) tomorrowForecast.getTemperature()));
        binding.txtTempAmplitude.setText(binding.getRoot().getContext().getString(R.string.temp_amplitude_holder, (int) tomorrowForecast.getMinTemperature(), (int) tomorrowForecast.getMaxTemperature()));
        binding.txtDescription.setText(tomorrowForecast.getLongDescription());
        binding.txtClouds.setText(binding.getRoot().getContext().getString(R.string.percantage_placeholder, (int) tomorrowForecast.getCloudinessInPercentage()));
        binding.txtWind.setText(binding.getRoot().getContext().getString(R.string.m_per_s_placeholder, (int) tomorrowForecast.getWindSpeed()));
        binding.txtHumidity.setText(binding.getRoot().getContext().getString(R.string.percantage_placeholder, (int) tomorrowForecast.getHumidity()));
    }
}
