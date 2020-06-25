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
        words.add(new Word("Null","Zero",R.drawable.digit_zero));
        words.add(new Word("Ein","One",R.drawable.digit_two));
        words.add(new Word("Zwei","Two",R.drawable.digit_three));
        words.add(new Word("Drei","Three",R.drawable.digit_four));
        words.add(new Word("Vier","Four",R.drawable.digit_five));
        words.add(new Word("Funf","Five",R.drawable.digit_six));
        words.add(new Word("Sechs","Six",R.drawable.digit_seven));
        words.add(new Word("Sieben","Seven",R.drawable.digit_eight));
        words.add(new Word("Acht","Eight",R.drawable.digit_nine));
        words.add(new Word("Neun","Nine",R.drawable.digit_one));
        words.add(new Word("Zehn","Ten",R.drawable.digit_one));
        words.add(new Word("Elf","Eleven",R.drawable.digit_one));
        words.add(new Word("Zwolf","Twelve",R.drawable.digit_one));
        words.add(new Word("Dreizehn","Thirteen",R.drawable.digit_one));
        words.add(new Word("Vierzehn","Fourteen",R.drawable.digit_one));
        words.add(new Word("Funfzehn","Fifteen",R.drawable.digit_one));
        words.add(new Word("Sechzehn","Sixteen",R.drawable.digit_one));
        words.add(new Word("Siebzehn","Seventeen",R.drawable.digit_one));
        words.add(new Word("Achtzehn","Eighteen",R.drawable.digit_one));
        words.add(new Word("Neunzehn","Nineteen",R.drawable.digit_one));
        words.add(new Word("Zwanzig","Twenty",R.drawable.digit_one));
        words.add(new Word("Einundzwanzig","Twenty One",R.drawable.digit_one));
        words.add(new Word("Zweiundzwanzig","Twenty Two",R.drawable.digit_one));
        words.add(new Word("Neunundzwanzig","Twenty Two",R.drawable.digit_one));
        words.add(new Word("Dreiundzwanzig","Twenty Three",R.drawable.digit_one));
        words.add(new Word("Vierundzwanzig","Twenty Four",R.drawable.digit_one));
        words.add(new Word("Funfundzwanzig","Twenty Five",R.drawable.digit_one));
        words.add(new Word("Sechsundzwanzig","Twenty Six",R.drawable.digit_one));
        words.add(new Word("Siebenundzwanzig","Twenty Seven",R.drawable.digit_one));
        words.add(new Word("Achtundzwanzig","Twenty Eight",R.drawable.digit_one));
        words.add(new Word("Neunundzwanzig","Twenty Nine",R.drawable.digit_one));
        words.add(new Word("DreiBig","Thirty",R.drawable.digit_one));
        words.add(new Word("Vierzig","Forty",R.drawable.digit_one));
        words.add(new Word("funfzig","Fifty",R.drawable.digit_one));
        words.add(new Word("Sechzig","Sixty",R.drawable.digit_one));
        words.add(new Word("Siebzig","Seventy",R.drawable.digit_one));
        words.add(new Word("Achtzig","Eighty",R.drawable.digit_one));
        words.add(new Word("Neunzig","Ninety",R.drawable.digit_one));
        words.add(new Word("Hundert","Hundred",R.drawable.digit_one));
        words.add(new Word("Vierhundertzweiundfunfzig","Four Hundred fifty Two",R.drawable.digit_one));
        words.add(new Word("Tausand","Thousand",R.drawable.digit_one));

        Log.v("NumberActivity","words are shown");

        return words;
    }
}