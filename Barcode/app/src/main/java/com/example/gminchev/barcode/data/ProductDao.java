package com.example.gminchev.barcode.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.gminchev.barcode.Product;

@Dao
public interface ProductDao {

    //@Query("SELECT * FROM product WHERE code like :code")
    @Query("SELECT * FROM product WHERE codeId  like :code")
    ProductEntity searchBarcode(String code);

    @Insert
    void insert(ProductEntity productEntity);

}
