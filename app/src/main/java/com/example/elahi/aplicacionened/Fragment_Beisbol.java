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


public class Fragment_Beisbol extends Fragment {

    View view;
    private List<Clase_futbol> Partido = new ArrayList<Clase_futbol>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =inflater.inflate(R.layout.fragment__beisbol, container, false);
        Partido();
        PartidoView();
        return view;
    }

    private void Partido(){
        //JORNADA1
        Partido.add(new Clase_futbol("PUEBLA","ATITALAQUIA","E. VASCON","09:00",R.drawable.baseball,"JORNADA 1"));
        Partido.add(new Clase_futbol("SALTILLO","MÉRIDA","E. VASCON","12:00",R.drawable.baseball,"JORNADA 1"));
        Partido.add(new Clase_futbol("COMALCALCO","HUATABAMPO","A. A. HARP","09:00",R.drawable.baseball,"JORNADA 1"));
        Partido.add(new Clase_futbol("URUAPAN","MAZATLAN","A. A. HARP","12:00",R.drawable.baseball,"JORNADA 1"));
        Partido.add(new Clase_futbol("NUEVO LAREDO","ISTMO","SN BARTOLO","09:00",R.drawable.baseball,"JORNADA 1"));
        Partido.add(new Clase_futbol("QUERÈTARO","VERACRUZ","SN BARTOLO","12:00",R.drawable.baseball,"JORNADA 1"));
        Partido.add(new Clase_futbol("OAXACA","AGUASCALIENTES","IT OAXACA","12:00",R.drawable.baseball,"JORNADA 1"));
        Partido.add(new Clase_futbol("PABELLON DE A.","CD. CUAUHTÉMOC","IT OAXACA","09:00",R.drawable.baseball,"JORNADA 1"));
        //JORNADA2
        Partido.add(new Clase_futbol("PUEBLA","MÉRIDA","E. VASCON","09:00",R.drawable.baseball,"JORNADA 2"));
        Partido.add(new Clase_futbol("ATITALAQUIA","SALTILLO","E. VASCON","12:00",R.drawable.baseball,"JORNADA 2"));
        Partido.add(new Clase_futbol("COMALCALCO","MAZATLÁN","A. A. HARP","09:00",R.drawable.baseball,"JORNADA 2"));
        Partido.add(new Clase_futbol("HUATABAMPO","URUAPAN","A. A. HARP","12:00",R.drawable.baseball,"JORNADA 2"));
        Partido.add(new Clase_futbol("NUEVO LAREDO","VERACRUZ","SN BARTOLO","09:00",R.drawable.baseball,"JORNADA 2"));
        Partido.add(new Clase_futbol("ISTMO","QUERÉTARO","SN BARTOLO","12:00",R.drawable.baseball,"JORNADA 2"));
        Partido.add(new Clase_futbol("OAXACA","PABELLON DE A.","IT OAXACA","12:00",R.drawable.baseball,"JORNADA 2"));
        Partido.add(new Clase_futbol("AGUASCALIENTES","CD. CUAUHTÉMOC","IT OAXACA","09:00",R.drawable.baseball,"JORNADA 2"));
        //JORNADA3
        Partido.add(new Clase_futbol("PUEBLA","SALTILLO","E. VASCON","09:00",R.drawable.baseball,"JORNADA 3"));
        Partido.add(new Clase_futbol("MÉRIDA","ATITALAQUIA","E. VASCON","12:00",R.drawable.baseball,"JORNADA 3"));
        Partido.add(new Clase_futbol("COMALCALCO","URUAPAN","A. A. HARP","09:00",R.drawable.baseball,"JORNADA 3"));
        Partido.add(new Clase_futbol("MAZATLÁN","HUATABAMPO","A. A. HARP","12:00",R.drawable.baseball,"JORNADA 3"));
        Partido.add(new Clase_futbol("NUEVO LAREDO","QUERÉTARO","SN BARTOLO","09:00",R.drawable.baseball,"JORNADA 3"));
        Partido.add(new Clase_futbol("VERACRUZ","ISTMO","SN BARTOLO","12:00",R.drawable.baseball,"JORNADA 3"));
        Partido.add(new Clase_futbol("OAXACA","CD. CUAUHTEMOC","IT OAXACA","12:00",R.drawable.baseball,"JORNADA 3"));
        Partido.add(new Clase_futbol("PABELLON DE A.","AGUASCALIENTES","IT OAXACA","09:00",R.drawable.baseball,"JORNADA 3"));
    }

    private void PartidoView(){
        ArrayAdapter<Clase_futbol> adapter=new MyListAdapter();
        ListView list=(ListView) view.findViewById(R.id.listview);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Clase_futbol>{
        public MyListAdapter(){
            super(getActivity(), R.layout.item_view4,Partido);
        }

        public View getView (int position, View convertView, ViewGroup parent){
            Fragment_Beisbol.ViewHolder holder = null;
            View itemView = convertView;
            if (itemView==null){
                itemView=getLayoutInflater().inflate(R.layout.item_view4, parent,false);

                holder = new Fragment_Beisbol.ViewHolder();

                holder.imageView = (ImageView) itemView.findViewById(R.id.logo) ;
                holder.Equipo1=(TextView) itemView.findViewById(R.id.Equipo1) ;
                holder.Equipo2=(TextView) itemView.findViewById(R.id.Equipo2);
                holder.Sede=(TextView) itemView.findViewById(R.id.sede) ;
                holder.Horario=(TextView) itemView.findViewById(R.id.horario);
                holder.Jornada=(TextView)itemView.findViewById((R.id.jornada));
                itemView.setTag(holder);}

            else
                holder = (Fragment_Beisbol.ViewHolder) itemView.getTag();

            Clase_futbol CurrentPartido = Partido.get(position);

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
