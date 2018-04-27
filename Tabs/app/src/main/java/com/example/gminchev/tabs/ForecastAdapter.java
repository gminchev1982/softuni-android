package com.example.gminchev.tabs;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gminchev.tabs.dataModel.HourlyForecast;
import com.example.gminchev.tabs.databinding.WeatherDetailCardBinding;
import com.example.gminchev.tabs.service.OnCartListener;

/**
 * Created by teodo on 4/6/2018.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastHolder> {

    private HourlyForecast data;
    private OnCartListener cartListener;
    public ForecastAdapter(HourlyForecast data) {
        this.data = data;
       // this.cartListener = cartListener;
    }

    @Override
    public ForecastHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        WeatherDetailCardBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.weather_detail_card, parent, false);


        return new ForecastHolder(binding);


    }

    @Override
    public void onBindViewHolder(ForecastHolder holder, int position) {
        holder.bind(data.getForecasts().get(position), cartListener);

    }

    @Override
    public int getItemCount() {
        return data.getForecasts().size();
    }

    public void setCartClickListner(DetailFragment cartClickListner) {
        this.cartListener = cartClickListner;
    }
}
