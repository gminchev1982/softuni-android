package com.example.gminchev.weatherview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.gminchev.weatherview.api.Api;
import com.example.gminchev.weatherview.dataModel.CurrentWeather;
import com.example.gminchev.weatherview.dataModel.DailyForecast;
import com.example.gminchev.weatherview.dataModel.helper_models.Forecast;
import com.example.gminchev.weatherview.databinding.FragmentOverallBinding;
import com.example.gminchev.weatherview.databinding.WeatherCardBinding;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OverallFragment extends Fragment{

    private OnFragmentTitleListener mListener;
    private OnFragmentDataListener mDataListener;
   private FragmentOverallBinding  binding;
   private WeatherCardBinding grpCurrentWeather;
   private WeatherCardBinding grpTomorrowWeather;
    public static final String DATE_FORMAT = "mm/dd/yyyy";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_overall, container, false);
        setupViews();




        return binding.getRoot();
    }

    private void setupViews() {

        //grpCurrentWeather = DataBindingUtil.bind( binding.grpCurrentWeather.getRoot()  binding.grpCurrentWeather.getRoot());
          grpCurrentWeather = DataBindingUtil.bind(binding.grpCurrentWeather.getRoot());
            grpTomorrowWeather = DataBindingUtil.bind(binding.grpTomorrowWeather.getRoot());

            updateData();
       // grpCurrentWeather.

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnFragmentTitleListener) {
            mListener = (OnFragmentTitleListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void updateData() {
        //String longitude = PreferenceManager.getDefaultSharedPreferences(getActivity()).getString(Constants.ShareKeyLongitude, null);
        //String latitude = PreferenceManager.getDefaultSharedPreferences(getActivity()).getString(Constants.ShareKeyLatitude, null);

        String longitude = "42.697054";
        String latitude = "23.328720";

        if(longitude != null) {
            Api.getInstance().getCurrentWeather(latitude, longitude,  new Api.DataListener<CurrentWeather>() {

                @Override
                public void onSuccess(CurrentWeather data) {
                    updateCurrentWeather(data);
                    //binding.swiperefresh.setRefreshing(false);
                }

                @Override
                public void onError() {
                    //binding.swiperefresh.setRefreshing(false);
                    Toast.makeText(getContext(), "Error while updating current weather", Toast.LENGTH_SHORT).show();
                }
            });

            Api.getInstance().getDailyForecast(latitude, longitude, new Api.DataListener<DailyForecast>() {
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
    }


    private void updateCurrentWeather(CurrentWeather data) {
        //((MainActivity) getActivity()).getSupportActionBar().setTitle(data.getLocationName());
        mListener.onTitleChange(data.getLocationName());
        Log.e ("Name", data.getLocationName());
        grpCurrentWeather.grpCard.setBackgroundColor(getResources().getColor(WeatherUtils.getColorByTemperature(data.getTemperature())));
        grpCurrentWeather.txtTodayDate.setText(new SimpleDateFormat(DATE_FORMAT).format(new Date()));
        grpCurrentWeather.txtShortWeather.setText(data.getWeatherShortDescription());
        grpCurrentWeather.imgWeather.setImageResource(WeatherUtils.getImageByWeatherType(data.getWeatherType()));
        grpCurrentWeather.txtTemp.setText(getString(R.string.temperature_holder, (int) data.getTemperature()));
        grpCurrentWeather.txtTempAmplitude.setText(getString(R.string.temp_amplitude_holder, (int) data.getMinTemperature(), (int) data.getMaxTemperature()));
        grpCurrentWeather.txtDescription.setText(data.getWeatherLongDescription());
        grpCurrentWeather.txtClouds.setText(getString(R.string.percantage_placeholder, (int) data.getCloudinessInPercentage()));
        grpCurrentWeather.txtWind.setText(getString(R.string.m_per_s_placeholder, (int) data.getWindSpeed()));
        grpCurrentWeather.txtHumidity.setText(getString(R.string.percantage_placeholder, (int) data.getHumidity()));
        Date dt = new Date();

        grpCurrentWeather.grpCard.setOnClickListener(v->  mListener.onViewPageChange(data.getDt()));

    }
    private void updateDailyForecast(DailyForecast data) {
        Forecast tomorrowForecast = data.getForecastForDay(0);
        grpTomorrowWeather.grpCard.setBackgroundColor(getResources().getColor(WeatherUtils.getColorByTemperature(tomorrowForecast.getTemperatures().day)));
        grpTomorrowWeather.txtToday.setText(getString(R.string.tomorrow));
        grpTomorrowWeather.txtTodayDate.setText(new SimpleDateFormat(DATE_FORMAT).format(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000)));
        grpTomorrowWeather.txtShortWeather.setText(tomorrowForecast.getWeatherShortDescription());
        grpTomorrowWeather.imgWeather.setImageResource(WeatherUtils.getImageByWeatherType(tomorrowForecast.getWeatherType()));
        grpTomorrowWeather.txtTemp.setText(getString(R.string.temperature_holder, (int) tomorrowForecast.getTemperatures().day));
        grpTomorrowWeather.txtTempAmplitude.setText(getString(R.string.temp_amplitude_holder, (int) tomorrowForecast.getTemperatures().min, (int) tomorrowForecast.getTemperatures().max));
        grpTomorrowWeather.txtDescription.setText(tomorrowForecast.getWeatherLongDescription());
        grpTomorrowWeather.txtClouds.setText(getString(R.string.percantage_placeholder, (int) tomorrowForecast.getCloudinessInPercentage()));
        grpTomorrowWeather.txtWind.setText(getString(R.string.m_per_s_placeholder, (int) tomorrowForecast.getWindSpeed()));
        grpTomorrowWeather.txtHumidity.setText(getString(R.string.percantage_placeholder, (int) tomorrowForecast.getHumidity()));

    }

    public interface OnFragmentTitleListener {
        void onTitleChange(String title);
        void onViewPageChange(long date);
    }

    public interface OnFragmentDataListener {
        void onDataSend(String title);
        void onFragmentTranserData(String data);
        //void onViewPageChange(Date date);
    }

}
