package com.example.newsworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.newsworld.Fragments.Apple;
import com.example.newsworld.Fragments.Business;
import com.example.newsworld.Fragments.Default;
import com.example.newsworld.Fragments.Entertainment;
import com.example.newsworld.Fragments.Genral;
import com.example.newsworld.Fragments.Health;
import com.example.newsworld.Fragments.Science;
import com.example.newsworld.Fragments.Sports;
import com.example.newsworld.Fragments.Techcrunch;
import com.example.newsworld.Fragments.Tesla;
import com.example.newsworld.Fragments.Wsj;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

        DrawerLayout drawer;
        NavigationView nav;
        Toolbar  toolbar;
        FrameLayout frame;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frame=findViewById(R.id.frame);
        nav=findViewById(R.id.nav_view);
        drawer=findViewById(R.id.drawelayout);

        toolbar = findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame,new Default())
                .commit();


        nav.setNavigationItemSelectedListener(this);

        //Setting Toggle Button
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle (this, drawer , toolbar,
                R.string.navigation_drawer_open , R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        //toggle button finish here


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_apple:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame,new Apple())
                            .commit();
                break;
            case R.id.menu_business:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame,new Business())
                        .commit();
                break;
            case R.id.menu_techcrunch:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame,new Techcrunch())
                        .commit();
                break;
            case R.id.menu_tesla:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame,new Tesla())
                        .commit();
                break;
            case R.id.menu_wsj:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame,new Wsj())
                        .commit();
                break;
            case R.id.menu_entertainment:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame,new Entertainment())
                        .commit();
                break;
            case R.id.menu_genral:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame,new Genral())
                        .commit();
                break;
            case R.id.menu_health:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame,new Health())
                        .commit();
                break;
            case R.id.menu_science:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame,new Science())
                        .commit();
                break;
            case R.id.menu_sports:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame,new Sports())
                        .commit();
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}