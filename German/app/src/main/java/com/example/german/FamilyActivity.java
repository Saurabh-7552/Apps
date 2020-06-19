package com.example.german;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_list);
        List<Word> familyList = createList();
        WordAdapter arrayAdapter =new WordAdapter(this,familyList);
        ListView showFamilyList =(ListView)findViewById(R.id.rootView);
        showFamilyList.setAdapter(arrayAdapter);
    }
    private List<Word> createList()
    {
        List<Word> myFamilies = new ArrayList<>();
        myFamilies.add(new Word("Der Vater","The Father"));
        myFamilies.add(new Word("Die Mutter","The Mother"));
        myFamilies.add(new Word("Das Kind","Child"));
        myFamilies.add(new Word("Die Schwester","The Sister"));
        myFamilies.add(new Word("Der Bruder","The Brother"));
        myFamilies.add(new Word("Der Sohn","The Son"));
        myFamilies.add(new Word("Die Tochter","The Daughter"));
        myFamilies.add(new Word("Die Ehefrau","The Wife"));
        myFamilies.add(new Word("Der Ehemann","The Husband"));
        myFamilies.add(new Word("Der Halbbruder","The Half-Brother"));
        myFamilies.add(new Word("Die HalbSchwester","The Half-Sister"));
        myFamilies.add(new Word("Der Onkel","The Uncle"));
        myFamilies.add(new Word("Die Tante","The Aunt"));
        myFamilies.add(new Word("Der Neffe","The Nephew"));
        myFamilies.add(new Word("Der Enkel","The Grandson"));
        myFamilies.add(new Word("Der Enkelin","The Granddaughter"));
        myFamilies.add(new Word("Der GroBvater","The Grandfather"));
        myFamilies.add(new Word("Der GroBmutter","The Grandmother"));
        myFamilies.add(new Word("Die Stiefmutter","The Stepmother"));
        myFamilies.add(new Word("Die Stiefsohn","The Stepson"));
        myFamilies.add(new Word("Die Stiefbruder","The Stepbrother"));
        myFamilies.add(new Word("Die Stiefschwester","The Stepsister"));


        return  myFamilies;

    }

}