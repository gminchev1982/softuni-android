package com.example.gminchev.notification.ul;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.gminchev.notification.MainActivity;
import com.example.gminchev.notification.Model.Message;
import com.example.gminchev.notification.R;
import com.example.gminchev.notification.databinding.CardMessageBinding;
import com.example.gminchev.notification.firebase.OnDataListener;
import com.google.firebase.database.DataSnapshot;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageHolder> {
    private String TAG = "MessageAdapter";
    private List<Message> data;
    private OnDataListener mDataListener;

    public MessageAdapter() {

       Log.e(TAG, "MessageAdapter");
        //this.clickListener = clickListener;

    }

    @NonNull
    @Override
    public MessageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         CardMessageBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.card_message, parent, false);

        return new MessageHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageHolder holder, int position) {
               Message current = data.get(position);
               holder.bind(current , this.mDataListener);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<Message> data) {
        this.data = data;
        Log.e (TAG, "SetData");
        notifyDataSetChanged();
    }

    public void setListener(MainActivity mDataListener) {
        this.mDataListener = mDataListener;
        Log.e(TAG, "setListner" + this.mDataListener);

    }
}
