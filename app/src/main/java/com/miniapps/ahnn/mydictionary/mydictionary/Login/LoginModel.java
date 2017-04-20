package com.miniapps.ahnn.mydictionary.mydictionary.Login;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.content.ContentValues.TAG;

/**
 * Created by AhmedKhaled on 4/17/2017.
 */

public class LoginModel {

    private String TAG = "ERROR";
    private Activity context;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthlistener;

    protected void OnCreate(Activity context) {
        this.context = context;
        mAuth = FirebaseAuth.getInstance();
        mAuthlistener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    Log.d(TAG, "onAuthStateChanged:signed_out");

                }
            }
        };
    }

    protected void OnStart() {
        mAuth.addAuthStateListener(mAuthlistener);
    }

    protected void OnStop() {
        if (mAuthlistener != null) {
            mAuth.removeAuthStateListener(mAuthlistener);
        }
    }

    protected String SignIn(String email, String password) {
        final String[] id = null;
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        id[0] = user.getUid();
                    }
                });
        return id[0];
    }
}
