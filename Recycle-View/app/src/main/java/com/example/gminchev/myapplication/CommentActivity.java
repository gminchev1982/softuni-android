package com.example.gminchev.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gminchev.myapplication.R;
import com.example.gminchev.myapplication.comment.CommentAdapter;

import java.util.ArrayList;

/**
 * Created by minchev on 12.3.2018 г..
 */

public class CommentActivity extends AppCompatActivity {
    private boolean isComment = true;
    private ArrayList <String> comment = new ArrayList();

    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_comment);
        comment.add("first");
        comment.add("second");

        RecyclerView recyclerView = findViewById(R.id.rec_comment);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CommentAdapter adapter = new CommentAdapter(comment);
        recyclerView.setAdapter(adapter);
        ///adapter.setClickListener(this);
    }
}
