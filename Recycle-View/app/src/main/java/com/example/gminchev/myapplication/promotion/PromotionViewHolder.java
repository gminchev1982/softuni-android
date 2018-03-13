package com.example.gminchev.myapplication.promotion;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.gminchev.myapplication.BaseViewHolder;
import com.example.gminchev.myapplication.R;
import com.example.gminchev.myapplication.games.OnItemClickListener;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by GMinchev on 13.3.2018 г..
 */

public class PromotionViewHolder extends BaseViewHolder<Promotion> {

    @BindView(R.id.img_promo)     ImageView imgPromo;
    @BindView(R.id.btn_promo)     Button btnPromo;
    private OnItemClickListener clickListener;
    //@BindView(R.id.img_share)  ImageView imgShareComment;

    private Promotion dataItem;

    public PromotionViewHolder(View itemView) {

        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(Promotion data, OnItemClickListener clickListener) {
        dataItem = data;
        this.clickListener = clickListener;
        Picasso.with(itemView.getContext()).load(data.getImageUrl()).into(imgPromo);


    }


    @OnClick(R.id.btn_promo)
    public void onPromoOpen (){
        clickListener.onPromotionClick(dataItem);
    }
}