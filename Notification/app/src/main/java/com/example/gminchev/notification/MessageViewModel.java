package com.example.gminchev.notification;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.gminchev.notification.Model.Message;
import com.example.gminchev.notification.firebase.FirebaseQueryLiveData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class MessageViewModel extends AndroidViewModel {

    private List<Message> mADataSnapshot;
    private static final DatabaseReference MESSAGE_REF =
            FirebaseDatabase.getInstance().getReference("messages");

    private FirebaseQueryLiveData mLiveData = new FirebaseQueryLiveData(MESSAGE_REF);

    public MessageViewModel(@NonNull Application application) {
        super(application);

    }

    public LiveData<DataSnapshot> getDataSnapshotLiveData() {

        return mLiveData;
    }

    public void update(Message message) {
        Message messageUpdate = new Message(message.getText());
        MESSAGE_REF.child(message.getKeyChild()).setValue(messageUpdate);


    }
}
