package com.miniapps.ahnn.mydictionary.mydictionary;

/**
 * Created by AhmedKhaled on 4/16/2017.
 */

public class Word {
    private String word;
    private String meaning;
    private String example;
    private String Type;

    public Word(String word, String meaning, String example, String type) {
        this.word = word;
        this.meaning = meaning;
        this.example = example;
        this.Type = type;
    }

    // for firebase :by nader
    public Word() {
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

    public String getType() {
        return Type;
    }
}
