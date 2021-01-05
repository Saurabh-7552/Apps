package com.example.listreminder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    Button mClearHistory;
    ListView historyListView;
    List<Items> historyList;
    ItemAdapter historyAdapter;
    DataBaseHelper dataBaseHelper;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        setTitle("Remind Me");
        androidx.appcompat.widget.Toolbar toolbars = findViewById(R.id.custom_toolbar_history);
        setSupportActionBar(toolbars);


        drawerLayout = findViewById(R.id.history_drawer);
        navigationView = findViewById(R.id.nav_header_history);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbars, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();




        mClearHistory = findViewById(R.id.clear_history);
        historyListView = findViewById(R.id.history_list);
        dataBaseHelper = new DataBaseHelper(HistoryActivity.this);
        historyList = ViewData();

        if (historyList != null) {
            historyAdapter = new ItemAdapter(HistoryActivity.this, historyList);
            historyListView.setAdapter(historyAdapter);
        } else {
            Toast.makeText(HistoryActivity.this, "Oops No history to Show", Toast.LENGTH_SHORT).show();
        }
        mClearHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                historyList.clear();
                historyAdapter.clear();
                dataBaseHelper.Delete();
                Toast.makeText(HistoryActivity.this,"Content Deleted Congrats!!!",Toast.LENGTH_LONG).show();
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.home_menu)
                {
                    Intent intent = new Intent(HistoryActivity.this,ftab1.class);
                    startActivity(intent);
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });

    }

    private List<Items> ViewData() {

        Cursor cursor = dataBaseHelper.getData();
        if (historyList != null)
            historyList.clear();
        if (historyAdapter != null) {
            historyAdapter.clear();
            historyAdapter.notifyDataSetChanged();
        }
        List<Items> ItemsList = new ArrayList<>();
        if (cursor.getCount() == 0)
            Toast.makeText(HistoryActivity.this, "Oops No history to Show", Toast.LENGTH_SHORT).show();
        else {
            while (cursor.moveToNext()) {
                int getNumber = Integer.parseInt(cursor.getString(2));
                ItemsList.add(new Items(cursor.getString(1), getNumber));
            }
            if (historyAdapter != null)
                historyAdapter.notifyDataSetChanged();
        }
        return ItemsList;
    }
}