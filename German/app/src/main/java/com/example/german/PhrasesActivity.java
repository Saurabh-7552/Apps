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
        WordAdapter mWordAdapter =new WordAdapter(this,myPhrases,R.color.category_phrases);
        ListView phraseView =findViewById(R.id.rootView);
        phraseView.setAdapter(mWordAdapter);
    }
    private List<Word> createList()
    {
        List<Word> mPhrases=new ArrayList<>();
      mPhrases.add(new Word("Guten Morgen","Good Morning"));
      mPhrases.add(new Word("Guten Tag","Good Day"));
      mPhrases.add(new Word("Guten Abend","Good Evening"));
      mPhrases.add(new Word("Guten Nacht","Good Night"));
      mPhrases.add(new Word("Bitte","Pardon,Please,Welcome"));
      mPhrases.add(new Word("Willkomen","Welcome"));
      mPhrases.add(new Word("Es tut mir Leid","I am sorry"));
      mPhrases.add(new Word("Bis spater","See you later"));
      mPhrases.add(new Word("Bis bald","See you soon"));
      mPhrases.add(new Word("Hallo","Hello"));
      mPhrases.add(new Word("Genau","Exactly"));
      mPhrases.add(new Word("In Ordnung","Alright"));
      mPhrases.add(new Word("tschuss","Bye"));
      mPhrases.add(new Word("Leider","Unfortunately"));
      mPhrases.add(new Word("Gern geschehen","You are Welcome"));
      mPhrases.add(new Word("Auf Wiedersehen","Good Bye"));
      mPhrases.add(new Word("GruB Gott","Greeting to god"));
      mPhrases.add(new Word("Gleichfall","Likewise"));
      mPhrases.add(new Word("Viel gluck","Good Luck"));
      mPhrases.add(new Word("Ich liebe du","I love you"));
      mPhrases.add(new Word("Alles Gute","All the best"));
        return mPhrases;
    }
    

}