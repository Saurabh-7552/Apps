package com.example.german;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NumbersActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_list);
        List<Word> getWords =createNumber();
        WordAdapter arrayAdapter =new WordAdapter(this,getWords);
        ListView listView =(ListView)findViewById(R.id.rootView);
        listView.setAdapter(arrayAdapter);
    }
    private List<Word> createNumber()
    {   final List<Word> words =new ArrayList<>();
        words.add(new Word("Ein","One"));
        words.add(new Word("Zwei","Two"));
        words.add(new Word("Drei","Three"));
        words.add(new Word("Vier","Four"));
        words.add(new Word("Funf","Five"));
        words.add(new Word("Sechs","Six"));
        words.add(new Word("Sieben","Seven"));
        words.add(new Word("Acht","Eight"));
        words.add(new Word("Neun","Nine"));
        words.add(new Word("Zehn","Ten"));
        words.add(new Word("Elf","Eleven"));
        words.add(new Word("Zwolf","Twelve"));
        words.add(new Word("Dreizehn","Thirteen"));
        words.add(new Word("Vierzehn","Fourteen"));
        words.add(new Word("Funfzehn","Fifteen"));
        words.add(new Word("Sechzehn","Sixteen"));
        words.add(new Word("Siebzehn","Seventeen"));
        words.add(new Word("Achtzehn","Eighteen"));
        words.add(new Word("Neunzehn","Nineteen"));
        words.add(new Word("Zwanzig","Twenty"));
        words.add(new Word("Einundzwanzig","Twenty One"));
        words.add(new Word("Zweiundzwanzig","Twenty Two"));
        words.add(new Word("Neunundzwanzig","Twenty Two"));
        words.add(new Word("Dreiundzwanzig","Twenty Three"));
        words.add(new Word("Vierundzwanzig","Twenty Four"));
        words.add(new Word("Funfundzwanzig","Twenty Five"));
        words.add(new Word("Sechsundzwanzig","Twenty Six"));
        words.add(new Word("Siebenundzwanzig","Twenty Seven"));
        words.add(new Word("Achtundzwanzig","Twenty Eight"));
        words.add(new Word("Neunundzwanzig","Twenty Nine"));
        words.add(new Word("DreiBig","Thirty"));
        words.add(new Word("Vierzig","Forty"));
        words.add(new Word("funfzig","Fifty"));
        words.add(new Word("Sechzig","Sixty"));
        words.add(new Word("Siebzig","Seventy"));
        words.add(new Word("Achtzig","Eighty"));
        words.add(new Word("Neunzig","Ninety"));
        words.add(new Word("Hundert","Hundred"));
        words.add(new Word("Vierhundertzweiundfunfzig","Four Hundred fifty Two"));
        words.add(new Word("Tausand","Thousand"));

        Log.v("NumberActivity","words are shown");

        return words;
    }
}