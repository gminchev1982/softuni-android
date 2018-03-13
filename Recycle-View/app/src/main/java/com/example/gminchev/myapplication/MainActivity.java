package com.example.gminchev.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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
    public void onItemClick(Games game, int position) {
            Log.v(TAG, "Raboti");

       // Toast.makeText(this, "Hello OnItemClick", Toast.LENGTH_SHORT).show();
        //ArrayList<String> ff = new ArrayList<>();
        //ff.add ("audi");
        //ff.add ("seat");
        //ff.add ("skoda");
        Intent i = new Intent(this, CommentActivity.class);
        //i.getStringArrayListExtra("data", "tt");

        ArrayList<String> ff = (ArrayList <String>) game.getComments();
        Bundle bundle = new Bundle();

        String str2 = "coming through bundle";

        bundle.putString("string2", str2);

        bundle.putStringArrayList("comment", ff);

        i.putExtras(bundle);

        //i.putStringArrayListExtra("comment", (ArrayList <String>) game.getComments());

        startActivity(i);
    }

    @Override
    public void onPromotionClick(Promotion item) {
        String url = item.getUrl();
        Intent i = new Intent(Intent.ACTION_VIEW,
                Uri.parse(url));
        startActivity(i);
    }


}
