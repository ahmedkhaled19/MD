package com.miniapps.ahnn.mydictionary.mydictionary.SignUp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by AhmedKhaled on 4/17/2017.
 */

public class SignUpModel {

    private String TAG = "ERROR";
    private Activity context;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private DatabaseReference root = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference users = root.child("Users");


    public String CreateUser(Activity activity, final String email, String password, final String name) {
        context = activity;
        final String[] id = {null};
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(context, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            id[0] = mAuth.getCurrentUser().getUid();
                            createUserInDb(email, name, id[0]);

                        }
                    }
                });
        return id[0];
    }

    private void createUserInDb(String email, String name, String user_id) {
        users.child(user_id).setValue(email);
        users.child(user_id).setValue(name);
    }


}
