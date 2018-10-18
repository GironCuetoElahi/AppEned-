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
public class Fragment_Voleibol_playa_Femenil extends Fragment {
    private List<Clase_futbol> Partido=new ArrayList<Clase_futbol>();
    View view;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment__voleibol_playa__femenil, container, false);
        Partido();
        PartidoView();
        return view;
    }

    private void Partido(){
        //JORNADA 1
        Partido.add(new Clase_futbol("TAPACHULA","ZACATECAS","LA SALLE","08:00",R.drawable.playa,"JORNADA 1"));
        Partido.add(new Clase_futbol("DURANGO","ENSENADA","LA SALLE","09:00",R.drawable.playa,"JORNADA 1"));
        Partido.add(new Clase_futbol("CD MADERO","MERIDA","LA SALLE","10:00",R.drawable.playa,"JORNADA 1"));
        Partido.add(new Clase_futbol("4","LEON","LA SALLE","11:00",R.drawable.playa,"JORNADA 1"));
        Partido.add(new Clase_futbol("TEPIC","HERMOSILLO","LA SALLE","12:00",R.drawable.playa,"JORNADA 1"));
        Partido.add(new Clase_futbol("CIUDAD HIDALGO","ORIZABA","LA SALLE","13:00",R.drawable.playa,"JORNADA 1"));
        Partido.add(new Clase_futbol("PROGRESO","COSTA GRANDE","LA SALLE","14:00",R.drawable.playa,"JORNADA 1"));
        Partido.add(new Clase_futbol("HUICHAPAN","MORELIA","LA SALLE","15:00",R.drawable.playa,"JORNADA 1"));
        //JORNADA 2
        Partido.add(new Clase_futbol("TAPACHULA","ENSENADA","LA SALLE","08:00",R.drawable.playa,"JORNADA 2"));
        Partido.add(new Clase_futbol("ZACATECAS","DURANGO","LA SALLE","09:00",R.drawable.playa,"JORNADA 2"));
        Partido.add(new Clase_futbol("CD MADERO","LEÓN","LA SALLE","10:00",R.drawable.playa,"JORNADA 2"));
        Partido.add(new Clase_futbol("MÉRIDA","4","LA SALLE","11:00",R.drawable.playa,"JORNADA 2"));
        Partido.add(new Clase_futbol("TEPIC","ORIZABA","LA SALLE","12:00",R.drawable.playa,"JORNADA 2"));
        Partido.add(new Clase_futbol("HERMOSILLO","CD HIDALGO","LA SALLE","13:00",R.drawable.playa,"JORNADA 2"));
        Partido.add(new Clase_futbol("PROGRESO","MORELIA","LA SALLE","14:00",R.drawable.playa,"JORNADA 2"));
        Partido.add(new Clase_futbol("COSTA GRANDE","HUICHAPAN","LA SALLE","15:00",R.drawable.playa,"JORNADA 2"));
        //JORNADAS 3
        Partido.add(new Clase_futbol("TAPACHULA","DURANGO","LA SALLE","08:00",R.drawable.playa,"JORNADA 3"));
        Partido.add(new Clase_futbol("ENSENADA","ZACATECAS","LA SALLE","09:00",R.drawable.playa,"JORNADA 3"));
        Partido.add(new Clase_futbol("CD MADERO","4","LA SALLE","10:00",R.drawable.playa,"JORNADA 3"));
        Partido.add(new Clase_futbol("LEÓN","MÉRIDA","LA SALLE","11:00",R.drawable.playa,"JORNADA 3"));
        Partido.add(new Clase_futbol("TEPIC","CD HIDALGO","LA SALLE","12:00",R.drawable.playa,"JORNADA 3"));
        Partido.add(new Clase_futbol("ORIZABA","HERMOSILLO","LA SALLE","13:00",R.drawable.playa,"JORNADA 3"));
        Partido.add(new Clase_futbol("PROGRESO","HUICHAPAN","LA SALLE","14:00",R.drawable.playa,"JORNADA 3"));
        Partido.add(new Clase_futbol("MORELIA","COSTA GRANDE","LA SALLE","15:00",R.drawable.playa,"JORNADA 3"));

    }

    private void PartidoView(){
        ArrayAdapter<Clase_futbol> adapter=new MyListAdapter();
        ListView list=(ListView) view.findViewById(R.id.listview);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Clase_futbol>{
        public MyListAdapter(){
            super(getActivity(), R.layout.item_view9,Partido);
        }

        public View getView (int position, View convertView, ViewGroup parent){
            Fragment_Voleibol_playa_Femenil.ViewHolder holder = null;
            View itemView = convertView;
            if (itemView==null){
                itemView=getLayoutInflater().inflate(R.layout.item_view9, parent,false);

                holder = new Fragment_Voleibol_playa_Femenil.ViewHolder();

                holder.imageView = (ImageView) itemView.findViewById(R.id.logo) ;
                holder.Equipo1=(TextView) itemView.findViewById(R.id.Equipo1) ;
                holder.Equipo2=(TextView) itemView.findViewById(R.id.Equipo2);
                holder.Sede=(TextView) itemView.findViewById(R.id.sede) ;
                holder.Horario=(TextView) itemView.findViewById(R.id.horario);
                holder.Jornada=(TextView) itemView.findViewById(R.id.jornada);
                itemView.setTag(holder);}

            else
                holder = (Fragment_Voleibol_playa_Femenil.ViewHolder) itemView.getTag();

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
