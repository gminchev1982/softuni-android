package com.example.gminchev.myapplication.comment;

import java.io.Serializable;

/**
 * Created by GMinchev on 13.3.2018 г..
 */

public class  Comment {
    private String txt;

    public Comment(String txt) {
        this.txt = txt;
    }

    public String getTxt() {
        return txt;
    }
}
