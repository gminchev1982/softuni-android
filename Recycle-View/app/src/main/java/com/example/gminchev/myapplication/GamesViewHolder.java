package com.example.gminchev.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by GMinchev on 6.3.2018 г..
 */

public class GamesViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.txt_title)   TextView txtTitle;
    @BindView(R.id.txt_vote)    TextView txtVote;
    @BindView(R.id.txt_commentCount)  TextView txtCommentCount;
    @BindView(R.id.img_item)
    ImageView imgItem;
    @BindView(R.id.btn_voted)
    Button btnVoted;
    @BindView(R.id.btn_unvoted)
    Button btnUnVoted;
    private Games dataItem;
    private Integer vote;

    public GamesViewHolder(View itemView) {

        super(itemView);
        ButterKnife.bind(this, itemView);
    }


    public void setData(Games data) {
        dataItem = data;
        txtTitle.setText(data.getTitle());
        Picasso.with(itemView.getContext()).load(data.getImageUrl()).into(imgItem);
        btnVoted.setEnabled(true);
        btnUnVoted.setEnabled(false);
        vote = data.getVoteCount();
        txtVote.setText(vote.toString());
        Integer co = 0;
        txtCommentCount.setText(co.toString());


    }

    @OnClick(R.id.btn_voted)
    public void onVotedClick() {
        btnVoted.setBackgroundColor(btnVoted.getContext().getResources().getColor(R.color.colorBlue));
        btnUnVoted.setBackgroundColor(btnUnVoted.getContext().getResources().getColor(R.color.colorWhite));
        btnVoted.setEnabled(false);
        btnUnVoted.setEnabled(true);
        vote++;
        dataItem.setVoted(vote);
        txtVote.setText(vote.toString());
    }

    @OnClick(R.id.btn_unvoted)
    public void onUnVotedClick() {
        btnVoted.setBackgroundColor(btnVoted.getContext().getResources().getColor(R.color.colorWhite));
        btnUnVoted.setBackgroundColor(btnUnVoted.getContext().getResources().getColor(R.color.colorBlue));
        btnVoted.setEnabled(true);
        btnUnVoted.setEnabled(false);
        vote--;
        dataItem.setVoted(vote);
        txtVote.setText(vote.toString());

    }
}
