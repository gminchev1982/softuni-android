package com.example.gminchev.myapplication.comment;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by GMinchev on 13.3.2018 г..
 */

public class  Comment {
    private String mComment;
    //private ArrayList<String> mComments;

    public Comment(String mComment) {

        this.mComment = mComment;
    }

    public String getmComment() {
        return mComment;
    }
}
