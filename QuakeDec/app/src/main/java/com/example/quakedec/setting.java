package com.example.quakedec;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

public class setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Toolbar toolbar = findViewById(R.id.toolbar_setting);
        setSupportActionBar(toolbar);
        NavigationView navigationView = findViewById(R.id.navmenu_setting);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_setting);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_home:
                    Intent homeIntent = new Intent(this, MainActivity.class);
                    drawerLayout.closeDrawer(GravityCompat.START);
                    startActivity(homeIntent);
                    break;
                case R.id.menu_About:
                    Intent aboutIntent = new Intent(this, About.class);
                    drawerLayout.closeDrawer(GravityCompat.START);
                    startActivity(aboutIntent);

                    break;
                case R.id.menu_Setting: drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                default:
            }
            return true;
        });
    }
}