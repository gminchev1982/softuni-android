package com.example.gminchev.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gminchev.myapplication.comment.Comment;
import com.example.gminchev.myapplication.comment.CommentAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by minchev on 12.3.2018 г..
 */

public class CommentActivity extends AppCompatActivity {
    private boolean isComment = true;
    private ArrayList<String> comment = new ArrayList<>();
    @BindView(R.id.txt_comment_list_view)
    TextView txtComment;
    @BindView(R.id.btn_comment_save_view)
    Button btnSave;

    private int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_comment);
        comment.add("first elelemt");
        comment.add("second elelemt");
        comment.add("third elelemt");
        comment.add("forth elelemt");
        ButterKnife.bind(this);

        Bundle b = getIntent().getExtras();

        this.comment = b.getStringArrayList("comment");


        RecyclerView recyclerView = findViewById(R.id.rec_comment);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CommentAdapter adapter = new CommentAdapter(comment);
        recyclerView.setAdapter(adapter);
        ///adapter.setClickListener(this);
    }

    @OnClick(R.id.btn_comment_save_view)
    public void onCommentSaveClick() {
        //Toast.makeText(this, "Comment click!", Toast.LENGTH_SHORT).show();
        if (txtComment.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "Comment is empty!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, txtComment.getText().toString(), Toast.LENGTH_SHORT).show();
            comment.add(txtComment.getText().toString());

        }
    }

    @Override
    public void onBackPressed() {

        Toast.makeText(this, "RAboti", Toast.LENGTH_SHORT).show();
        String data = txtComment.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("MyData", data);
        setResult(RESULT_OK, intent);
        finish();
        super.onBackPressed();
    }
}

