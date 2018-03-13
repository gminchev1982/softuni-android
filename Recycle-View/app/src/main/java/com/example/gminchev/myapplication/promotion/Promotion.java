package com.example.gminchev.myapplication.promotion;

import com.example.gminchev.myapplication.BaseDataModel;

/**
 * Created by GMinchev on 13.3.2018 г..
 */

public class Promotion extends BaseDataModel {
    private String imageUrl;
    private String url;

    public Promotion (String imageUrl, String url){
        this.imageUrl = imageUrl;
        this.url = url;

    }

    public String getImageUrl() {
        return imageUrl;
    }
    public String getUrl() {
        return url;
    }
}