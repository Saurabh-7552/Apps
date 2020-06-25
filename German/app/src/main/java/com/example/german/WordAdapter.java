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

import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {


    public WordAdapter(@NonNull Activity context, List<Word> words)
    {
        super(context, 0,words);
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
        TextView germansWord = (TextView)listView.findViewById(R.id.deutsch);
        assert currentView != null;
        germansWord.setText(currentView.getGermanWord());

         TextView defaultWord = (TextView)listView.findViewById(R.id.englisch);
        defaultWord.setText(currentView.getdefaultWord());
        ImageView wordImages=(ImageView)listView.findViewById(R.id.wordImage);
        wordImages.setImageResource(currentView.getImageResource());
        return listView;
    }
}
