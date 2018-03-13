package com.example.gminchev.myapplication.games;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gminchev.myapplication.MainActivity;
import com.example.gminchev.myapplication.R;

import java.util.List;

/**
 * Created by GMinchev on 6.3.2018 г..
 */

public class GamesAdapter extends RecyclerView.Adapter<GamesViewHolder> {

    private List<Games> data;
    private static String TAG = "GamesAdapter";
    private OnItemClickListener clickListener;

    public GamesAdapter(List<Games> data) {
        this.data = data;
        //this.clickListener = clickListener;

    }

    @Override
    public GamesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_games, parent, false);


        GamesViewHolder vh = new GamesViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(final GamesViewHolder holder, final int position) {
        Games item = data.get(position);
        holder.setData(item, clickListener);


            /*holder.imgShareComment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.v(TAG, "Adapterd SetClickListenrer");
                    if (clickListener != null) {
                        clickListener.onItemClick(v, position);
                    } else {
                        Toast.makeText(holder.imgShareComment.getContext(), "Hello Error Onclick", Toast.LENGTH_SHORT).show();
                    }
                }
            });*/


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setClickListener(MainActivity clickListener) {
        this.clickListener = clickListener;
        Log.v(TAG, "Adapterd SetClickListenrer");

    }
}
