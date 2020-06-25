package com.example.german;

public class Word {
    private String mDefaultWord;
    private String mGermanWord;
    private int imageResource;
    public Word(String GermanWord,String defaultWord,int imageResource)
    {
        this.mDefaultWord=defaultWord;
        this.mGermanWord=GermanWord;
        this.imageResource=imageResource;
    }
    public String getdefaultWord()
    {
        return this.mDefaultWord;
    }

    public String getGermanWord()
    {
        return this.mGermanWord;
    }
    public int getImageResource()
    {
        return this.imageResource;
    }

}
