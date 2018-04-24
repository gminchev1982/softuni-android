package com.example.gminchev.tabs;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gminchev.tabs.api.Api;
import com.example.gminchev.tabs.dataModel.CurrentWeather;
import com.example.gminchev.tabs.dataModel.DailyForecast;
import com.example.gminchev.tabs.dataModel.HourlyForecast;
import com.example.gminchev.tabs.dataModel.helper_models.Forecast;
import com.example.gminchev.tabs.databinding.FragmentDetailBinding;

public class DetailFragment extends Fragment {
    FragmentDetailBinding binding;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_detail, container, false);
        setupViews();
        return binding.getRoot();
    }

    private void setupViews() {
        binding.recView.setLayoutManager(new LinearLayoutManager(getContext()));
        updateData();
    }

    private void updateData() {
        String longitude = PreferenceManager.getDefaultSharedPreferences(getActivity()).getString(Constants.ShareKeyLongitude, null);
        String latitude = PreferenceManager.getDefaultSharedPreferences(getActivity()).getString(Constants.ShareKeyLatitude, null);
        if(longitude != null) {
            Api.getInstance().getHourlyForecast(latitude, longitude, new Api.DataListener<HourlyForecast>() {

                @Override
                public void onSuccess(HourlyForecast data) {
                    updateHourlyWeather(data);
                    Log.e("TAG", "Onsuccess");
                   // binding.swiperefresh.setRefreshing(false);
                }
                @Override
                public void onError() {
                  //  binding.swiperefresh.setRefreshing(false);
                    Toast.makeText(getContext(), "Error while updating hourly weather", Toast.LENGTH_SHORT).show();
                }
            });
        }
        }


    private void updateHourlyWeather(HourlyForecast data) {
        Log.e("TAG", "updateHourly"  );

        ForecastAdapter adapter = new ForecastAdapter(data);
        binding.recView.setAdapter(adapter);
        Log.e("TAG", "updateHourly"  );
    }

}
