package com.miniapps.ahnn.mydictionary.mydictionary.HomeActivity;

import android.content.Context;

import com.miniapps.ahnn.mydictionary.mydictionary.DataBase.DataOperation;
import com.miniapps.ahnn.mydictionary.mydictionary.Word;

import java.util.ArrayList;

/**
 * Created by NaderNabil on 4/24/2017.
 */

public class HomeModel {


    protected ArrayList<Word> GetDATA(Context context) {
        DataOperation operation = new DataOperation(context);
        return operation.GetData();
    }

    public void Delete(Context context, Word word) {
        DataOperation operation = new DataOperation(context);
        operation.deleteWord(word);
    }

    public void Update(Context context, Word word) {
        DataOperation operation = new DataOperation(context);
        operation.updateData(word.getWord(),word);
    }
}
