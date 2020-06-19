package com.example.german;

public class Word {
    private String mDefaultWord;
    private String mGermanWord;
    public Word(String GermanWord,String defaultWord)
    {
        this.mDefaultWord=defaultWord;
        this.mGermanWord=GermanWord;
    }
    public String getdefaultWord()
    {
        return this.mDefaultWord;
    }

    public String getGermanWord()
    {
        return this.mGermanWord;
    }

}
