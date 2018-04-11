package com.example.gminchev.fragments.game;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gminchev.fragments.R;

import java.util.Arrays;
import java.util.List;


public class GameListFragment extends Fragment  {
    private final String TAG = "GAMELISTFRAGMENT";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rec_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        List <GameModel> data = Arrays.asList(
                new GameModel("butterfield", "https://static.gamespot.com/uploads/square_medium/1197/11970954/2369156-e3_mp_02.jpg"),
                new GameModel("Total War : Rome ||", "https://www.instant-gaming.com/images/products/200/screenshot/200-3.jpg"),
                new GameModel("Phoenix Point", "https://scontent.fsof3-1.fna.fbcdn.net/v/t31.0-8/27797701_565998913780353_8962408062466919539_o.jpg?oh=0f0d7a502e6b562df4527ffd08ea91be&oe=5B0AA6FA"),
                new GameModel("Call of Duty", "https://static.gamespot.com/uploads/screen_petite/1576/15769789/3248384-callofduty_wwii_screen1.jpg")
        );


        //data = updateCommentDate(data);

        GameAdapter adapter = new GameAdapter(data);
      //  adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        Log.e(TAG, "OnCreateView");
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }



    public interface OnFragmentDataReceived {
        void onDataReceived(String text);
    }


}
