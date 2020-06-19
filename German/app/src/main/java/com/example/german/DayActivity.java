package com.example.german;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_list);
        List<Word> getDays=createList();
        WordAdapter wordAdapter = new WordAdapter(this,getDays);
        ListView dayList =(ListView)findViewById(R.id.rootView);
        dayList.setAdapter(wordAdapter);
    }
    private List<Word> createList()
    {
        List<Word> myList =new ArrayList<>();
        myList.add(new Word("Tage","Days"));
        myList.add(new Word("Montag","Monday"));
        myList.add(new Word("Deinstag","Tuesday"));
        myList.add(new Word("Mittwoch","Wednesday"));
        myList.add(new Word("Donnerstag","Thursday"));
        myList.add(new Word("Freitag","Friday"));
        myList.add(new Word("Samstag","Saturday"));
        myList.add(new Word("Sonntag","Sunday"));
        myList.add(new Word("Years","Jahre"));
        myList.add(new Word("Januar","January"));
        myList.add(new Word("Februar","February"));
        myList.add(new Word("Marz","March"));
        myList.add(new Word("April","April"));
        myList.add(new Word("Mai","May"));
        myList.add(new Word("Juni","June"));
        myList.add(new Word("Juli","July"));
        myList.add(new Word("August","August"));
        myList.add(new Word("September","September"));
        myList.add(new Word("Oktober","October"));
        myList.add(new Word("November","November"));
        myList.add(new Word("Dezember","December"));
        myList.add(new Word("Das Wochenende","The Weekend"));
        myList.add(new Word("Die Woche","The Week"));
        myList.add(new Word("Die Saison","The Season"));
        myList.add(new Word("Der Sommer","The Summer"));
        myList.add(new Word("Der Herbst","Autumn"));
        myList.add(new Word("Der Winter","Winter"));
        myList.add(new Word("Der Fruhling","Spring"));

        return myList;
    }
}