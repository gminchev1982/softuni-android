package com.example.gminchev.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

/**
 * Created by minchev on 12.3.2018 г..
 */

public class CommentActivity extends AppCompatActivity {
    private  boolean isComment  = true;
    private Serializable data;
    private  int position;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rec_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent i = getIntent();

        data = i.getSerializableExtra("game");
        position = i.getIntExtra("position",0);
        //Toast.makeText(this, "Position" + position, Toast.LENGTH_SHORT).show();

        //GamesAdapter adapter = new GamesAdapter((List<String>) data);
        //adapter.setClickListener(this);
    }
}
