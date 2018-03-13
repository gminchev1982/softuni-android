package com.example.gminchev.myapplication.games;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gminchev.myapplication.BaseViewHolder;
import com.example.gminchev.myapplication.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by GMinchev on 6.3.2018 г..
 */

public class GamesViewHolder extends BaseViewHolder<Games> {
    @BindView(R.id.txt_title)   TextView txtTitle;

    @BindView(R.id.txt_vote)    TextView txtVote;
    @BindView(R.id.txt_commentCount)  TextView txtCommentCount;
    @BindView(R.id.img_item)     ImageView imgItem;
    @BindView(R.id.img_voted)    ImageView imgVoted;
    @BindView(R.id.img_unvoted)  ImageView imgUnVoted;
    @BindView(R.id.img_comment)  ImageView imgComment;
    @BindView(R.id.txt_comment)  EditText txtComment;
    @BindView(R.id.btn_comment_save)  Button btn_commentSave;
    @BindView(R.id.img_share)  ImageView imgShareComment;

    private Games dataItem;
    private Integer vote;
    private Integer countComment;
    private Integer co;
    private OnItemClickListener clickListener;

    public GamesViewHolder(View itemView) {

        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
      public void setData(Games data, OnItemClickListener clickListener) {
        dataItem = data;
        this.clickListener = clickListener;
        txtTitle.setText(data.getTitle());
        Picasso.with(itemView.getContext()).load(data.getImageUrl()).into(imgItem);
        imgVoted.setEnabled(true);
        imgUnVoted.setEnabled(false);
        vote = data.getVoteCount();
        txtVote.setText(vote.toString());
           co = 0;
        txtCommentCount.setText(co.toString());

    }

    @OnClick(R.id.img_voted)
    public void onVotedClick() {
        imgVoted.setColorFilter(imgVoted.getContext().getResources().getColor(R.color.colorBlue));
        imgUnVoted.setColorFilter(imgUnVoted.getContext().getResources().getColor(R.color.colorBlack));
        imgVoted.setEnabled(false);
        imgUnVoted.setEnabled(true);
        vote++;
        dataItem.setVoted(vote);
        txtVote.setText(vote.toString());
    }

    @OnClick(R.id.img_unvoted)
    public void onUnVotedClick() {
        imgVoted.setColorFilter(imgVoted.getContext().getResources().getColor(R.color.colorBlack));
        imgUnVoted.setColorFilter(imgUnVoted.getContext().getResources().getColor(R.color.colorBlue));
        imgVoted.setEnabled(true);
        imgUnVoted.setEnabled(false);
        vote--;
        dataItem.setVoted(vote);
        txtVote.setText(vote.toString());

    }

    @OnClick(R.id.img_comment)
    public void onCommentClick() {
        txtComment.setVisibility(View.VISIBLE);
        btn_commentSave.setVisibility(View.VISIBLE);
    }

    @OnClick (R.id.btn_comment_save)
    public void onCommentSave (){
        dataItem.addComment(txtComment.getText().toString());
        txtComment.setText("");
        co++;
        txtCommentCount.setText(co.toString());
    }

    @OnClick (R.id.img_share)
    public void onShareComment (){
        clickListener.onItemClick( dataItem, 2);
    }
}
