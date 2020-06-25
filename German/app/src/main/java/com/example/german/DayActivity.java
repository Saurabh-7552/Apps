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
        myList.add(new Word("Tage","Days",0));
        myList.add(new Word("Montag","Monday",0));
        myList.add(new Word("Deinstag","Tuesday",0));
        myList.add(new Word("Mittwoch","Wednesday",0));
        myList.add(new Word("Donnerstag","Thursday",0));
        myList.add(new Word("Freitag","Friday",0));
        myList.add(new Word("Samstag","Saturday",0));
        myList.add(new Word("Sonntag","Sunday",0));
        myList.add(new Word("Years","Jahre",0));
        myList.add(new Word("Januar","January",0));
        myList.add(new Word("Februar","February",0));
        myList.add(new Word("Marz","March",0));
        myList.add(new Word("April","April",0));
        myList.add(new Word("Mai","May",0));
        myList.add(new Word("Juni","June",0));
        myList.add(new Word("Juli","July",0));
        myList.add(new Word("August","August",0));
        myList.add(new Word("September","September",0));
        myList.add(new Word("Oktober","October",0));
        myList.add(new Word("November","November",0));
        myList.add(new Word("Dezember","December",0));
        myList.add(new Word("Das Wochenende","The Weekend",0));
        myList.add(new Word("Die Woche","The Week",0));
        myList.add(new Word("Die Saison","The Season",0));
        myList.add(new Word("Der Sommer","The Summer",0));
        myList.add(new Word("Der Herbst","Autumn",0));
        myList.add(new Word("Der Winter","Winter",0));
        myList.add(new Word("Der Fruhling","Spring",0));

        return myList;
    }
}