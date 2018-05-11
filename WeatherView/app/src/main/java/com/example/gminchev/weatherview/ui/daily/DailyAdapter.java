package com.example.gminchev.weatherview.ui.daily;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.gminchev.weatherview.R;
import com.example.gminchev.weatherview.dataModel.DailyForecast;
import com.example.gminchev.weatherview.dataRoom.WeatherEntity;
import com.example.gminchev.weatherview.databinding.WeatherCardBinding;

import java.util.List;

public class DailyAdapter extends RecyclerView.Adapter<DailyHolder> {

    private  List<WeatherEntity> data;

    public DailyAdapter() {
        //this.data = data;
        // this.cartListener = cartListener;
    }
    @NonNull
    @Override
    public DailyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        WeatherCardBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.weather_card, parent, false);

        return new DailyHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyHolder holder, int position) {
        WeatherEntity current = data.get(position);
        holder.bind(current);
    }



    public void setData(List<WeatherEntity> data) {
            this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {

       if (data==null)
        return 0;
       else return  data.size();
    }
}
