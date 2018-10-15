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



public class Fragment_Basquetbol extends Fragment {
    private List<Clase_futbol> Partido = new ArrayList<Clase_futbol>();
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fragment__basquetbol, container, false);
        Partido();
        PartidoView();
        return view;
    }

    private void Partido(){
        //JORNADA1
        Partido.add(new Clase_futbol("TUXTEPEC","OAXACA","IT OAXACA","16:00",R.drawable.basket,"JORNADA 1"));
        Partido.add(new Clase_futbol("NUEVO LAREDO","ORIENTE EDO HGO","IT OAXACA","20:00",R.drawable.basket,"JORNADA 1"));
        Partido.add(new Clase_futbol("CD. GUZMAN","TUXTLA GTZ","LA SALLE","16:00",R.drawable.basket,"JORNADA 1"));
        Partido.add(new Clase_futbol("CD. MADERO","NOGALES","LA SALLE","20:00",R.drawable.basket,"JORNADA 1"));
        Partido.add(new Clase_futbol("CD. CUAUTHÉMOC","CANCÚN","UABJO","16:00",R.drawable.basket,"JORNADA 1"));
        Partido.add(new Clase_futbol("TEPIC","VERACRUZ","UABJO","20:00",R.drawable.basket,"JORNADA 1"));
        Partido.add(new Clase_futbol("TACÁMBARO","URUAPAN","URSE","16:00",R.drawable.basket,"JORNADA 1"));
        Partido.add(new Clase_futbol("PUEBLA","TOLUCA","URSE","20:00",R.drawable.basket,"JORNADA 1"));
        //JORNADA2
        Partido.add(new Clase_futbol("TUXTEPEC","ORIENTE EDO HGO","IT OAXACA","20:00",R.drawable.basket,"JORNADA 2"));
        Partido.add(new Clase_futbol("NUEVO LAREDO","OAXACA","IT OAXACA","16:00",R.drawable.basket,"JORNADA 2"));
        Partido.add(new Clase_futbol("CD. GUZMAN","NOGALES","LA SALLE","16:00",R.drawable.basket,"JORNADA 2"));
        Partido.add(new Clase_futbol("TUXTLA GTZ.","CD. MADERO","LA SALLE","20:00",R.drawable.basket,"JORNADA 2"));
        Partido.add(new Clase_futbol("CD. CUAUTHÉMOC","VERACRUZ","UABJO","16:00",R.drawable.basket,"JORNADA 2"));
        Partido.add(new Clase_futbol("CANCÚN","TEPIC","UABJO","20:00",R.drawable.basket,"JORNADA 2"));
        Partido.add(new Clase_futbol("TACÁMBARO","TOLUCA","URSE","16:00",R.drawable.basket,"JORNADA 2"));
        Partido.add(new Clase_futbol("URUAPAN","PUEBLA","URSE","20:00",R.drawable.basket,"JORNADA 2"));
        //JORNADA3
        Partido.add(new Clase_futbol("TUXTEPEC","NUEVO LAREDO","IT OAXACA","20:00",R.drawable.basket,"JORNADA 3"));
        Partido.add(new Clase_futbol("ORIENTE EDO HGO","OAXACA","IT OAXACA","16:00",R.drawable.basket,"JORNADA "));
        Partido.add(new Clase_futbol("CD. GUZMAN","CD. MADERO","LA SALLE","16:00",R.drawable.basket,"JORNADA 3"));
        Partido.add(new Clase_futbol("NOGALES","TUXTLA GTZ.","LA SALLE","20:00",R.drawable.basket,"JORNADA 3"));
        Partido.add(new Clase_futbol("CD. CUAUTHÉMOC","TEPIC","UABJO","16:00",R.drawable.basket,"JORNADA 3"));
        Partido.add(new Clase_futbol("VERACRUZ","CANCÚN","UABJO","20:00",R.drawable.basket,"JORNADA 3"));
        Partido.add(new Clase_futbol("TACÁMBARO","PUEBLA","URSE","16:00",R.drawable.basket,"JORNADA 3"));
        Partido.add(new Clase_futbol("TOLUCA","URUAPAN","URSE","20:00",R.drawable.basket,"JORNADA 3"));
    }

    private void PartidoView(){
        ArrayAdapter<Clase_futbol> adapter=new MyListAdapter();
        ListView list=(ListView) view.findViewById(R.id.listview);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Clase_futbol>{
        public MyListAdapter(){
            super(getActivity(), R.layout.item_view,Partido);
        }

        public View getView (int position, View convertView, ViewGroup parent){
            Fragment_Basquetbol.ViewHolder holder = null;
            View itemView = convertView;
            if (itemView==null){
                itemView=getLayoutInflater().inflate(R.layout.item_view, parent,false);

                holder = new Fragment_Basquetbol.ViewHolder();

                holder.imageView = (ImageView) itemView.findViewById(R.id.logo) ;
                holder.Equipo1=(TextView) itemView.findViewById(R.id.Equipo1) ;
                holder.Equipo2=(TextView) itemView.findViewById(R.id.Equipo2);
                holder.Sede=(TextView) itemView.findViewById(R.id.sede) ;
                holder.Horario=(TextView) itemView.findViewById(R.id.horario);
                holder.Jornada=(TextView) itemView.findViewById(R.id.jornada);
                itemView.setTag(holder);}

            else
                holder = (Fragment_Basquetbol.ViewHolder) itemView.getTag();

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
