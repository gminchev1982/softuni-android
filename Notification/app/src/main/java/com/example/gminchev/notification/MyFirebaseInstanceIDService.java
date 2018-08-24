package com.example.gminchev.notification;

import android.util.Log;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import java.util.HashMap;
import java.util.Map;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {


    private static final String TAG = "TOKEN";



    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d (TAG,"TOKEN: " + refreshedToken);
       // Toast.makeText(this, "Testo", Toast.LENGTH_SHORT).show();
        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationToServer(refreshedToken);

    }

    private void sendRegistrationToServer(String refreshedToken) {
        Log.d (TAG,"TOKEN: " + refreshedToken);

        String uid = refreshedToken;
        Map<String, Object> additionalClaims = new HashMap<String, Object>();
        additionalClaims.put("premiumAccount", true);

       // String customToken = FirebaseAuth.getInstance().createCustomToken(uid, additionalClaims);



    }

}
