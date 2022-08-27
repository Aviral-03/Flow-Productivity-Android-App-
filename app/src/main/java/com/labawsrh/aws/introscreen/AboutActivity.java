package com.labawsrh.aws.introscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar toolbar = findViewById(R.id.toolbar);

        drawer = findViewById(R.id.drawerId);
        NavigationView navigationView = findViewById(R.id.navigationId);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.nav_open, R.string.nav_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();



    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Intent intent;

        if (item.getItemId()==R.id.nav_music){
            intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        else if (item.getItemId()==R.id.nav_timer){
            intent = new Intent(this, TimerActivity.class);
            startActivity(intent);
        }

        else if (item.getItemId()==R.id.nav_about){
            Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
        }

        else if (item.getItemId()==R.id.nav_goal){
            intent = new Intent(this, GoalActivity.class);
            startActivity(intent);
        }


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}