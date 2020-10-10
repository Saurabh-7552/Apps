package com.example.german;

public class Word {
    private String mDefaultWord;
    private String mGermanWord;
    private int imageResource;
    private int soundResource;
    public Word(String GermanWord,String defaultWord,int imageResource,int soundResource)
    {
        this.mDefaultWord=defaultWord;
        this.mGermanWord=GermanWord;
        this.imageResource=imageResource;
        this.soundResource=soundResource;
    }
    public Word(String GermanWord,String defaultWord,int imageResource)
    {
        this.mDefaultWord=defaultWord;
        this.mGermanWord=GermanWord;
        this.imageResource=imageResource;
    }
    public Word(String GermanWord,String DefaultWord)
    {
        mDefaultWord=DefaultWord;
        mGermanWord=GermanWord;
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
    public int getSoundResource(){
        return this.soundResource;
    }

}
