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
public class Fragment_Voleibol_femenil extends Fragment {
    private List<Clase_futbol> Partido = new ArrayList<Clase_futbol>();
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment__voleibol_femenil, container, false);
        PartidoView();
        return view;
    }

    /*private void Partido(){
        //JORNADA1
        Partido.add(new Clase_futbol("CIUDAD MADERO","CELAYA","IT OAXACA","09:00",R.drawable.volleyball,"JORNADA 1"));
        Partido.add(new Clase_futbol("PACHUCA","OAXACA","IT OAXACA","10:00",R.drawable.volleyball,"JORNADA 1"));
        Partido.add(new Clase_futbol("LA LAGUNA","PUEBLA","R.F. MAGÓN 1","09:00",R.drawable.volleyball,"JORNADA 1"));
        Partido.add(new Clase_futbol("COATZACOALCOS","CIUDAD GUZMAN","R.F. MAGÓN","10:00",R.drawable.volleyball,"JORNADA 1"));
        Partido.add(new Clase_futbol("QUERETARO","DURANGO","URSE","09:00",R.drawable.volleyball,"JORNADA 1"));
        Partido.add(new Clase_futbol("CANCUN","GUASAVE","URSE","10:00",R.drawable.volleyball,"JORNADA 1"));
        Partido.add(new Clase_futbol("CD. ALTAMIRANO","CUENCA DE P.","R.F. MAGÓN 3","09:00",R.drawable.volleyball,"JORNADA 1"));
        Partido.add(new Clase_futbol("TIJUANA","POZA RICA","R FLORES MAGÓN 3","10:00",R.drawable.volleyball,"JORNADA 1"));
        //JORNADA2
        Partido.add(new Clase_futbol("CIUDAD MADERO","OAXACA","IT OAXACA","10:00",R.drawable.volleyball,"JORNADA 2"));
        Partido.add(new Clase_futbol("CELAYA","PACHUCA","IT OAXACA","09:00",R.drawable.volleyball,"JORNADA 2"));
        Partido.add(new Clase_futbol("LA LAGUNA","CD. GUZMAN","R.F. MAGÓN","09:00",R.drawable.volleyball,"JORNADA 2"));
        Partido.add(new Clase_futbol("PUEBLA","COATZACOALCOS","R.F. MAGÓN","10:00",R.drawable.volleyball,"JORNADA 2"));
        Partido.add(new Clase_futbol("QUERETARO","GUASAVE","URSE","09:00",R.drawable.volleyball,"JORNADA 2"));
        Partido.add(new Clase_futbol("DURANGO","CANCÚN","URSE","10:00",R.drawable.volleyball,"JORNADA 2"));
        Partido.add(new Clase_futbol("CD. ALTAMIRANO","POZA RICA","R.F. MAGÓN 3","09:00",R.drawable.volleyball,"JORNADA 2"));
        Partido.add(new Clase_futbol("CUENCA DE P.","TIJUANA","R.F. MAGÓN 3","10:00",R.drawable.volleyball,"JORNADA 2"));
        //JORNADA3
        Partido.add(new Clase_futbol("CD. MADERO","PACHUCA","IT OAXACA","09:00",R.drawable.volleyball,"JORNADA 3"));
        Partido.add(new Clase_futbol("OAXACA","CELAYA","IT OAXACA","10:00",R.drawable.volleyball,"JORNADA 3"));
        Partido.add(new Clase_futbol("LA LAGUNA","COATZACOALCOS","R.F. MAGÓN 1","09:00",R.drawable.volleyball,"JORNADA 3"));
        Partido.add(new Clase_futbol("CD. GUZMÁN","PUEBLA","R.F. MAGÓN 1","10:00",R.drawable.volleyball,"JORNADA 3"));
        Partido.add(new Clase_futbol("QUERETARO","CANCÚN","URSE","09:00",R.drawable.volleyball,"JORNADA 3"));
        Partido.add(new Clase_futbol("GUASAVE","DURANGO","URSE","10:00",R.drawable.volleyball,"JORNADA 3"));
        Partido.add(new Clase_futbol("CD. ALTAMIRANO","TIJUANA","R.F. MAGÓN 3","09:00",R.drawable.volleyball,"JORNADA 3"));
        Partido.add(new Clase_futbol("POZA RICA","CUENCA DE P.","R.F. MAGÓN 3","10:00",R.drawable.volleyball,"JORNADA 3"));

    }*/

    private void PartidoView(){
        ArrayAdapter<Clase_futbol> adapter=new MyListAdapter();
        ListView list=(ListView) view.findViewById(R.id.listview);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Clase_futbol>{
        public MyListAdapter(){
            super(getActivity(), R.layout.item_view7,Partido);
        }

        public View getView (int position, View convertView, ViewGroup parent){
            Fragment_Voleibol_femenil.ViewHolder holder = null;
            View itemView = convertView;
            if (itemView==null){
                itemView=getLayoutInflater().inflate(R.layout.item_view7, parent,false);

                holder = new Fragment_Voleibol_femenil.ViewHolder();

                holder.imageView = (ImageView) itemView.findViewById(R.id.logo) ;
                holder.Equipo1=(TextView) itemView.findViewById(R.id.Equipo1) ;
                holder.Equipo2=(TextView) itemView.findViewById(R.id.Equipo2);
                holder.Sede=(TextView) itemView.findViewById(R.id.sede) ;
                holder.Horario=(TextView) itemView.findViewById(R.id.horario);
                holder.Jornada=(TextView) itemView.findViewById(R.id.jornada);
                holder.Res1=(TextView) itemView.findViewById(R.id.res_equipo1);
                holder.Res2=(TextView) itemView.findViewById(R.id.res_equipo2);
                itemView.setTag(holder);
            }

            else
                holder = (Fragment_Voleibol_femenil.ViewHolder) itemView.getTag();

            Clase_futbol CurrentPartido= Partido.get(position);

            holder.imageView.setImageResource(CurrentPartido.getImagen());
            holder.Equipo1.setText(CurrentPartido.getEquipo1());
            holder.Equipo2.setText(CurrentPartido.getEquipo2());
            holder.Sede.setText(CurrentPartido.getSede());
            holder.Horario.setText(CurrentPartido.getHorario());
            holder.Jornada.setText(CurrentPartido.getJornada());
            holder.Res1.setText(CurrentPartido.getRes1());
            holder.Res2.setText(CurrentPartido.getRes2());

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
        TextView Res1;
        TextView Res2;
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
