package com.example.gminchev.weatherview.dataRoom;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

public class WeatherRepository {

    private WeatherDao  mWeatherDao;
    private LiveData<List<WeatherEntity>> mAllWeather;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    WeatherRepository(Application application) {
        WeatherDatabase db = WeatherDatabase.getDatabase(application);
        mWeatherDao = db.WeatherDao();
        mAllWeather=  mWeatherDao.getAllWeather();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<WeatherEntity>> getAllWords() {
        return mAllWeather;
    }

    // You must call this on a non-UI thread or your app will crash.
    // Like this, Room ensures that you're not doing any long running operations on the main
    // thread, blocking the UI.
    public void insert (WeatherEntity weather) {
        new insertAsyncTask(mWeatherDao).execute(weather);
    }

    public void update (WeatherEntity weather) {
        new updateAsyncTask(mWeatherDao).execute(weather);
    }

    private static class insertAsyncTask extends AsyncTask<WeatherEntity, Void, Void> {

        private WeatherDao mAsyncTaskDao;

        insertAsyncTask(WeatherDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final WeatherEntity... params) {
           long id =  mAsyncTaskDao.insert(params[0]);
           Log.e ("ddd", String.valueOf(id));
            return null;
        }
    }

    private static class updateAsyncTask extends AsyncTask<WeatherEntity, Void, Void> {

        private WeatherDao mAsyncTaskDao;

        updateAsyncTask(WeatherDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(WeatherEntity... params) {
            mAsyncTaskDao.update(params[0]);

            return null;
        }
    }
}
