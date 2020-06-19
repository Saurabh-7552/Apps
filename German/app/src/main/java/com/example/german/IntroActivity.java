package com.example.german;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_list);
        List<Word> getIntro =createList();
        WordAdapter wordAdapter =new WordAdapter(this,getIntro);
        ListView getListIntro =(ListView)findViewById(R.id.rootView);
        getListIntro.setAdapter(wordAdapter);
    }
    private List<Word> createList()
    {
        ArrayList<Word> myLists = new ArrayList<>();
        myLists.add(new Word("Hallo","Hello"));
        myLists.add(new Word("Versteht","Understand"));
        myLists.add(new Word("Sprecht","Speak"));
        myLists.add(new Word("Kommt","Come"));
        myLists.add(new Word("We come from India","Wir Kommen aus India"));
        myLists.add(new Word("Heibt","is called"));
        myLists.add(new Word("Guten Tag","Good Day"));
        myLists.add(new Word("Sehr angenehm","Nice to meet you"));
        myLists.add(new Word("Das ist mein Freund","This is my friend"));
        myLists.add(new Word("Ich wohne in Delhi","I live in Delhi"));

        return myLists;
    }
}