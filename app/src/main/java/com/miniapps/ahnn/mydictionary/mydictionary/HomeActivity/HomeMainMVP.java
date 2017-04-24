package com.miniapps.ahnn.mydictionary.mydictionary.HomeActivity;

import com.miniapps.ahnn.mydictionary.mydictionary.Word;

import java.util.ArrayList;

/**
 * Created by NaderNabil on 4/24/2017.
 */

public interface HomeMainMVP {
    interface modelStuff {
        void fetch_data_firebase(); //marra wa7da lamma abda2 el app then saved to local

        void fetch_data_local(HomeMainMVP.presenterStuff presenter);

        int insert_to_firebase();

        long insert_to_local();

        int delete_from_firebase();

        int delete_from_local();

        int update_in_firebase();

        int update_in_local();
    }

    interface presenterStuff {
        void receiving_data(ArrayList<Word> arrayList); //to interact with model to get data

        void delete_word(Word word); //in local and firebase

        void edit_word(Word word); //in local and firebase

        void inser_word(Word word); //in local and firebase

        ArrayList<Word> get_data(); //to be used by adapter

    }

    interface viewStuff {
        void play_voice();

        void detail_dialog(Word word);

        void edit_dialog(int position);

    }
}
