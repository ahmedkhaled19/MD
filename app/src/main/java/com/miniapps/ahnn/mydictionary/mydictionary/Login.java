package com.miniapps.ahnn.mydictionary.mydictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        GO();
    }

    private void GO() {
        startActivity(new Intent(this,MainActivity.class));
    }
}
