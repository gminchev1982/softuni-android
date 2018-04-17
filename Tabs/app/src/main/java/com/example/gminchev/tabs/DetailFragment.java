package com.example.gminchev.tabs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DetailFragment extends Fragment {
    private TimeLineFragment.OnFragmentDataReceived listener;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        FragmentActivity activityCompat = getActivity();
        if(activityCompat instanceof TimeLineFragment.OnFragmentDataReceived) {
            listener = (TimeLineFragment.OnFragmentDataReceived) activityCompat;
        } else {
            throw new RuntimeException("You must implement my interface");
        }

        //some of our code
        listener.onDataReceived("yess detail");
        Log.e ("Detail", "onAttach");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }




}
