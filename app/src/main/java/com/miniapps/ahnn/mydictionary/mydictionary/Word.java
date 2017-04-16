package com.miniapps.ahnn.mydictionary.mydictionary;

/**
 * Created by AhmedKhaled on 4/16/2017.
 */

public class Word {
    private String word;
    private String meaning;
    private String example;

    public Word(String word, String meaning, String example) {
        this.word = word;
        this.meaning = meaning;
        this.example = example;
    }

    public String getWord() {
        return word;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getExample() {
        return example;
    }
}
