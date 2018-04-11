package com.example.gminchev.fragments.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GMinchev on 11.4.2018 г..
 */

public class GameModel {
    private String title;
    private String imageUrl;
    private Integer voteCount;
    private Integer commentCount;
    private boolean isVoted;
    private List<String> comments =new ArrayList<String>();
    public ArrayList<String> setComment;

    public GameModel(String title, String imageUrl) {
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

    public void setComment (List<String> comments){
        this.comments = comments;
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
