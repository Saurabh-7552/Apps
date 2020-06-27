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
        WordAdapter arrayAdapter =new WordAdapter(this,familyList,R.color.category_family);
        ListView showFamilyList =findViewById(R.id.rootView);
        showFamilyList.setAdapter(arrayAdapter);
    }
    private List<Word> createList()
    {
        List<Word> myFamilies = new ArrayList<>();
        myFamilies.add(new Word("Der Vater","The Father",R.drawable.father));
        myFamilies.add(new Word("Die Mutter","The Mother",R.drawable.mother));
        myFamilies.add(new Word("Das Kind","Child",R.drawable.child));
        myFamilies.add(new Word("Die Schwester","The Sister",R.drawable.sister));
        myFamilies.add(new Word("Der Bruder","The Brother",R.drawable.brother));
        myFamilies.add(new Word("Der Sohn","The Son",R.drawable.son));
        myFamilies.add(new Word("Die Tochter","The Daughter",R.drawable.daughters));
        myFamilies.add(new Word("Die Ehefrau","The Wife",R.drawable.wife));
        myFamilies.add(new Word("Der Ehemann","The Husband",R.drawable.husband));
        myFamilies.add(new Word("Der Halbbruder","The Half-Brother",R.drawable.brother));
        myFamilies.add(new Word("Die HalbSchwester","The Half-Sister",R.drawable.sister));
        myFamilies.add(new Word("Der Onkel","The Uncle",R.drawable.uncle));
        myFamilies.add(new Word("Die Tante","The Aunt",R.drawable.aunty));
        myFamilies.add(new Word("Der Neffe","The Nephew",R.drawable.brother));
        myFamilies.add(new Word("Der Enkel","The Grandson",R.drawable.child));
        myFamilies.add(new Word("Der Enkelin","The Granddaughter",R.drawable.daughters));
        myFamilies.add(new Word("Der GroBvater","The Grandfather",R.drawable.grandfather));
        myFamilies.add(new Word("Der GroBmutter","The Grandmother",R.drawable.grandmother));
        myFamilies.add(new Word("Die Stiefmutter","The Stepmother",R.drawable.mother));
        myFamilies.add(new Word("Die Stiefsohn","The Stepson",R.drawable.son));
        myFamilies.add(new Word("Die Stiefbruder","The Stepbrother",R.drawable.brother));
        myFamilies.add(new Word("Die Stiefschwester","The Stepsister",R.drawable.sister));


        return  myFamilies;

    }

}