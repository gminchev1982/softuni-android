package com.example.gminchev.myapplication.comment;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gminchev.myapplication.CommentActivity;
import com.example.gminchev.myapplication.R;
import com.example.gminchev.myapplication.games.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GMinchev on 13.3.2018 г..
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentViewHolder> {
private ArrayList<String> comment;

    public CommentAdapter(ArrayList<String> comment) {

        this.comment = comment;

    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_comment, parent, false);


        CommentViewHolder vh = new CommentViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        String item =comment.get(position);

        holder.setData(item);
    }

    @Override
    public int getItemCount() {
        return comment.size();
    }


}
