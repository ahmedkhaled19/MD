package com.miniapps.ahnn.mydictionary.mydictionary.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by AhmedKhaled on 4/16/2017.
 */

public class DataBase extends SQLiteOpenHelper {

    private static final String DBname = "dictionary.db";
    static final String TableName = "dictionary";
    static final String UID = "_id"; //first column
    static final String Word = "word"; //second column
    static final String mean = "mean"; //third column
    static final String example = "example"; //fourth column
    static final String type = "type"; //fifth column
    private static final int DATABASE_Version = 1;

    public DataBase(Context context) {
        super(context, DBname, null, DATABASE_Version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TableName + " ("
                + UID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Word + " TEXT,"
                + mean + " TEXT,"
                + example + " TEXT,"
                + type + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS dictionary");
        onCreate(db);
    }

}
