package com.example.gminchev.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.w3c.dom.Comment;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener{
    private List<Games> data;
  private  static String TAG = "MainActivity";
  private  boolean isComment  = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rec_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        data = GamesDatabase.getDatabase();


        GamesAdapter adapter = new GamesAdapter(data);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        //recyclerView.se
    }

    @Override
    public void onItemClick(View view, int position) {
            Log.v(TAG, "Raboti");

       // Toast.makeText(this, "Hello OnItemClick", Toast.LENGTH_SHORT).show();
        final Games game = data.get(position);
        Intent i = new Intent(this, CommentActivity.class);

        i.putExtra("game", (Serializable) game);
        i.putExtra("position", position);

        startActivity(i);
    }

    /** Called when the user taps the Send button */
   /* public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }*/


}
