package com.example.gminchev.myapplication.games;

import com.example.gminchev.myapplication.promotion.Promotion;

import java.util.ArrayList;

/**
 * Created by minchev on 11.3.2018 г..
 */

public interface OnItemClickListener {
    void onItemClick(Games item, int position);
    void onPromotionClick(Promotion item);
    void CommentListener (ArrayList<String> comments);
}

