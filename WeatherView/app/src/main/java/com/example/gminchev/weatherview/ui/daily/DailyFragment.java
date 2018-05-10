package com.example.gminchev.weatherview.ui.daily;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gminchev.weatherview.R;
import com.example.gminchev.weatherview.dataRoom.WeatherEntity;
import com.example.gminchev.weatherview.dataRoom.WeatherViewModel;
import com.example.gminchev.weatherview.databinding.FragmentDailyBinding;

import java.util.List;

public class DailyFragment extends Fragment {
    private DailyAdapter adapter;
    private FragmentDailyBinding binding;
    private WeatherViewModel mWeatherViewModel;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_daily, container, false);

        mWeatherViewModel = ViewModelProviders.of(this).get(WeatherViewModel.class);
        setupViews();
        return binding.getRoot();
    }

    private void setupViews() {
        binding.recDailyView.setLayoutManager(new LinearLayoutManager(getContext()));



        updateDailyForecast();
        //updateData();
    }

   /* private void updateData() {
        String latitude = "42.697054";
        String longitude = "23.328720";
        Api.getInstance().getDaily(latitude, longitude, new Api.DataListener<DailyForecast>() {
            @Override
            public void onSuccess(DailyForecast data) {
                updateDailyForecast(data);
            }

            @Override
            public void onError() {
                Toast.makeText(getContext(), "Error while updating tomorrow's weather", Toast.LENGTH_SHORT).show();
            }
        });
    }
*/
    private void updateDailyForecast() {

        adapter = new DailyAdapter();
        binding.recDailyView.setAdapter(adapter);

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        mWeatherViewModel.getAllWeather().observe (this, (List<WeatherEntity> weathers) ->{
            if (weathers==null) {
                Log.e ("Weathers", "NUlll");
                adapter.setData(weathers);
            }else {
                Log.e ("Weathers", "OK");
                adapter.setData(weathers);
            }


        });


       // adapter.setCartClickListner(this);

    }

}
