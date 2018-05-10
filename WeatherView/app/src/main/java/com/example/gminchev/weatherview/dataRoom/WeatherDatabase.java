package com.example.gminchev.weatherview.dataRoom;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {WeatherEntity.class}, version = 1)
public abstract class WeatherDatabase extends RoomDatabase {
    private static WeatherDatabase INSTANCE;
    public abstract  WeatherDao WeatherDao();


    public static WeatherDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WeatherDatabase.class) {
                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WeatherDatabase.class, "weather.db")
                            .fallbackToDestructiveMigration()
                            //.addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){

        @Override
        public void onOpen (@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
            // If you want to keep the data through app restarts,
            // comment out the following line.
            new OpenDbAsync(INSTANCE).execute();
        }
    };

    //open db and delete all rows ;)
    private static class OpenDbAsync extends AsyncTask<Void, Void, Void> {

        private final WeatherDao mDao;

        OpenDbAsync(WeatherDatabase db) {
            mDao = db.WeatherDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            mDao.deleteAll();

            //Word word = new Word("Hello");
           // mDao.insert(word);
           // word = new Word("World");
           // mDao.insert(word);
            return null;
        }
    }
}
