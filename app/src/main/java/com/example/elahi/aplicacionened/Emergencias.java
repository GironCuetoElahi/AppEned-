package com.example.elahi.aplicacionened;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Intent;


public class Emergencias extends Fragment {

    View view;

        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            view = inflater.inflate(R.layout.fragment_emergencias,
                    container, false);
            boton();
            return view;

        }

        private void boton(){
            Button boton = (Button) view.findViewById(R.id.boton1);

            boton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager fragmentManager = getFragmentManager();
                    Fragment fragment = null;

                            fragment = new Fragment_sismo();

                    fragmentManager
                            .beginTransaction()
                            .replace(R.id.fragment_container2,
                                    fragment).commit();

                                 }
            });
        }


}
