package com.example.test_gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView =findViewById(R.id.grid_view);
        List<My_Card> ListOfCard =getList();
        GridAdapter gridAdapter =new GridAdapter(ListOfCard,MainActivity.this);
        gridView.setAdapter(gridAdapter);

    }

    private List<My_Card> getList() {
        List<My_Card> ListOfCard =new ArrayList<>();
        ListOfCard.add(new My_Card("Numbers",R.drawable.number));
        ListOfCard.add(new My_Card("Family",R.drawable.family));
        ListOfCard.add(new My_Card("Colors",R.drawable.color));
        ListOfCard.add(new My_Card("Phrases",R.drawable.phrases));
        ListOfCard.add(new My_Card("Days",R.drawable.days));
        ListOfCard.add(new My_Card("Introduction",R.drawable.intro));
        return ListOfCard;
    }
}