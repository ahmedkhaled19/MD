package com.miniapps.ahnn.mydictionary.mydictionary.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.miniapps.ahnn.mydictionary.mydictionary.Word;

import java.util.ArrayList;

import static com.miniapps.ahnn.mydictionary.mydictionary.DataBase.DataBase.Word;
import static com.miniapps.ahnn.mydictionary.mydictionary.DataBase.DataBase.example;
import static com.miniapps.ahnn.mydictionary.mydictionary.DataBase.DataBase.mean;
import static com.miniapps.ahnn.mydictionary.mydictionary.DataBase.DataBase.type;

/**
 * Created by AhmedKhaled on 4/16/2017.
 */

public class DataOperation {

    private DataBase base;
    private SQLiteDatabase db;
    private int count;
    private SharedPreferences sharedPref;

    public int getCount() {
        count = sharedPref.getInt("count", 0);
        return count;
    }

    public DataOperation(Context context) {
        base = new DataBase(context);
        sharedPref = context.getSharedPreferences("count", 0);
    }

    private void open() throws SQLException {
        db = base.getWritableDatabase();
    }

    private void close() {
        base.close();
    }

    // TODO: 4/24/2017 law mawgod hayraga3 -2 , law 7asal error hayraga3 -1 , 8eer kda hayeb2a success
    public long insertData(Word word) throws SQLException {
        if (Ishere(word.getWord())) {
            return -2;
        }
        {
            open();
            ContentValues values = new ContentValues();
            values.put(Word, word.getWord());
            values.put(mean, word.getMeaning());
            values.put(example, word.getExample());
            values.put(type, word.getType());
            //Inserting Data
            Long newRowId = db.insert(
                    DataBase.TableName,
                    null,
                    values
            );
            count++;
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("count", count);
            editor.commit();
            close();
            return newRowId;
        }
    }

    public void updateData(String old, Word word) throws SQLException {
        open();
        ContentValues values = new ContentValues();
        values.put(Word, word.getWord());
        values.put(mean, word.getMeaning());
        values.put(example, word.getExample());
        values.put(type, word.getType());
        db.update(DataBase.TableName, values, "word = ?", new String[]{old});
        close();
    }

    public boolean Ishere(String English_word) {
        db = base.getReadableDatabase();
        boolean exist;
        Cursor cursor = db.query(
                DataBase.TableName,
                null,
                Word + "=?",
                new String[]{English_word},
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            exist = true;
        } else {
            exist = false;
        }
        cursor.close();
        return exist;
    }


    public ArrayList<Word> GetData() throws SQLException {
        db = base.getReadableDatabase();
        ArrayList<Word> words = new ArrayList<>();
        String[] projection = {
                Word,
                mean,
                example
        };
        Cursor cursor = db.query(
                DataBase.TableName,
                null,
                null,
                null,
                null,
                null,
                Word + " ASC");
        if (cursor.moveToFirst()) {
            count = 0;
            while (!cursor.isAfterLast()) {
                String w = cursor.getString(cursor.getColumnIndex(Word));
                String m = cursor.getString(cursor.getColumnIndex(mean));
                String e = cursor.getString(cursor.getColumnIndex(example));
                String t = cursor.getString(cursor.getColumnIndex(type));
                Word word = new Word(w, m, e, t);
                words.add(word);
                count++;
                cursor.moveToNext();
            }
        }
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("count", count);
        editor.commit();
        Log.e("Data ==", String.valueOf(count));
        close();
        cursor.close();
        return words;
    }

    public Word getnotification(int i) {
        db = base.getReadableDatabase();
        String x = String.valueOf(i);
        Cursor cursor = db.query(
                DataBase.TableName,
                null,
                DataBase.UID + "=?",
                new String[]{x},
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            String w = cursor.getString(cursor.getColumnIndex(Word));
            String m = cursor.getString(cursor.getColumnIndex(mean));
            String e = cursor.getString(cursor.getColumnIndex(example));
            String t = cursor.getString(cursor.getColumnIndex(type));
            Word word = new Word(w, m, e, t);
            cursor.close();
            return word;
        }
        return null;
    }

    public void deleteWord(Word word) throws SQLException {
        open();
        String selection = Word + "=?";
        String[] selargs = {word.getWord()};
        db.delete(DataBase.TableName, selection, selargs);
        count--;
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("count", count);
        editor.commit();
        close();
    }

}
