package com.example.gminchev.notification;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Comment;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    private static FirebaseDatabase mDatabase;
    private static DatabaseReference ref;
    private String TAG = "ddss";
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        String email = "georgi.minchev@gmail.com";
        String password = "malcho";
        mContext = this;
        mAuth.signInWithEmailAndPassword(email, password)

                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Auth is OK!", Toast.LENGTH_SHORT).show();
                           // pushInDatabase();
                            initRefAndDatabase ();

                        } else {
                            Toast.makeText(MainActivity.this, "Auth is FAILED!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });



    }

    private void initRefAndDatabase (){
  /*      if (ref==null) {
            ref = mDatabase.getReference("messages");
           // ref.addChildEventListener(childEventListener);
        }

        if (mDatabase == null) {
            mDatabase = FirebaseDatabase.getInstance();
        }
*/

        MessageViewModel viewModel = ViewModelProviders.of(this).get(MessageViewModel.class);

        LiveData<DataSnapshot> liveData = viewModel.getDataSnapshotLiveData();

        liveData.observe(this, new Observer<DataSnapshot>() {
            @Override
            public void onChanged(@Nullable DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    // update the UI here with values in the snapshot
                    //String ticker = dataSnapshot.child("ticker").getValue(String.class);
                    //tvTicker.setText(ticker);
                    //Float price = dataSnapshot.child("price").getValue(Float.class);
                    //tvPrice.setText(String.format(Locale.getDefault(), "%.2f", price));
                    Toast.makeText(mContext, "jhiujhij", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void pushInDatabase() {

        String user = FirebaseAuth.getInstance().getCurrentUser().getEmail();

        Message message = new Message("Али баба и 40те разбойници", user);
        ref.push().setValue(message);
    }
    private void writeNewMessage(String name, String email) {

        String user = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        Message message = new Message("Али баба и 40те разбойници", user);
        ref.push().setValue(message).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                // Write was successful!
                // ...
                Toast.makeText(MainActivity.this, "Insert is done!", Toast.LENGTH_SHORT).show();
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Write failed
                         Toast.makeText(MainActivity.this, "Errrro!", Toast.LENGTH_SHORT).show();
                        // ...
                    }
                });

    }







}
