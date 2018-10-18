package com.example.elahi.aplicacionened;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.nav_noticias:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new Noticias()).commit();
                    break;
                case R.id.nav_resultados:
                    Toast.makeText(this, "Resultados", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_calendario:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new Calendario()).commit();
                    break;
                case R.id.nav_ubicacion:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new Mapa()).commit();
                    break;
                case R.id.nav_seguridad:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new Emergencias()).commit();
                    break;
                case R.id.nav_manual:
                    Toast.makeText(this, "Manual", Toast.LENGTH_SHORT).show();
                    break;
            }
            drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
        super.onBackPressed();
        }
    }


}
