package com.example.gminchev.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gminchev.myapplication.comment.Comment;
import com.example.gminchev.myapplication.comment.CommentAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by minchev on 12.3.2018 г..
 */

public class CommentActivity extends AppCompatActivity {
    private boolean isComment = true;
    private ArrayList<String> comment = new ArrayList<>();

    private int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_comment);
        comment.add("first elelemt");
        comment.add("second elelemt");
        comment.add("third elelemt");
        comment.add("forth elelemt");

        Bundle b = getIntent().getExtras();

        comment = b.getStringArrayList("comment");


        RecyclerView recyclerView = findViewById(R.id.rec_comment);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CommentAdapter adapter = new CommentAdapter(comment);
        recyclerView.setAdapter(adapter);
        ///adapter.setClickListener(this);
    }
}
