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



public class Fragment_Voleibol extends Fragment {
    private List<Clase_futbol> Partido = new ArrayList<Clase_futbol>();
        View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =inflater.inflate(R.layout.fragment__voleibol, container, false);
        Partido();
        PartidoView();
        return view;
    }

    private void Partido(){
        //JORNADA1
        Partido.add(new Clase_futbol("CIUDAD ALTAMIRANO","TUXTLA GTZ","LA SALLE","11:00",R.drawable.volleyball,"JORNADA 1"));
        Partido.add(new Clase_futbol("CD. GUZMÁN","MERIDA","LA SALLE","12:00",R.drawable.volleyball,"JORNADA 1"));
        Partido.add(new Clase_futbol("PACHUCA","LA LAGUNA","URSE","11:00",R.drawable.volleyball,"JORNADA 1"));
        Partido.add(new Clase_futbol("TIERRA BLANCA","CULIACAN","URSE","12:00",R.drawable.volleyball,"JORNADA 1"));
        Partido.add(new Clase_futbol("CHIHUAHUA","TIJUANA","UABJO","11:00",R.drawable.volleyball,"JORNADA 1"));
        Partido.add(new Clase_futbol("SAN LUIS P.","ISTMO","UABJO","12:00",R.drawable.volleyball,"JORNADA 1"));
        Partido.add(new Clase_futbol("OAXACA","APATZINGÁN","IT OAXACA","11:00",R.drawable.volleyball,"JORNADA 1"));
        Partido.add(new Clase_futbol("PUEBLA","QUERETARO","IT OAXACA","12:00",R.drawable.volleyball,"JORNADA 1"));
        //JORNADA2
        Partido.add(new Clase_futbol("CIUDAD ALTAMIRANO","MÉRIDA","LA SALLE","11:00",R.drawable.volleyball,"JORNADA 2"));
        Partido.add(new Clase_futbol("TUXTLA GTZ.","CD. GUZMAN","LA SALLE","12:00",R.drawable.volleyball,"JORNADA 2"));
        Partido.add(new Clase_futbol("PACHUCA","CULICÁN","URSE","11:00",R.drawable.volleyball,"JORNADA 2"));
        Partido.add(new Clase_futbol("LA LAGUNA","TIERRA BLANCA","URSE","12:00",R.drawable.volleyball,"JORNADA 2"));
        Partido.add(new Clase_futbol("CHIHUAHUA","ISTMO","UABJO","11:00",R.drawable.volleyball,"JORNADA 2"));
        Partido.add(new Clase_futbol("TIJUANA","SAN LUIS P.","UABJO","12:00",R.drawable.volleyball,"JORNADA 2"));
        Partido.add(new Clase_futbol("OAXACA","QUERÉTARO","IT OAXACA","11:00",R.drawable.volleyball,"JORNADA 2"));
        Partido.add(new Clase_futbol("APATZINGÁN","PUEBLA","IT OAXACA","12:00",R.drawable.volleyball,"JORNADA 2"));
        //JORNADA3
        Partido.add(new Clase_futbol("CIUDAD ALTAMIRANO","CIUDAD GUZMÁN","LA SALLE","11:00",R.drawable.volleyball,"JORNADA 3"));
        Partido.add(new Clase_futbol("MÉRIDA","TUXTLA GTZ.","LA SALLE","12:00",R.drawable.volleyball,"JORNADA 3"));
        Partido.add(new Clase_futbol("PACHUCA","TIERRA BLANCA","URSE","11:00",R.drawable.volleyball,"JORNADA 3"));
        Partido.add(new Clase_futbol("CULIACÁN","LA LAGUNA","URSE","12:00",R.drawable.volleyball,"JORNADA 3"));
        Partido.add(new Clase_futbol("CHIHUAHUA","SAN LUIS P.","UABJO","11:00",R.drawable.volleyball,"JORNADA 3"));
        Partido.add(new Clase_futbol("ISTMO","TIJUANA","UABJO","12:00",R.drawable.volleyball,"JORNADA 3"));
        Partido.add(new Clase_futbol("OAXACA","PUEBLA","IT OAXACA","11:00",R.drawable.volleyball,"JORNADA 3"));
        Partido.add(new Clase_futbol("QUERETARO","APATZINGÁN","IT OAXACA","12:00",R.drawable.volleyball,"JORNADA 3"));

    }

    private void PartidoView(){
        ArrayAdapter<Clase_futbol> adapter=new MyListAdapter();
        ListView list=(ListView) view.findViewById(R.id.listview);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Clase_futbol>{
        public MyListAdapter(){
            super(getActivity(), R.layout.item_view6,Partido);
        }

        public View getView (int position, View convertView, ViewGroup parent){
            Fragment_Voleibol.ViewHolder holder = null;
            View itemView = convertView;
            if (itemView==null){
                itemView=getLayoutInflater().inflate(R.layout.item_view6, parent,false);

                holder = new Fragment_Voleibol.ViewHolder();

                holder.imageView = (ImageView) itemView.findViewById(R.id.logo) ;
                holder.Equipo1=(TextView) itemView.findViewById(R.id.Equipo1) ;
                holder.Equipo2=(TextView) itemView.findViewById(R.id.Equipo2);
                holder.Sede=(TextView) itemView.findViewById(R.id.sede) ;
                holder.Horario=(TextView) itemView.findViewById(R.id.horario);
                holder.Jornada=(TextView) itemView.findViewById(R.id.jornada);
                itemView.setTag(holder);
            }

            else
                holder = (Fragment_Voleibol.ViewHolder) itemView.getTag();

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
