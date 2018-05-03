package com.example.gminchev.weatherview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gminchev.weatherview.api.Api;
import com.example.gminchev.weatherview.dataModel.HourlyForecast;
import com.example.gminchev.weatherview.dataModel.helper_models.ShortForecast;
import com.example.gminchev.weatherview.databinding.FragmentDetailBinding;
import com.example.gminchev.weatherview.service.OnCartListener;

import java.util.Collections;

public class DetailFragment extends Fragment implements OnCartListener, OverallFragment.OnFragmentTitleListener{
    FragmentDetailBinding binding;
    OnCartListener cartListener;
    private HourlyForecast dataHourly;
    ForecastAdapter adapter;
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
        String longitude = "42.697054"; //PreferenceManager.getDefaultSharedPreferences(getActivity()).getString(Constants.ShareKeyLongitude, null);
        String latitude = "23.328720"; //PreferenceManager.getDefaultSharedPreferences(getActivity()).getString(Constants.ShareKeyLatitude, null);
        Log.e("lat", String.valueOf(latitude));
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
        this.dataHourly = data;
         adapter= new ForecastAdapter(dataHourly);
        adapter.setCartClickListner(this);
        binding.recView.setAdapter(adapter);




    }

    @Override
    public void onDayClick(int position) {
        Log.e ("CArtlISTENER",  String.valueOf(position));
    }

    @Override
    public void onTitleChange(String title) {

    }

    @Override
    public void onViewPageChange(long date) {
        Log.e ("Detail", String.valueOf(date*1000));
        int last= dataHourly.getForecasts().size();
        String dtstr = String.valueOf(date).substring(0, 5);
       // adapter.getFilter().filter(dtstr);


       // dataHourly.getForecasts().remove((last-1));
        adapter.notifyDataSetChanged();
        Log.e("TAG", "updateHourly"  );
        for (ShortForecast dt : dataHourly.getForecasts()){
            Log.e("dd", String.valueOf(dt.getTimestamp()));

        }
         //System.out.println(dataHourly.getForecasts().toString());
    }
}
