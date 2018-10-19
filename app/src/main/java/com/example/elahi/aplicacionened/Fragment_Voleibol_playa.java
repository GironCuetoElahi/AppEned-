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


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Voleibol_playa extends Fragment {
    private List<Clase_futbol> Partido=new ArrayList<Clase_futbol>();
        View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =inflater.inflate(R.layout.fragment__voleibol_playa, container, false);
        Partido();
        PartidoView();
        return view;
    }

    private void Partido(){
        //JORNADA 1
        Partido.add(new Clase_futbol("ITSOEH","DURANGO","R. DEL ATOYAC","11:00",R.drawable.playa,"JORNADA 1"));
        Partido.add(new Clase_futbol("COATZACOALCOS","CD. MADERO","R. DEL ATOYAC","09:00",R.drawable.playa,"JORNADA 1"));
        Partido.add(new Clase_futbol("HERMOSILLO","CANCÚN","R. DEL ATOYAC","10:00",R.drawable.playa,"JORNADA 1"));
        Partido.add(new Clase_futbol("OAXACA","COALCOMÁN","R. DEL ATOYAC","08:00",R.drawable.playa,"JORNADA 1"));
        Partido.add(new Clase_futbol("TUXTEPEC","LAZARO CARDENAS","R. DEL ATOYAC","12:00",R.drawable.playa,"JORNADA 1"));
        Partido.add(new Clase_futbol("BOCA DEL RIO","TEPIC","R. DEL ATOYAC","13:00",R.drawable.playa,"JORNADA 1"));
        Partido.add(new Clase_futbol("TEHUACAN","ZACATECAS","R. DEL ATOYAC","14:00",R.drawable.playa,"JORNADA 1"));
        Partido.add(new Clase_futbol("CD. GUZMAN","TOLUCA","R. DEL ATOYAC","15:00",R.drawable.playa,"JORNADA 1"));
        //JORNADA 2
        Partido.add(new Clase_futbol("ITSOEH","CD. MADERO","R. DEL ATOYAC","11:00",R.drawable.playa,"JORNADA 2"));
        Partido.add(new Clase_futbol("DURANGO","COATZACOALCOS","R. DEL ATOYAC","09:00",R.drawable.playa,"JORNADA 2"));
        Partido.add(new Clase_futbol("HERMOSILLO","COALCOMÁN","R. DEL ATOYAC","10:00",R.drawable.playa,"JORNADA 2"));
        Partido.add(new Clase_futbol("CANCÚN","OAXACA","R. DEL ATOYAC","08:00",R.drawable.playa,"JORNADA 2"));
        Partido.add(new Clase_futbol("TUXTEPEC","TEPIC","R. DEL ATOYAC","12:00",R.drawable.playa,"JORNADA 2"));
        Partido.add(new Clase_futbol("LAZARO CARDENAS","BOCA DEL RIO","R. DEL ATOYAC","13:00",R.drawable.playa,"JORNADA 2"));
        Partido.add(new Clase_futbol("TEHUACAN","TOLUCA","R. DEL ATOYAC","14:00",R.drawable.playa,"JORNADA 2"));
        Partido.add(new Clase_futbol("ZACATECAS","CD. GUZMÁN","R. DEL ATOYAC","15:00",R.drawable.playa,"JORNADA 2"));
        //JORNADA 3
        Partido.add(new Clase_futbol("ITSOEH","COATZACOALCOS","R. DEL ATOYAC","09:00",R.drawable.playa,"JORNADA 3"));
        Partido.add(new Clase_futbol("CD. MADERO","DURANGO","R. DEL ATOYAC","10:00",R.drawable.playa,"JORNADA 3"));
        Partido.add(new Clase_futbol("HERMOSILLO","OAXACA","R. DEL ATOYAC","08:00",R.drawable.playa,"JORNADA 3"));
        Partido.add(new Clase_futbol("COALCOMÁN","CANCÚN","R. DEL ATOYAC","11:00",R.drawable.playa,"JORNADA 3"));
        Partido.add(new Clase_futbol("TUXTEPEC","BOCA DEL RIO","R. DEL ATOYAC","12:00",R.drawable.playa,"JORNADA 3"));
        Partido.add(new Clase_futbol("TEPIC","LAZARO CÁRDENAS","R. DEL ATOYAC","13:00",R.drawable.playa,"JORNADA 3"));
        Partido.add(new Clase_futbol("TEHUACAN","CIUDAD GUZMAN","R. DEL ATOYAC","14:00",R.drawable.playa,"JORNADA 3"));
        Partido.add(new Clase_futbol("TOLUCA","ZACATECAS","R. DEL ATOYAC","15:00",R.drawable.playa,"JORNADA 3"));


    }

    private void PartidoView(){
        ArrayAdapter<Clase_futbol> adapter=new MyListAdapter();
        ListView list=(ListView) view.findViewById(R.id.listview);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Clase_futbol>{
        public MyListAdapter(){
            super(getActivity(), R.layout.item_view8,Partido);
        }

        public View getView (int position, View convertView, ViewGroup parent){
            Fragment_Voleibol_playa.ViewHolder holder = null;
            View itemView = convertView;
            if (itemView==null){
                itemView=getLayoutInflater().inflate(R.layout.item_view8, parent,false);

                holder = new Fragment_Voleibol_playa.ViewHolder();

                holder.imageView = (ImageView) itemView.findViewById(R.id.logo) ;
                holder.Equipo1=(TextView) itemView.findViewById(R.id.Equipo1) ;
                holder.Equipo2=(TextView) itemView.findViewById(R.id.Equipo2);
                holder.Sede=(TextView) itemView.findViewById(R.id.sede) ;
                holder.Horario=(TextView) itemView.findViewById(R.id.horario);
                holder.Jornada=(TextView) itemView.findViewById(R.id.jornada);
                itemView.setTag(holder);}

            else
                holder = (Fragment_Voleibol_playa.ViewHolder) itemView.getTag();

            Clase_futbol CurrentPartido= Partido.get(position);

            holder.imageView.setImageResource(CurrentPartido.getImagen());
            holder.Equipo1.setText(CurrentPartido.getEquipo1());
            holder.Equipo2.setText(CurrentPartido.getEquipo2());
            holder.Sede.setText(CurrentPartido.getSede());
            holder.Horario.setText(CurrentPartido.getHorario());
            holder.Jornada.setText(CurrentPartido.getJornada());

            return itemView;
        }

    }

    static class ViewHolder{
        ImageView imageView;
        TextView Equipo1;
        TextView Equipo2;
        TextView Sede;
        TextView Horario;
        TextView Jornada;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Partido.clear();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }




}
