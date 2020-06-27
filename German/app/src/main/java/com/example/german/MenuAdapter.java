package com.example.german;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MenuAdapter extends ArrayAdapter<Menu> {
    public MenuAdapter(Activity context, List<Menu> menus)
    {
        super(context,0,menus);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View gridView=convertView;
        if(gridView==null)
        {
            gridView = LayoutInflater.from(getContext()).inflate(
                    R.layout.grid_list, parent, false);
        }
        Menu currentMenu=getItem(position);
        TextView showMenu =gridView.findViewById(R.id. my_menu);
        showMenu.setText(currentMenu.getName());

        return gridView;
    }
}
