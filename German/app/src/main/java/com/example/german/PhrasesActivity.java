package com.example.german;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_list);
        List<Word> myPhrases =createList();
        WordAdapter mWordAdapter =new WordAdapter(this,myPhrases);
        ListView phraseView =(ListView)findViewById(R.id.rootView);
        phraseView.setAdapter(mWordAdapter);
    }
    private List<Word> createList()
    {
        List<Word> mPhrases=new ArrayList<>();
      mPhrases.add(new Word("Guten Morgen","Good Morning",0));
      mPhrases.add(new Word("Guten Tag","Good Day",0));
      mPhrases.add(new Word("Guten Abend","Good Evening",0));
      mPhrases.add(new Word("Guten Nacht","Good Night",0));
      mPhrases.add(new Word("Bitte","Pardon,Please,Welcome",0));
      mPhrases.add(new Word("Willkomen","Welcome",0));
      mPhrases.add(new Word("Es tut mir Leid","I am sorry",0));
      mPhrases.add(new Word("Bis spater","See you later",0));
      mPhrases.add(new Word("Bis bald","See you soon",0));
      mPhrases.add(new Word("Hallo","Hello",0));
      mPhrases.add(new Word("Genau","Exactly",0));
      mPhrases.add(new Word("In Ordnung","Alright",0));
      mPhrases.add(new Word("tschuss","Bye",0));
      mPhrases.add(new Word("Leider","Unfortunately",0));
      mPhrases.add(new Word("Gern geschehen","You are Welcome",0));
      mPhrases.add(new Word("Auf Wiedersehen","Good Bye",0));
      mPhrases.add(new Word("GruB Gott","Greeting to god",0));
      mPhrases.add(new Word("Gleichfall","Likewise",0));
      mPhrases.add(new Word("Viel gluck","Good Luck",0));
      mPhrases.add(new Word("Ich liebe du","I love you",0));
      mPhrases.add(new Word("Alles Gute","All the best",0));
        return mPhrases;
    }
}