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
public class Fragment_Basquetbol_femenil extends Fragment {
    private List<Clase_futbol> Partido=new ArrayList<Clase_futbol>();
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view = inflater.inflate(R.layout.fragment__basquetbol_femenil, container, false);
       Partido();
       PartidoView();
       return view;
    }

    private void Partido(){
        //JORNADA1
        Partido.add(new Clase_futbol("CHILPANCINGO","TIJUANA","CRENO","14:00",R.drawable.basketball,"JORNADA 1"));
        Partido.add(new Clase_futbol("CD HIDALGO","TLALNEPANTLA","CRENO","18:00",R.drawable.basketball,"JORNADA 1"));
        Partido.add(new Clase_futbol("TLAXIACO","POZA RICA","URSE","14:00",R.drawable.basketball,"JORNADA 1"));
        Partido.add(new Clase_futbol("ORIZABA","LOS MOCHIS","URSE","18:00",R.drawable.basketball,"JORNADA 1"));
        Partido.add(new Clase_futbol("SAN LUIS P.","CHIHUAHUA","R F MAGÓN","14:00",R.drawable.basketball,"JORNADA 1"));
        Partido.add(new Clase_futbol("MERIDA","TUXTLA GTZ","R F MAGÓN","18:00",R.drawable.basketball,"JORNADA 1"));
        Partido.add(new Clase_futbol("LA LAGUNA","OAXACA","IT OAXACA","14:00",R.drawable.basketball,"JORNADA 1"));
        Partido.add(new Clase_futbol("GUANAJUATO","CELAYA","IT OAXACA","18:00",R.drawable.basketball,"JORNADA 1"));
        //JORNADA2
        Partido.add(new Clase_futbol("CHILPANCINGO","TLALNEPANTLA","CRENO","14:00",R.drawable.basketball,"JORNADA 2"));
        Partido.add(new Clase_futbol("TIJUANA","CD. HIDALGO","CRENO","18:00",R.drawable.basketball,"JORNADA 2"));
        Partido.add(new Clase_futbol("TLAXIACO","LOS MOCHIS","URSE","14:00",R.drawable.basketball,"JORNADA 2"));
        Partido.add(new Clase_futbol("POZA RICA","ORIZABA","URSE","18:00",R.drawable.basketball,"JORNADA 2"));
        Partido.add(new Clase_futbol("SAN LUIS P.","TUXTLA GTZ.","R F MAGÓN","14:00",R.drawable.basketball,"JORNADA 2"));
        Partido.add(new Clase_futbol("CHIHUAHUA","MÉRIDA","R F MAGÓN","18:00",R.drawable.basketball,"JORNADA 2"));
        Partido.add(new Clase_futbol("CELAYA","LA LAGUNA","IT OAXACA","18:00",R.drawable.basketball,"JORNADA 2"));
        Partido.add(new Clase_futbol("OAXACA","GUANAJUATO","IT OAXACA","14:00",R.drawable.basketball,"JORNADA 2"));
        //JORNADA3
        Partido.add(new Clase_futbol("CHILPANCINGO","CD. HIDALGO","CRENO","14:00",R.drawable.basketball,"JORNADA 3"));
        Partido.add(new Clase_futbol("TLALNEPANTLA","TIJUANA","CRENO","18:00",R.drawable.basketball,"JORNADA 3"));
        Partido.add(new Clase_futbol("TLAXIACO","ORIZABA","URSE","14:00",R.drawable.basketball,"JORNADA 3"));
        Partido.add(new Clase_futbol("LOS MOCHIS","POZA RICA","URSE","18:00",R.drawable.basketball,"JORNADA 3"));
        Partido.add(new Clase_futbol("SAN LUIS P.","MÉRIDA","R F MAGÓN","14:00",R.drawable.basketball,"JORNADA 3"));
        Partido.add(new Clase_futbol("TUXTLA GTZ","CHIHUAHUA","R F MAGÓN","18:00",R.drawable.basketball,"JORNADA 3"));
        Partido.add(new Clase_futbol("CELAYA","OAXACA","IT OAXACA","14:00",R.drawable.basketball,"JORNADA 3"));
        Partido.add(new Clase_futbol("LA LAGUNA","GUANAJUATO","IT OAXACA","18:00",R.drawable.basketball,"JORNADA 3"));
    }

    private void PartidoView(){
        ArrayAdapter<Clase_futbol> adapter=new MyListAdapter();
        ListView list=(ListView) view.findViewById(R.id.listview);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Clase_futbol>{
        public MyListAdapter(){
            super(getActivity(), R.layout.item_view3,Partido);
        }

        public View getView (int position, View convertView, ViewGroup parent){
            Fragment_Basquetbol_femenil.ViewHolder holder = null;
            View itemView = convertView;
            if (itemView==null){
                itemView=getLayoutInflater().inflate(R.layout.item_view3, parent,false);

                holder = new Fragment_Basquetbol_femenil.ViewHolder();

                holder.imageView = (ImageView) itemView.findViewById(R.id.logo) ;
                holder.Equipo1=(TextView) itemView.findViewById(R.id.Equipo1) ;
                holder.Equipo2=(TextView) itemView.findViewById(R.id.Equipo2);
                holder.Sede=(TextView) itemView.findViewById(R.id.sede) ;
                holder.Horario=(TextView) itemView.findViewById(R.id.horario);
                holder.Jornada=(TextView)  itemView.findViewById(R.id.jornada);
                itemView.setTag(holder);}

            else
                holder = (Fragment_Basquetbol_femenil.ViewHolder) itemView.getTag();

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
