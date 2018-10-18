package com.example.elahi.aplicacionened;

import android.Manifest;
import android.content.pm.PackageManager;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
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
    private static final int CAMERA_PERMISSION_REQUEST_CODE = 1;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            //Si el permiso no se encuentra concedido se solicita
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, CAMERA_PERMISSION_REQUEST_CODE);
        } else {
            //Si el permiso esá concedico prosigue con el flujo normal
            permissionGranted();
        }
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

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Calendario()).commit();
            navigationView.setCheckedItem(R.id.nav_calendario);
        }
    }

    private void permissionGranted() {
        Toast.makeText(MainActivity.this, getString(R.string.permission_granted), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.nav_noticias:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new Noticias()).commit();
                    break;
                /*case R.id.nav_resultados:
                    Toast.makeText(this, "Resultados", Toast.LENGTH_SHORT).show();
                    break;*/
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
