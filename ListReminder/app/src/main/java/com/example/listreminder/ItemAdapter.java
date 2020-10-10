package com.example.listreminder;

import android.content.Context;
import android.content.Intent;
import android.provider.AlarmClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import java.util.List;

public class ItemAdapter extends ArrayAdapter<Items> {
    public ItemAdapter(Context context, List<Items> myList)
    {
        super(context,0,myList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_layout, parent, false);
        }

        final Items currentItem = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.item1);

        assert currentItem != null;
        nameTextView.setText(currentItem.getNumber());
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.item2);
        numberTextView.setText(currentItem.getItem());
        final ImageView alarmClock =listItemView.findViewById(R.id.alarm);
        alarmClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent alarmIntent =new Intent(AlarmClock.ACTION_SET_ALARM);
                alarmIntent.putExtra(AlarmClock.EXTRA_MESSAGE,currentItem.getItem()+"is to be done!");
                alarmIntent.putExtra(AlarmClock.EXTRA_RINGTONE,AlarmClock.VALUE_RINGTONE_SILENT);
                alarmIntent.putExtra(AlarmClock.EXTRA_VIBRATE,true);
                if (alarmIntent.resolveActivity(getContext().getPackageManager()) != null)
                getContext().startActivity(alarmIntent);
            }
        });

        return listItemView;
    }
}
