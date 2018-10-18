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
public class Fragment_futbol_femenil extends Fragment {
    private List<Clase_futbol> Partido=new ArrayList<Clase_futbol>();
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_noticias, container, false);
        //Partido();
        //PartidoView();
        return view;
    }

    private void Partido(){
        //JORNADA1
        Partido.add(new Clase_futbol("GUSTAVO A. MADERO","TIJUANA","LA SALLE","08:00",R.drawable.noticiafut,"JORNADA 1"));
        Partido.add(new Clase_futbol("AGUASCALIENTES","CIUDAD MADERO","LA SALLE","12:00",R.drawable.noticiafut,"JORNADA 1"));
        Partido.add(new Clase_futbol("CERRO AZUL","COATZACOALCOS","MRCI","08:00",R.drawable.noticiafut,"JORNADA 1"));
        Partido.add(new Clase_futbol("PUEBLA","ACAPULCO","MRCI","12:00",R.drawable.noticiafut,"JORNADA 1"));
        Partido.add(new Clase_futbol("NUEVO LAREDO","TEPIC","NAZARENO","08:00",R.drawable.noticiafut,"JORNADA 1"));
        Partido.add(new Clase_futbol("DURANGO","ISTMO","NAZARENO","12:00",R.drawable.noticiafut,"JORNADA 1"));
        Partido.add(new Clase_futbol("MERIDA","TLALNEPANTLA","IT OAXACA","12:00",R.drawable.noticiafut,"JORNADA 1"));
        Partido.add(new Clase_futbol("OAXACA","LEÓN","IT OAXACA","08:00",R.drawable.noticiafut,"JORNADA 1"));
        //JORNADA2
        Partido.add(new Clase_futbol("GUSTAVO A. MADERO","CD. MADERO","LA SALLE","08:00",R.drawable.noticiafut,"JORNADA 2"));
        Partido.add(new Clase_futbol("TIJUANA","AGUASCALIENTES","LA SALLE","12:00",R.drawable.noticiafut,"JORNADA 2"));
        Partido.add(new Clase_futbol("CERRO AZUL","ACAPULCO","MRCI","08:00",R.drawable.noticiafut,"JORNADA 2"));
        Partido.add(new Clase_futbol("COATZACOALCOS","PUEBLA","MRCI","12:00",R.drawable.noticiafut,"JORNADA 2"));
        Partido.add(new Clase_futbol("NUEVO LAREDO","ISTMO","NAZARENO","08:00",R.drawable.noticiafut,"JORNADA 2"));
        Partido.add(new Clase_futbol("TEPIC","DURANGO","NAZARENO","12:00",R.drawable.noticiafut,"JORNADA 2"));
        Partido.add(new Clase_futbol("MERIDA","LEÓN","IT OAXACA","12:00",R.drawable.noticiafut,"JORNADA 2"));
        Partido.add(new Clase_futbol("TLALNEPANTLA","OAXACA","IT OAXACA","08:00",R.drawable.noticiafut,"JORNADA 2"));
        //JORNADA3
        Partido.add(new Clase_futbol("GUSTAVO A. MADERO","AGUASCALIENTES","LA SALLE","08:00",R.drawable.noticiafut,"JORNADA 3"));
        Partido.add(new Clase_futbol("CD. MADERO","TIJUANA","LA SALLE","12:00",R.drawable.noticiafut,"JORNADA 3"));
        Partido.add(new Clase_futbol("CERRO AZUL","PUEBLA","MRCI","08:00",R.drawable.noticiafut,"JORNADA 3"));
        Partido.add(new Clase_futbol("ACAPULCO","COATZACOALCOS","MRCI","12:00",R.drawable.noticiafut,"JORNADA 3"));
        Partido.add(new Clase_futbol("NUEVO LAREDO","DURANGO","NAZARENO","08:00",R.drawable.noticiafut,"JORNADA 3"));
        Partido.add(new Clase_futbol("ISTMO","TEPIC","NAZARENO","12:00",R.drawable.noticiafut,"JORNADA 3"));
        Partido.add(new Clase_futbol("MÉRIDA","OAXACA","IT OAXACA","08:00",R.drawable.noticiafut,"JORNADA 3"));
        Partido.add(new Clase_futbol("LEÓN","TLALNEPANTLA","IT OAXACA","12:00",R.drawable.noticiafut,"JORNADA 3"));

    }

    private void PartidoView(){
        ArrayAdapter<Clase_futbol>adapter=new MyListAdapter();
        ListView list=(ListView) view.findViewById(R.id.listview);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Clase_futbol>{
        public MyListAdapter(){
            super(getActivity(), R.layout.item_view5,Partido);
        }

        public View getView (int position, View convertView, ViewGroup parent){
            Fragment_futbol_femenil.ViewHolder holder = null;
            View itemView = convertView;
            if (itemView==null){
                itemView=getLayoutInflater().inflate(R.layout.item_view5, parent,false);

                holder = new Fragment_futbol_femenil.ViewHolder();

                holder.imageView = (ImageView) itemView.findViewById(R.id.logo) ;
                holder.Equipo1=(TextView) itemView.findViewById(R.id.Equipo1) ;
                holder.Equipo2=(TextView) itemView.findViewById(R.id.Equipo2);
                holder.Sede=(TextView) itemView.findViewById(R.id.sede) ;
                holder.Horario=(TextView) itemView.findViewById(R.id.horario);
                holder.Jornada=(TextView) itemView.findViewById(R.id.jornada);
                itemView.setTag(holder);}

            else
                holder = (Fragment_futbol_femenil.ViewHolder) itemView.getTag();

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
/*
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
*/

}
