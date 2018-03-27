package com.example.gminchev.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.gminchev.myapplication.games.Games;
import com.example.gminchev.myapplication.games.GamesAdapter;
import com.example.gminchev.myapplication.games.GamesDatabase;
import com.example.gminchev.myapplication.games.OnItemClickListener;
import com.example.gminchev.myapplication.promotion.Promotion;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {
    private List<BaseDataModel> data;
  private  static String TAG = "MainActivity";
  private  boolean isComment  = false;
    public static final int REQUEST_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "MainActivity", Toast.LENGTH_SHORT).show();
        RecyclerView recyclerView = findViewById(R.id.rec_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        data = GamesDatabase.getDatabase();
        //data = updateCommentDate(data);

        GamesAdapter adapter = new GamesAdapter(data);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
          }



    @Override
    public void onItemClick(Games game, int position) {
            Log.v(TAG, "Raboti");


        Intent i = new Intent(this, CommentActivity.class);
        //i.getStringArrayListExtra("data", "tt");
        startActivityForResult(i, REQUEST_CODE );
        ArrayList<String> ff = (ArrayList <String>) game.getComments();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        bundle.putStringArrayList("comment", ff);
        i.putExtras(bundle);

         startActivity(i);
    }

    @Override
    public void onPromotionClick(Promotion item) {
        String url = item.getUrl();
        Intent i = new Intent(Intent.ACTION_VIEW,
                Uri.parse(url));
        startActivity(i);
    }

    @Override
    public void CommentListener(ArrayList<String> comments) {

    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "request code " + requestCode, Toast.LENGTH_SHORT).show();

        if (requestCode == REQUEST_CODE) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                // do your stuff here

            }
        }
    }

}
