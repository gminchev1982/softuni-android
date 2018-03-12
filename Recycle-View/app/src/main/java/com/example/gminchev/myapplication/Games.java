package com.example.gminchev.myapplication;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by GMinchev on 6.3.2018 г..
 */

public class Games implements Serializable {
    private String title;
    private String imageUrl;
    private Integer voteCount;
    private Integer commentCount;
    private boolean isVoted;
    private List<String> comments =new ArrayList<String>();

    public Games(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.voteCount =0;
        this.commentCount =0;

    }

    public String getTitle (){
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public List<String> getComments() {
        return comments;
    }

    public  Integer commentCount (){

        return comments.size();
    }

    public void setVoted(Integer voteCount) {
        this.voteCount = voteCount;
        isVoted= false;
    }
    public boolean isVoted (){
        return isVoted;
    }

    public void addComment(String s) {
        comments.add(s);

    }

}
