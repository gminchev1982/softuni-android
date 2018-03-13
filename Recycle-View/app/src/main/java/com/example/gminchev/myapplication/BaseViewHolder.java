package com.example.gminchev.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.gminchev.myapplication.games.OnItemClickListener;

/**
 * Created by GMinchev on 13.3.2018 г..
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder   {
    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract  void setData (T data, OnItemClickListener clickListener );

    //public set
}
