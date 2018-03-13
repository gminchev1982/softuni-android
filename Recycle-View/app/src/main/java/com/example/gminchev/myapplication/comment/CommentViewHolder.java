package com.example.gminchev.myapplication.comment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gminchev.myapplication.R;

import org.w3c.dom.*;
import org.w3c.dom.Comment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by GMinchev on 13.3.2018 г..
 */

class CommentViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.txt_comment_list)  TextView txtCommentList;

    public CommentViewHolder(View itemView) {

        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setData(String  data) {
        txtCommentList.setText(data);
    }
}
