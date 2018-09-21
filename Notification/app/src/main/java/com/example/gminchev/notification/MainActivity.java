package com.example.gminchev.notification;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.TokenWatcher;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;

import com.example.gminchev.notification.Model.Message;
import com.example.gminchev.notification.databinding.ActivityMainBinding;
import com.example.gminchev.notification.firebase.OnDataListener;
import com.example.gminchev.notification.ul.MessageAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements OnDataListener  {
    private static FirebaseDatabase mDatabase;
    private static DatabaseReference ref;
    private static boolean mFamily = false;
    private static boolean mVolunteer = false;
    FirebaseAuth mAuth;
    Context mContext;
    ActivityMainBinding binding;
   // List<Message> listData;
    LiveData<DataSnapshot> liveData;
    private String TAG = "MAINACTIVITY";
    private MessageAdapter adapter;
    List<Message> listData = new ArrayList<>();
    MessageViewModel viewModel;
    private OnDataListener mDataListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        Toast.makeText(this, mAuth.getUid(), Toast.LENGTH_SHORT).show();


        String email = "georgi.minchev@gmail.com";
        String password = "malcho";
        mContext = this;
       initRefAndDatabase();
        /*mAuth.signInWithEmailAndPassword(email, password)

                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Auth is OK!", Toast.LENGTH_SHORT).show();
                            // pushInDatabase();
                            initRefAndDatabase();

                        } else {
                            Toast.makeText(MainActivity.this, "Auth is FAILED!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
*/

    }

    private void initRefAndDatabase() {
        viewModel = ViewModelProviders.of(this).get(MessageViewModel.class);
        binding.recView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MessageAdapter();
        liveData = viewModel.getDataSnapshotLiveData();
        liveData.observe(this, (dataSnapshot) -> transformData(dataSnapshot));
        adapter.setListener(this);




    }

    public List<Message> transformData(DataSnapshot dataSnapshot) {
        listData.clear();
        for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
            Message message = postSnapshot.getValue(Message.class);
            message.setKeyChild(postSnapshot.getKey());
            listData.add(message);
        }


        adapter.setData(listData);
        binding.recView.setAdapter(adapter);

       return listData;//updateChild ();
    }

    private void updateChild() {
        Message message = listData.get(0);

    }

    @Override
    public void onEditMessage(Message item) {

        item.setText("Копърка с  магданоз");
        Toast.makeText(mContext, "Click is ok!", Toast.LENGTH_SHORT).show();
        viewModel.update(item);
    }


}