package com.example.elahi.aplicacionened;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;



public class Fragement_futbol extends Fragment {
        private List<Clase_futbol> Partido=new ArrayList<Clase_futbol>();
        View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragement_futbol, container, false);
        Partido();
        PartidoView();
        return view;
    }

    private void Partido(){
        Partido.add(new Clase_futbol("CELAYA","TEPIC","LA SALLE","10:00",R.drawable.futbol));
        Partido.add(new Clase_futbol("CD GUZMAN","COMALCALCO","LA SALLE","14:00",R.drawable.futbol));
        Partido.add(new Clase_futbol("TLALNEPANTLA","VERACRUZ","NAZARENO","10:00",R.drawable.futbol));
        Partido.add(new Clase_futbol("LA LAGUNA","TOLUCA","NAZARENO","14:00",R.drawable.futbol));
        Partido.add(new Clase_futbol("HUATABUAMPO","SIERRA NTE PUEBLA","MRCI","10:00",R.drawable.futbol));
        Partido.add(new Clase_futbol("TUXTEPEC","DURANGO","MRCI","14:00",R.drawable.futbol));
        Partido.add(new Clase_futbol("MERIDA","MATEHUALA","IT OAXACA","14:00",R.drawable.futbol));
        Partido.add(new Clase_futbol("CUAUTLA","OAXACA","IT OAXACA","10:00",R.drawable.futbol));

    }

     private void PartidoView(){
        ArrayAdapter<Clase_futbol>adapter=new MyListAdapter();
         ListView list=(ListView) view.findViewById(R.id.listview);
         list.setAdapter(adapter);
     }

    private class MyListAdapter extends ArrayAdapter<Clase_futbol>{
        public MyListAdapter(){
            super(getActivity(), R.layout.item_view,Partido);
        }

        public View getView (int position, View convertView, ViewGroup parent){
            View itemView = convertView;
            if (itemView==null)
                itemView=getLayoutInflater().inflate(R.layout.item_view, parent,false);

            Clase_futbol CurrentPartido= Partido.get(position);

            ImageView imageView = (ImageView) itemView.findViewById(R.id.logo);
            imageView.setImageResource(CurrentPartido.getImagen());

            TextView Equipo1View = (TextView)  itemView.findViewById(R.id.Equipo1);
            Equipo1View.setText(CurrentPartido.getEquipo1());

            TextView Equipo2View = (TextView)  itemView.findViewById(R.id.Equipo2);
            Equipo2View.setText(CurrentPartido.getEquipo2());

            TextView SedeView = (TextView)  itemView.findViewById(R.id.sede);
            SedeView.setText(CurrentPartido.getSede());

            TextView HorarioView = (TextView)  itemView.findViewById(R.id.horario);
            HorarioView.setText(CurrentPartido.getHorario());



            return itemView;
        }

    }

}
