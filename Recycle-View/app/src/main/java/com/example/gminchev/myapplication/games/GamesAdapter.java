package com.example.gminchev.myapplication.games;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gminchev.myapplication.BaseDataModel;
import com.example.gminchev.myapplication.BaseViewHolder;
import com.example.gminchev.myapplication.MainActivity;
import com.example.gminchev.myapplication.R;
import com.example.gminchev.myapplication.promotion.Promotion;
import com.example.gminchev.myapplication.promotion.PromotionViewHolder;

import java.util.List;

/**
 * Created by GMinchev on 6.3.2018 г..
 */

public class GamesAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<BaseDataModel> data;
    private static String TAG = "GamesAdapter";
    private OnItemClickListener clickListener;
    private static final int TYPE_GAMES = 1;
    private static final int TYPE_PROMO = 2;
    public GamesAdapter(List<BaseDataModel> data) {
        this.data = data;
        //this.clickListener = clickListener;

    }

    @Override
    public int getItemViewType(int position) {
        BaseDataModel model = data.get(position);
        if (model instanceof Promotion){
            return TYPE_PROMO;
        }
        return TYPE_GAMES;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder vh = null;
        if (viewType==TYPE_GAMES){
            View  view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_games, parent, false);

            vh = new GamesViewHolder(view);
        }else {
            View  view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_promotion, parent, false);

            vh = new PromotionViewHolder(view);
        }


        return vh;
    }

    @Override
    public void onBindViewHolder(final BaseViewHolder holder, final int position) {
        BaseDataModel item = data.get(position);
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
