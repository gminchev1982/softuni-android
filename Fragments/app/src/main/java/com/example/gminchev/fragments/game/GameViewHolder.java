package com.example.gminchev.fragments.game;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.gminchev.fragments.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.OnClick;


class GameViewHolder extends RecyclerView.ViewHolder  {
    private final String TAG = "GAMEVIEWHOLDER";
    GameModel game ;
    @BindView(R.id.txt_title) TextView txtTitle;

    @BindView(R.id.txt_vote) TextView txtVote;
    @BindView(R.id.txt_commentCount)  TextView txtCommentCount;
    @BindView(R.id.img_item)     ImageView imgItem;
    @BindView(R.id.img_voted)    ImageView imgVoted;
    @BindView(R.id.img_unvoted)  ImageView imgUnVoted;
    @BindView(R.id.img_comment)  ImageView imgComment;
    @BindView(R.id.txt_comment)
    EditText txtComment;
    @BindView(R.id.btn_comment_save)
    Button btn_commentSave;
    @BindView(R.id.img_share)  ImageView imgShareComment;

    private Integer vote;
    private Integer countComment;
    private Integer co;
    private GameClickListener clickListener;
    public GameViewHolder(View itemView) {
        super(itemView);
    }

    public void setData(GameModel data, GameClickListener clickListener) {
        this.game = data;
        Log.e(TAG, game.getTitle());
        this.clickListener = clickListener;
         txtTitle.setText(game.getTitle());
   //     txtTitle.setText(game.getTitle());
        //Picasso.with(itemView.getContext()).load(game.getImageUrl()).into(imgItem);
        //imgVoted.setEnabled(true);
        //imgUnVoted.setEnabled(false);
        //vote = game.getVoteCount();
        //txtVote.setText(vote.toString());
        //co = 0;
        //txtCommentCount.setText(co.toString());
    }

    @OnClick(R.id.img_voted)
    public void onVotedClick() {
        imgVoted.setColorFilter(imgVoted.getContext().getResources().getColor(R.color.colorBlue));
        imgUnVoted.setColorFilter(imgUnVoted.getContext().getResources().getColor(R.color.colorBlack));
        imgVoted.setEnabled(false);
        imgUnVoted.setEnabled(true);
        vote++;
        game.setVoted(vote);
        txtVote.setText(vote.toString());
    }

    @OnClick(R.id.img_unvoted)
    public void onUnVotedClick() {
        imgVoted.setColorFilter(imgVoted.getContext().getResources().getColor(R.color.colorBlack));
        imgUnVoted.setColorFilter(imgUnVoted.getContext().getResources().getColor(R.color.colorBlue));
        imgVoted.setEnabled(true);
        imgUnVoted.setEnabled(false);
        vote--;
        game.setVoted(vote);
        txtVote.setText(vote.toString());

    }

    @OnClick(R.id.img_comment)
    public void onCommentClick() {
        txtComment.setVisibility(View.VISIBLE);
        btn_commentSave.setVisibility(View.VISIBLE);
    }

    @OnClick (R.id.btn_comment_save)
    public void onCommentSave (){
        game.addComment(txtComment.getText().toString());
        txtComment.setText("");
        co++;
        txtCommentCount.setText(co.toString());
    }

    @OnClick (R.id.img_share)
    public void onShareComment (){
        clickListener.onItemClick( game, 2);
    }




}
