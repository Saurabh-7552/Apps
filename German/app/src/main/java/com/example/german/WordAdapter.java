package com.example.german;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {

   private int color;
    public WordAdapter(@NonNull Activity context, List<Word> words,int color)
    {
        super(context, 0,words);
        this.color=color;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;
        if(listView == null)
        {
            listView = LayoutInflater.from(getContext()).inflate(
                    R.layout.layout_german, parent, false);
        }
        Word currentView = getItem(position);
        TextView germansWord = listView.findViewById(R.id.deutsch);
        assert currentView != null;
        germansWord.setText(currentView.getGermanWord());

         TextView defaultWord = listView.findViewById(R.id.englisch);
        defaultWord.setText(currentView.getdefaultWord());
        ImageView wordImages=listView.findViewById(R.id.wordImage);
        if(wordImages==null) {
            wordImages.setVisibility(View.GONE);//Layout is invisible without taking space GONE=8, INVISIBLE takes spaces
        }
        else {
            wordImages.setImageResource(currentView.getImageResource());
            int mColor = ContextCompat.getColor(getContext(),color);
            wordImages.setBackgroundColor(mColor);
        }
        return listView;
    }
}
