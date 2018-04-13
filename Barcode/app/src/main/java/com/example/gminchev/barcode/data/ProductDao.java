package com.example.gminchev.barcode.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface ProductDao {

    //@Query("SELECT * FROM product WHERE code like :code")
    @Query("SELECT * FROM productentity WHERE code  like :code")
    ProductEntity searchBarcode(String code);

    @Query("SELECT COUNT(*) FROM productentity WHERE 1")
    int getNumberOfRows();

    @Insert
    long insert(ProductEntity productEntity);


}
