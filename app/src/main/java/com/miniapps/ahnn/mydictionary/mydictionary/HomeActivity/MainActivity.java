package com.miniapps.ahnn.mydictionary.mydictionary.HomeActivity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.miniapps.ahnn.mydictionary.mydictionary.R;
import com.miniapps.ahnn.mydictionary.mydictionary.RecyclerViewAdapter;
import com.miniapps.ahnn.mydictionary.mydictionary.Word;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements OnInitListener {

    //TTS object
    private TextToSpeech myTTS;
    //status check code
    private int MY_DATA_CHECK_CODE = 0;

    ArrayList<Word> list = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Word word = new Word("ahmed", "نادر", "ajhgkwWJHDLHJDBSLWAHBBDLUJHsbdkhcjbSKGDCVLjhbckjBDDCKHJBsdldjchvSLDJV");
        Word word2 = new Word("ahmed", "نادر", "ajhgkwWJHDLHJDBSLWAHBBDLUJHsbdkhcjbSKGDCVLjhbckjBDDCKHJBsdldjchvSLDJV");
        Word word3 = new Word("ahmed", "نادر", "ajhgkwWJHDLHJDBSLWAHBBDLUJHsbdkhcjbSKGDCVLjhbckjBDDCKHJBsdldjchvSLDJV");
        Word word4 = new Word("khaled", "نادر", "ajhgkwWJHDLHJDBSLWAHBBDLUJHsbdkhcjbSKGDCVLjhbckjBDDCKHJBsdldjchvSLDJV");
        list.add(word);
        list.add(word2);
        list.add(word3);
        list.add(word4);
        recyclerView=(RecyclerView)findViewById(R.id.word_list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter=new RecyclerViewAdapter(this,list);
        recyclerView.setAdapter(adapter);
        //check for TTS data
        Intent checkTTSIntent = new Intent();
        checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);

    }

//    @Override
//    public void onClick(View view) {
//        EditText enteredText = (EditText) findViewById(R.id.enter);
//        String word = enteredText.getText().toString().trim();
//        speakWords(word);
//    }


    private void speakWords(String speech) {
        //speak straight away
        myTTS.speak(speech, TextToSpeech.QUEUE_FLUSH, null);
    }

    //act on result of TTS data check
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == MY_DATA_CHECK_CODE) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                //the user has the necessary data - create the TTS
                myTTS = new TextToSpeech(this, this);
            } else {
                //no data - install it now
                Intent installTTSIntent = new Intent();
                installTTSIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(installTTSIntent);
            }
        }
    }

    //setup TTS
    public void onInit(int initStatus) {
        //check for successful instantiation
        if (initStatus == TextToSpeech.SUCCESS) {
            if (myTTS.isLanguageAvailable(Locale.US) == TextToSpeech.LANG_AVAILABLE)
                myTTS.setLanguage(Locale.US);
        } else if (initStatus == TextToSpeech.ERROR) {
            Toast.makeText(this, "Sorry! Text To Speech failed... ", Toast.LENGTH_LONG).show();
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finishAffinity();
        System.exit(0);
        super.onBackPressed();
    }
}