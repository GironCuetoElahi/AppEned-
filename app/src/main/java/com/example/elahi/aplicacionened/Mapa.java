package com.example.elahi.aplicacionened;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class Mapa extends Fragment implements OnMapReadyCallback {
    SupportMapFragment mapFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v= inflater.inflate(R.layout.fragment_mapa, container, false);
       mapFragment= (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
       if (mapFragment == null){
           FragmentManager fm = getFragmentManager();
           FragmentTransaction ft= fm.beginTransaction();
           mapFragment= SupportMapFragment.newInstance();
           ft.replace(R.id.map, mapFragment).commit();
       }
       mapFragment.getMapAsync(this);
       return v;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Posicionar el mapa en una localización y con un nivel de zoom
        LatLng latLng = new LatLng(17.080200, -96.746447);
        // Un zoom mayor que 13 hace que el emulador falle, pero un valor deseado para
        // callejero es 17 aprox.
        float zoom = 13;
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));

        // Colocar un marcador en la misma posición
        googleMap.addMarker(new MarkerOptions().position(latLng));
        // Más opciones para el marcador en:
        // https://developers.google.com/maps/documentation/android/marker

        // Otras configuraciones pueden realizarse a través de UiSettings
        // UiSettings settings = getMap().getUiSettings();
    }
}
