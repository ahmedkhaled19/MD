package com.miniapps.ahnn.mydictionary.mydictionary;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by AhmedKhaled on 4/17/2017.
 */

public class SharedPreference extends Application {

    private static final String SHARED_PREF_NAME = "DATA";
    private static final String IS_LOGGED_IN = "LOGIN";
    private static SharedPreference mInstance;
    private SharedPreferences sharedPreferences;
    private String User_ID = "ID";

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

    }

    public static synchronized SharedPreference getInstance() {
        return mInstance;
    }

    public SharedPreferences getSharedPreferences() {
        if (sharedPreferences == null) {
            sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        }
        return sharedPreferences;
    }

    public void logout() {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.clear();
        editor.apply();
    }

    public void Login(String id) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(User_ID, id);
        editor.apply();
    }

    public boolean isLoggedIn() {
        return getSharedPreferences().getBoolean(IS_LOGGED_IN, false);
    }

    public String UserKey() {
        return getSharedPreferences().getString(User_ID, null);
    }

}
