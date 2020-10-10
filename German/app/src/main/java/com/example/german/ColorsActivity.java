package com.example.german;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ColorsActivity extends AppCompatActivity {
    MediaPlayer mSong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_list);
        List<Word> colors =createList();
        WordAdapter colorAdapter =new WordAdapter(this,colors,R.color.category_colors);
        ListView colorList =findViewById(R.id.rootView);
        colorList.setAdapter(colorAdapter);


    }
    private List<Word> createList()
    {
        List<Word> colors= new ArrayList<>();
        colors.add(new Word("Schwarz","Black",R.mipmap.color_black));
        colors.add(new Word("Braun","Brown",R.mipmap.color_brown));
        colors.add(new Word("Grau","Gray",R.mipmap.color_gray));
        colors.add(new Word("Grün","Green",R.mipmap.color_green));
        colors.add(new Word("Gelb","Mustard-Yellow",R.mipmap.color_mustard_yellow));
        colors.add(new Word("Rot","Red",R.mipmap.color_red));
        colors.add(new Word("Weiß","White",R.mipmap.color_white));

        return colors;
    }
}