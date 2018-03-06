package com.example.gminchev.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by GMinchev on 6.3.2018 г..
 */

class GamesAdapter extends RecyclerView.Adapter<GamesViewHolder> {
    private List<Games> data;

    public GamesAdapter(List<Games> data) {
        this.data = data;
    }

    @Override
    public GamesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_games, parent, false);
            GamesViewHolder vh = new GamesViewHolder(view);
            return vh;



    }

    @Override
    public void onBindViewHolder(GamesViewHolder holder, int position) {
        Games  item = data.get(position);
        holder.setData(item);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
