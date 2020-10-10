package com.example.listreminder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   TabLayout tabLayout;
   PageAdapter pageAdapter;
   ArrayList<Items> list = new ArrayList<>();
    ArrayAdapter adapter;
    int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       tabLayout =findViewById(R.id.tabLayout);
       tabLayout.addTab(tabLayout.newTab().setText("Item List"));
       tabLayout.addTab(tabLayout.newTab().setText("History"));
       tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

       pageAdapter =new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
       

        Button btn =  findViewById(R.id.enter);
        adapter = new ItemAdapter(this, list);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edit = findViewById(R.id.items);
                  String enteredString =edit.getText().toString();
                  if(enteredString.isEmpty())
                      enteredString = "Empty!!";
                list.add(new Items(enteredString, ++number));
                edit.getText().clear();
                adapter.notifyDataSetChanged();
            }
        });

        final ListView myList = findViewById(R.id.mylist);
        myList.setAdapter(adapter);
        Button btn1 = findViewById(R.id.clear);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                number = 0;
                adapter.clear();
            }
        });

    }
    protected void onDestroy() {
        super.onDestroy();
        list.clear();
    }

}