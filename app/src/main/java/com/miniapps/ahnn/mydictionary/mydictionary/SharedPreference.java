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
    private static final String IS_NOTIFC = "ISNOTIFC";
    private static final String TIME = "TIME";
    private static final String TIME_ChHANGE = "TIME_CHANGE";
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

    public void SetTime(int time) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putInt(TIME, time);
        editor.apply();
    }

    public void SetTimeChange(boolean change) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putBoolean(TIME_ChHANGE, change);
        editor.apply();
    }

    public void SetNotifc(boolean flag) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putBoolean(IS_NOTIFC, flag);
        editor.apply();
    }

    public boolean isLoggedIn() {
        return getSharedPreferences().getBoolean(IS_LOGGED_IN, false);
    }

    public String UserKey() {
        return getSharedPreferences().getString(User_ID, null);
    }

    public boolean IsNotifc() {
        return getSharedPreferences().getBoolean(IS_NOTIFC, false);
    }

    public int Time() {
        return getSharedPreferences().getInt(TIME, 0);
    }

    public boolean TimeChange() {
        return getSharedPreferences().getBoolean(TIME_ChHANGE, false);
    }


}
