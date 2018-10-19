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


public class Fragment_Ajedrez extends Fragment {
    private List<Clase_futbol> Partido=new ArrayList<Clase_futbol>();
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_ajedrez2, container, false);

        PartidoView();
        return view;
    }

   /* private void Partido(){
        //JORNADA1
        Partido.add(new Clase_futbol("JUNTA PREVIA","MEXICALI","CENTRO DE INFORMACIÓN","DOMINGO 13:00",R.drawable.strategy,"JORNADA 1"));
        Partido.add(new Clase_futbol("PRIMERA RONDA","POZA RICA","CENTRO DE INFORMACIÓN","LUNES 09:00",R.drawable.strategy,"JORNADA 1"));

        //JORNADA2
        Partido.add(new Clase_futbol("SEGUNDA RONDA","POZA RICA","CENTRO DE INFORMACIÓN","LUNES 15:00",R.drawable.strategy,"JORNADA 2"));
        Partido.add(new Clase_futbol("TERCERA RONDA","PUEBLA","CENTRO DE INFORMACIÓN","MARTES 09:00",R.drawable.strategy,"JORNADA 2"));

        //JORNADA3
        Partido.add(new Clase_futbol("CUARTA RONDA","PUEBLA","CENTRO DE INFORMACIÓN","MIERCOLES 09:00",R.drawable.strategy,"JORNADA 3"));
        Partido.add(new Clase_futbol("QUINTA RONDA","MEXICALI","CENTRO DE INFORMACIÓN","JUEVES 09:00",R.drawable.strategy,"JORNADA 3"));
        Partido.add(new Clase_futbol("SEXTA RONDA","MEXICALI","CENTRO DE INFORMACIÓN","VIERNES 09:00",R.drawable.strategy,"JORNADA 3"));

    }*/

    private void PartidoView(){
        ArrayAdapter<Clase_futbol> adapter=new MyListAdapter();
        ListView list=(ListView) view.findViewById(R.id.listview);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Clase_futbol>{
        public MyListAdapter(){
            super(getActivity(), R.layout.item_view_ajedrez,Partido);
        }

        public View getView (int position, View convertView, ViewGroup parent){
            Fragment_Ajedrez.ViewHolder holder = null;
            View itemView = convertView;
            if (itemView==null){
                itemView=getLayoutInflater().inflate(R.layout.item_view_ajedrez, parent,false);

                holder = new Fragment_Ajedrez.ViewHolder();

                holder.imageView = (ImageView) itemView.findViewById(R.id.logo) ;
                holder.Equipo1=(TextView) itemView.findViewById(R.id.Equipo1) ;
                holder.Lugar=(TextView) itemView.findViewById(R.id.sede);
                holder.Horario=(TextView) itemView.findViewById(R.id.horario);

                itemView.setTag(holder);}

            else
                holder = (Fragment_Ajedrez.ViewHolder) itemView.getTag();

            Clase_futbol CurrentPartido= Partido.get(position);

            holder.imageView.setImageResource(CurrentPartido.getImagen());
            holder.Equipo1.setText(CurrentPartido.getEquipo1());
            holder.Lugar.setText(CurrentPartido.getSede());
            holder.Horario.setText(CurrentPartido.getHorario());


            return itemView;
        }

    }

    static class ViewHolder{
        ImageView imageView;
        TextView Equipo1;
        TextView Horario;
        TextView Lugar;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Partido.clear();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Partido.clear();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Partido.clear();
    }

}
