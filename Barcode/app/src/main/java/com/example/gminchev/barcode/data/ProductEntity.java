package com.example.gminchev.barcode.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class ProductEntity {
    @NonNull
    @PrimaryKey
    private String codeId;

    @ColumnInfo(name="product_name")
    private String product_name;

    @ColumnInfo(name="ingredient")
    private String ingredient;



    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String code) {
        this.codeId = code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
}
