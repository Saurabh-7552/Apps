package com.example.german;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         /////////////////////////////1/////////////////////////
        TextView getNumbers =(TextView) findViewById(R.id.numbers);
         getNumbers.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Toast.makeText(view.getContext(),"Getting to Numbers",Toast.LENGTH_SHORT).show();
                 Intent toNumberActivity = new Intent(MainActivity.this,NumbersActivity.class);
                 startActivity(toNumberActivity);
             }
         });
         ////////////////////////////2///////////////////////////////////
         TextView getFamilyMember =(TextView) findViewById(R.id.family);
         getFamilyMember.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Toast.makeText(view.getContext(),"Getting to Family Members",Toast.LENGTH_SHORT).show();
                 Intent toFamilyActivity = new Intent(MainActivity.this,FamilyActivity.class);
                 startActivity(toFamilyActivity);
             }
         });
         ///////////////////////////3//////////////////////////////////////
         TextView getColors =(TextView) findViewById(R.id.colors);
         getColors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Getting to Colors",Toast.LENGTH_SHORT).show();
                Intent toColorActivity = new Intent(MainActivity.this,ColorsActivity.class);
                startActivity(toColorActivity);
              }
          });
        ////////////////////////////4/////////////////////////////////////
         TextView getPhrases =(TextView)findViewById(R.id.phrases);
         getPhrases.setOnClickListener(new View.OnClickListener(){
               public void onClick(View view)
               {
                   Toast.makeText(view.getContext(),"Getting to Phrases",Toast.LENGTH_SHORT).show();
                   Intent toPhrasesActivity = new Intent(MainActivity.this,PhrasesActivity.class);
                   startActivity(toPhrasesActivity);
                  }

         });
        //////////////////////////////5////////////////////////////////////////
        TextView getDays = (TextView) findViewById(R.id.Days);
          getDays.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Toast.makeText(view.getContext(),"Getting To Days",Toast.LENGTH_SHORT);
                  Intent toDayActivity =new Intent(MainActivity.this,DayActivity.class);
                  startActivity(toDayActivity);
              }
          });
          ////////////////////////////6//////////////////////////////////////////
        TextView getIntro =(TextView)findViewById(R.id.Intro);
        getIntro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Getting to Introduction",Toast.LENGTH_SHORT);
                Intent toIntro = new Intent(MainActivity.this,IntroActivity.class);
                startActivity(toIntro);
            }
        });
        ////////////////////////////////////////////////////////////////////////////
        final ImageView myImage=(ImageView)findViewById(R.id.imageAndroid);
        myImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myImage.setImageResource(R.drawable.kiefer);
            }
        });

    }

}