package com.example.elahi.aplicacionened;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class Emergencias extends Fragment {

        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_emergencias,
                    container, false);

            //Emergencias.this(rootView);

            return rootView;

        }
}
