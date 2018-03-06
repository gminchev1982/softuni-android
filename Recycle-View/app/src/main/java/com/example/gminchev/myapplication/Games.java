package com.example.gminchev.myapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GMinchev on 6.3.2018 г..
 */

public class Games {
    private String title;
    private String imageUrl;
    private Integer voteCount;
    private boolean isVoted;
    private List<String> comments;

    public Games(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.voteCount =0;

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

    public Integer getCountComment (){
        return comments.size();
    }

    public void setVoted(Integer voteCount) {
        this.voteCount = voteCount;
        isVoted= false;
    }
    public boolean isVoted (){
        return isVoted;
    }
}
