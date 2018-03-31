package com.example.gminchev.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "ffMainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WeatherService.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

       WeatherService service = retrofit.create(WeatherService.class);
        service.getDay("Sofia").enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                Log.e(TAG, "Response : " + response.isSuccessful());
                if (response.isSuccessful()) {
                   // WeatherModel data = response.body();
                    //Log.e(TAG, "Code" +  data.getCode());
                    //txtWeather.setText(data.toString());
                }
            }

            @Override
            public void onFailure(Call <WeatherModel> call, Throwable t) {
                Log.e(TAG, "FAILURE ");
            }
        });


    }
}
