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

        /*Ubicaciones*/
        // Posicionar el mapa en una localización y con un nivel de zoom
        LatLng brenamiel = new LatLng(17.09531, -96.74963);
        LatLng canchamrci = new LatLng(17.07864, -96.71024);
        LatLng urse = new LatLng(17.0497, -96.6934);
        LatLng olivos = new LatLng(17.07743, -96.74175);
        LatLng ito = new LatLng(17.08174, -96.74527);
        LatLng uabjo = new LatLng(17.04571, -96.71528);
        LatLng urseBasq = new LatLng(17.052,-96.69259);
        LatLng harp = new LatLng(16.96318,-96.71181);
        LatLng estadioMerci = new LatLng(17.01079, -96.57348);
        LatLng tlacochahuaya = new LatLng(17.00946, -96.59328);
        LatLng nazareno = new LatLng(17.18064, -96.82133);
        LatLng salle = new LatLng(17.01961, -96.7203);
        LatLng vinicio = new LatLng(    17.08915, -96.71062);
        LatLng depBrenamiel = new LatLng(17.10435,-96.75374);
        // Un zoom mayor que 13 hace que el emulador falle, pero un valor deseado paravcallejero es 17 aprox.
        float zoom = 13;
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ito, zoom));
        // Colocar un marcador en la misma posición
        googleMap.addMarker(new MarkerOptions().position(brenamiel)
                .title("Canchas Brenamiel"));
        googleMap.addMarker(new MarkerOptions().position(canchamrci)
                .title("Canchas MRCI"));
        googleMap.addMarker(new MarkerOptions().position(urse)
                .title("Canchas URSE"));
        googleMap.addMarker(new MarkerOptions().position(olivos)
                .title("Los Olivos"));
        googleMap.addMarker(new MarkerOptions().position(ito)
                .title("Complejo Deportivo Del Instituto Tecnológico De Oaxaca"));
        googleMap.addMarker(new MarkerOptions().position(uabjo)
                .title("Gimnasio UABJO"));
        googleMap.addMarker(new MarkerOptions().position(urseBasq)
                .title("Gimnasio URSE"));
        googleMap.addMarker(new MarkerOptions().position(harp)
                .title("Academia de Beisbol \"Alfredo Harp Helú\""));
        googleMap.addMarker(new MarkerOptions().position(estadioMerci)
                .title("Estadio MRCI"));
        googleMap.addMarker(new MarkerOptions().position(tlacochahuaya)
                .title("Alfombra Azul San Jerónimo Tlacochahuaya"));
        googleMap.addMarker(new MarkerOptions().position(nazareno)
                .title("Cancha Nazareno"));
        googleMap.addMarker(new MarkerOptions().position(salle)
                .title("La salle"));
        googleMap.addMarker(new MarkerOptions().position(vinicio)
                .title("Parque De Béisbol \"Vinicio Castilla\""));
        googleMap.addMarker(new MarkerOptions().position(depBrenamiel)
                .title("Club Deportivo Brenamiel A.C."));

        /*Hoteles*/
        LatLng misionAngeles    = new LatLng(17.07262,-96.71894);
        LatLng oaxacaDorado     = new LatLng(17.06534,-96.73445);
        LatLng marques          = new LatLng(17.06116,-96.72508);
        LatLng fortinPlaza      = new LatLng(17.07368,-96.72723);
        LatLng lagoexpress      = new LatLng(17.06629,-96.68351);
        LatLng antiguoFor       = new LatLng(17.07881,-96.73996);
        LatLng oaxacainn        = new LatLng(17.07484,-96.71522);
        LatLng hotellife        = new LatLng(17.08519,-96.74433);
        LatLng losolivos        = new LatLng(17.0773,-96.74169);
        LatLng virginia         = new LatLng(17.0647,-96.73591);
        LatLng riveraA          = new LatLng(17.05819,-96.72993);
        LatLng marquesado       = new LatLng(17.06454,-96.7339);
        LatLng xadami           = new LatLng(17.10346,-96.71246);
        LatLng ciruelos         = new LatLng(17.0768,-96.71771);
        LatLng aurora           = new LatLng(17.05838,-96.72543);
        LatLng realhotel        = new LatLng(17.06445,-96.72497);
        LatLng cupulas          = new LatLng(17.10347,-96.71204);


        LatLng posadacid        = new LatLng(17.07101,-96.71871);
        LatLng crespo           = new LatLng(17.06811,-96.72736);
        LatLng innexpress       = new LatLng(17.07051,-96.71661);
        LatLng huautla          = new LatLng(17.07989,-96.74067);


        googleMap.addMarker(new MarkerOptions().position(misionAngeles)
                .title("Hotel Misión de los Ángeles"));
        googleMap.addMarker(new MarkerOptions().position(oaxacaDorado)
                .title("HOTEL Oaxaca Dorado"));
        googleMap.addMarker(new MarkerOptions().position(marques)
                .title("Hotel Marqués Del Valle"));
        googleMap.addMarker(new MarkerOptions().position(fortinPlaza)
                .title("Hotel Fortín Plaza"));
        googleMap.addMarker(new MarkerOptions().position(lagoexpress)
                .title("Hotel Del Lago Express"));
        googleMap.addMarker(new MarkerOptions().position(antiguoFor)
                .title("Hotel Antiguo Fortin"));
        googleMap.addMarker(new MarkerOptions().position(oaxacainn)
                .title("Hotel Oaxaca Inn"));
        googleMap.addMarker(new MarkerOptions().position(hotellife)
                .title("Hotel Life"));
        googleMap.addMarker(new MarkerOptions().position(losolivos)
                .title("Los Olivos"));
        googleMap.addMarker(new MarkerOptions().position(virginia)
                .title("Hotel Virginia"));
        googleMap.addMarker(new MarkerOptions().position(riveraA)
                .title("Hotel Rivera del Ángel"));
        googleMap.addMarker(new MarkerOptions().position(marquesado)
                .title("Hotel del Marquesado"));
        googleMap.addMarker(new MarkerOptions().position(xadami)
                .title("Suites Xadani"));
        googleMap.addMarker(new MarkerOptions().position(ciruelos)
                .title("Hotel Los Ciruelos"));
        googleMap.addMarker(new MarkerOptions().position(aurora)
                .title("Hotel Aurora"));
        googleMap.addMarker(new MarkerOptions().position(realhotel)
                .title("Oaxaca Real Hotel"));
        googleMap.addMarker(new MarkerOptions().position(cupulas)
                .title("Hotel Las Cúpulas"));
        googleMap.addMarker(new MarkerOptions().position(posadacid)
                .title("Hotel Posada el Cid"));
        googleMap.addMarker(new MarkerOptions().position(crespo)
                .title("Hotel Parador Crespo"));
        googleMap.addMarker(new MarkerOptions().position(innexpress)
                .title("Hotel Oaxaca Inn Express"));
        googleMap.addMarker(new MarkerOptions().position(huautla)
                .title("Hotel Huautla"));

        // Más opciones para el marcador en:
        // https://developers.google.com/maps/documentation/android/marker

        // Otras configuraciones pueden realizarse a través de UiSettings
        // UiSettings settings = getMap().getUiSettings();
    }
}
