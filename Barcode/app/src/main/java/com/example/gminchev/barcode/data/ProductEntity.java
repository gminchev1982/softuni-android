package com.example.gminchev.barcode.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class ProductEntity {

    @PrimaryKey(autoGenerate = true)
    private int _id;

    private String code;

    private int status;

   /* @ColumnInfo(name="product_name")
    private String product_name;

    @ColumnInfo(name="ingredient")
    private String ingredient;
*/

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
