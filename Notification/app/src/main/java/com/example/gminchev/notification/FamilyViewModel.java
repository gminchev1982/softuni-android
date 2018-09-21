package com.example.gminchev.notification;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.example.gminchev.notification.Model.Family;
import com.example.gminchev.notification.firebase.FirebaseQueryLiveData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FamilyViewModel extends ViewModel {
    private static final DatabaseReference FAMILY_REF =
            FirebaseDatabase.getInstance().getReference("898543555");

    private FirebaseQueryLiveData mLiveData = new FirebaseQueryLiveData(FAMILY_REF);
    //  private LiveData<List<Family>> mFamilyLiveData;
    //  private List<Family> mList = new ArrayList<>();


  /*  @NonNull
   public DataSnapshot getDataSnapshotLiveData() {
        return mLiveData;
    }*/


    //@NonNull
 /*  public DataSnapshot getDataSnapshotLiveData() {
        return mFamilyLiveData;
    }


    private class Deserializer implements Function<DataSnapshot, List<Family>> {

        @Override
        public List<Family> apply(DataSnapshot dataSnapshot) {
            Log.e ("Model d", "dd");
            mList.clear();
            for(DataSnapshot snap : dataSnapshot.getChildren()){
                Family family = snap.getValue(Family.class);
                family.toString();
                mList.add(family);
            }
            return mList;
        }
    }*/


}
