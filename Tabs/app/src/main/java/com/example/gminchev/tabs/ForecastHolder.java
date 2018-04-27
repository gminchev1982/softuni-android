package com.example.gminchev.tabs;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.gminchev.tabs.dataModel.helper_models.ShortForecast;
import com.example.gminchev.tabs.databinding.WeatherDetailCardBinding;
import com.example.gminchev.tabs.service.OnCartListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ForecastHolder extends RecyclerView.ViewHolder {

    private WeatherDetailCardBinding binding;
    private OnCartListener cartListener;
    public ForecastHolder(WeatherDetailCardBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(ShortForecast shortForecast, OnCartListener cartListener) {
        this.cartListener  = cartListener;

        binding.txtTodayDate.setText(new SimpleDateFormat("MM/dd HH:mm").format(new Date(shortForecast.getTimestamp())));
        binding.imgWeather.setImageResource(WeatherUtils.getImageByWeatherType(shortForecast.getWeatherType()));
        binding.grpCard.setBackgroundColor(binding.getRoot().getContext().getResources().getColor(WeatherUtils.getColorByTemperature(shortForecast.getTemperature())));
        binding.txtDescription.setText(shortForecast.getWeatherLongDescription());
        binding.txtShortWeather.setText(shortForecast.getWeatherShortDescription());

        binding.txtTemp.setText(binding.getRoot().getContext().getString(R.string.temperature_holder, (int) shortForecast.getTemperature()));

        binding.grpCard.setOnClickListener((view)->{
            Log.e ("click", "click");
            cartListener.onDayClick(2);
        });
    }


}