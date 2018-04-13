package com.example.gminchev.barcode.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {ProductEntity.class}, version = 1)
public abstract  class AppDatabase extends RoomDatabase {
    public abstract  ProductDao ProductDao();
}
