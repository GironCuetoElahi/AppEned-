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
public class Fragment_Softbol extends Fragment {
    private List<Clase_futbol> Partido=new ArrayList<Clase_futbol>();
        View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment__ajedrez, container, false);
        Partido();
        PartidoView();
        return view;
    }

    private void Partido(){
        //JORNADA1
        Partido.add(new Clase_futbol("MERIDA","MEXICALI","LA SALLE","09:00",R.drawable.softbal,"JORNADA 1"));
        Partido.add(new Clase_futbol("PUEBLA","POZA RICA","LA SALLE","12:00",R.drawable.softbal,"JORNADA 1"));

        //JORNADA2
        Partido.add(new Clase_futbol("MERIDA","POZA RICA","LA SALLE","09:00",R.drawable.softbal,"JORNADA 2"));
        Partido.add(new Clase_futbol("MEXICALI","PUEBLA","LA SALLE","12:00",R.drawable.softbal,"JORNADA 2"));

        //JORNADA3
        Partido.add(new Clase_futbol("MERIDA","PUEBLA","LA SALLE","09:00",R.drawable.softbal,"JORNADA 3"));
        Partido.add(new Clase_futbol("POZA RICA","MEXICALI","LA SALLE","12:00",R.drawable.softbal,"JORNADA 3"));


    }

    private void PartidoView(){
        ArrayAdapter<Clase_futbol> adapter=new MyListAdapter();
        ListView list=(ListView) view.findViewById(R.id.listview);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Clase_futbol>{
        public MyListAdapter(){
            super(getActivity(), R.layout.item_view_softbol,Partido);
        }

        public View getView (int position, View convertView, ViewGroup parent){
            Fragment_Softbol.ViewHolder holder = null;
            View itemView = convertView;
            if (itemView==null){
                itemView=getLayoutInflater().inflate(R.layout.item_view_softbol, parent,false);

                holder = new Fragment_Softbol.ViewHolder();

                holder.imageView = (ImageView) itemView.findViewById(R.id.logo) ;
                holder.Equipo1=(TextView) itemView.findViewById(R.id.Equipo1) ;
                holder.Equipo2=(TextView) itemView.findViewById(R.id.Equipo2);
                holder.Horario=(TextView) itemView.findViewById(R.id.horario);
                holder.Jornada=(TextView) itemView.findViewById(R.id.jornada);
                itemView.setTag(holder);}

            else
                holder = (Fragment_Softbol.ViewHolder) itemView.getTag();

            Clase_futbol CurrentPartido= Partido.get(position);

            holder.imageView.setImageResource(CurrentPartido.getImagen());
            holder.Equipo1.setText(CurrentPartido.getEquipo1());
            holder.Equipo2.setText(CurrentPartido.getEquipo2());
            holder.Horario.setText(CurrentPartido.getHorario());
            holder.Jornada.setText(CurrentPartido.getJornada());

            return itemView;
        }

    }

    static class ViewHolder{
        ImageView imageView;
        TextView Equipo1;
        TextView Equipo2;
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
        Partido.clear();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Partido.clear();
    }

}
