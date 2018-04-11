package com.example.gminchev.fragments.game;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gminchev.fragments.R;

import java.util.List;

public class GameAdapter extends RecyclerView.Adapter <GameViewHolder> {
    private List <GameModel> data;
    private final String TAG = "GAMEADAPTER";
    private GameClickListener clickListener;

    public GameAdapter(List <GameModel> data) {

        this.data = data;
        Log.e(TAG, String.valueOf(data.size()));
    }

    @Override
    public GameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        GameViewHolder vh = null;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_game, parent, false);

        vh = new GameViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(GameViewHolder holder, int position) {
        GameModel item = data.get(position);
        holder.setData(item, clickListener);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setClickListener(GameClickListener clickListener) {
        this.clickListener = clickListener;
    }
}
