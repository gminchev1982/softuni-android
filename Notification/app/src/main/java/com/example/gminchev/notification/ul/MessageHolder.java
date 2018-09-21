package com.example.gminchev.notification.ul;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.gminchev.notification.Model.Message;
import com.example.gminchev.notification.databinding.CardMessageBinding;
import com.example.gminchev.notification.firebase.OnDataListener;

public class MessageHolder extends RecyclerView.ViewHolder {
    CardMessageBinding binding;
    public MessageHolder(CardMessageBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Message current, OnDataListener mDataListener) {
        binding.txtMessage.setText(current.getText());
        binding.cardMessage.setOnClickListener((v)->mDataListener.onEditMessage(current));
       // binding.cardMessage.setOnClickListener((v)-> Log.e("Tag CLICK", "Click"));
    }
}
