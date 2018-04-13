package com.example.gminchev.barcode;

import com.example.gminchev.barcode.data.ProductEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by GMinchev on 12.4.2018 г..
 */

public interface ProductService {

        public static final String URL = "https://world.openfoodfacts.org/";

    @GET("api/v0/product/{barcode}.json")
    Call<ProductEntity> getProductData(@Path("barcode") String barcode);

}
