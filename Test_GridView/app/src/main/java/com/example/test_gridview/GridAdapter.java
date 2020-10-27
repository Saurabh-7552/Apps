package com.example.test_gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GridAdapter extends BaseAdapter {
    List<My_Card> my_cards;
    Context context;

    public GridAdapter(List<My_Card> my_cards, Context context) {
        this.my_cards = my_cards;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1=layoutInflater.inflate(R.layout.onecard,null);
        ImageView imageView = view1.findViewById(R.id.iconImage);
        TextView textView = view1.findViewById(R.id.textData);
        imageView.setImageResource(my_cards.get(i).getImageResource());
        textView.setText(my_cards.get(i).getName());
        return view1;
    }
}
