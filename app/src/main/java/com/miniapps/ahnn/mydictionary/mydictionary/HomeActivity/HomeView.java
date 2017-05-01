package com.miniapps.ahnn.mydictionary.mydictionary.HomeActivity;

import com.miniapps.ahnn.mydictionary.mydictionary.Word;

import java.util.ArrayList;

/**
 * Created by NaderNabil on 4/24/2017.
 */

public interface HomeView {

    interface modelStuff {
        void fetch_data_firebase(); //marra wa7da lamma abda2 el app then saved to local

        void fetch_data_local(

        );

        int insert_to_firebase();

        long insert_to_local();

        int delete_from_firebase();

        int delete_from_local();

        int update_in_firebase();

        int update_in_local();
    }

    /* Word delete_word(); //in local and firebase

  Word edit_word(); //in local and firebase

  Word inser_word(); //in local and firebase
*/
    void SetData(ArrayList<Word> data); //to be used by adapter

    void SpeakWord(String Word);


}