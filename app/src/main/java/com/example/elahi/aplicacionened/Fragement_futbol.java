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



public class Fragement_futbol extends Fragment {
        private List<Clase_futbol> Partido=new ArrayList<Clase_futbol>();
        View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragement_futbol, container, false);
        Partido();
        PartidoView();
        return view;
    }

    private void Partido(){
        //JORNADA1
        Partido.add(new Clase_futbol("CELAYA","TEPIC","LA SALLE","10:00",R.drawable.futbol,"JORNADA 1"));
        Partido.add(new Clase_futbol("CD GUZMAN","COMALCALCO","LA SALLE","14:00",R.drawable.futbol,"JORNADA 1"));
        Partido.add(new Clase_futbol("TLALNEPANTLA","VERACRUZ","NAZARENO","10:00",R.drawable.futbol,"JORNADA 1"));
        Partido.add(new Clase_futbol("LA LAGUNA","TOLUCA","NAZARENO","14:00",R.drawable.futbol,"JORNADA 1"));
        Partido.add(new Clase_futbol("HUATABUAMPO","SIERRA NTE PUEBLA","MRCI","10:00",R.drawable.futbol,"JORNADA 1"));
        Partido.add(new Clase_futbol("TUXTEPEC","DURANGO","MRCI","14:00",R.drawable.futbol,"JORNADA 1"));
        Partido.add(new Clase_futbol("MERIDA","MATEHUALA","IT OAXACA","14:00",R.drawable.futbol,"JORNADA 1"));
        Partido.add(new Clase_futbol("CUAUTLA","OAXACA","IT OAXACA","10:00",R.drawable.futbol,"JORNADA 1"));
        //JORNADA2
        Partido.add(new Clase_futbol("CELAYA","COMALCALCO","LA SALLE","10:00",R.drawable.futbol,"JORNADA 2"));
        Partido.add(new Clase_futbol("TEPIC","CD. GUZMAN","LA SALLE","14:00",R.drawable.futbol,"JORNADA 2"));
        Partido.add(new Clase_futbol("TLALNEPANTLA","TOLUCA","NAZARENO","10:00",R.drawable.futbol,"JORNADA 2"));
        Partido.add(new Clase_futbol("VERACRUZ","LA LAGUNA","NAZARENO","14:00",R.drawable.futbol,"JORNADA 2"));
        Partido.add(new Clase_futbol("HUATABUAMPO","DURANGO","MRCI","10:00",R.drawable.futbol,"JORNADA 2"));
        Partido.add(new Clase_futbol("SIERRA NTE PUEBLA","TUXTEPEC","MRCI","14:00",R.drawable.futbol,"JORNADA 2"));
        Partido.add(new Clase_futbol("MERIDA","OAXACA","IT OAXACA","14:00",R.drawable.futbol,"JORNADA 2"));
        Partido.add(new Clase_futbol("MATEHUALA","CUAUTLA","IT OAXACA","14:00",R.drawable.futbol,"JORNADA 2"));
        //JORNADA3
        Partido.add(new Clase_futbol("CELAYA","CD. GUZMAN","LA SALLE","10:00",R.drawable.futbol,"JORNADA 3"));
        Partido.add(new Clase_futbol("COMALCALCO","TEPIC","LA SALLE","14:00",R.drawable.futbol,"JORNADA 3"));
        Partido.add(new Clase_futbol("TLALNEPANTLA","LA LAGUNA","NAZARENO","10:00",R.drawable.futbol,"JORNADA 3"));
        Partido.add(new Clase_futbol("TOLUCA","VERACRUZ","NAZARENO","14:00",R.drawable.futbol,"JORNADA 3"));
        Partido.add(new Clase_futbol("HUATABUAMPO","TUXTEPEC","MRCI","10:00",R.drawable.futbol,"JORNADA 3"));
        Partido.add(new Clase_futbol("DURANGO","SIERRA NTE PUEBLA","MRCI","14:00",R.drawable.futbol,"JORNADA 3"));
        Partido.add(new Clase_futbol("CUAUTLA","MÉRIDA","IT OAXACA","14:00",R.drawable.futbol,"JORNADA 3"));
        Partido.add(new Clase_futbol("OAXACA","MATEHUALA","IT OAXACA","10:00",R.drawable.futbol,"JORNADA 3"));

    }

     private void PartidoView(){
        ArrayAdapter<Clase_futbol>adapter=new MyListAdapter();
         ListView list=(ListView) view.findViewById(R.id.listview);
         list.setAdapter(adapter);
     }

    private class MyListAdapter extends ArrayAdapter<Clase_futbol>{
        public MyListAdapter(){
            super(getActivity(), R.layout.item_view,Partido);
        }

        public View getView (int position, View convertView, ViewGroup parent){
            ViewHolder holder = null;
            View itemView = convertView;
            if (itemView==null){
                itemView=getLayoutInflater().inflate(R.layout.item_view, parent,false);

            holder = new ViewHolder();

            holder.imageView = (ImageView) itemView.findViewById(R.id.logo) ;
            holder.Equipo1=(TextView) itemView.findViewById(R.id.Equipo1) ;
            holder.Equipo2=(TextView) itemView.findViewById(R.id.Equipo2);
            holder.Sede=(TextView) itemView.findViewById(R.id.sede) ;
            holder.Horario=(TextView) itemView.findViewById(R.id.horario);
            holder.Jornada=(TextView) itemView.findViewById(R.id.jornada);
            itemView.setTag(holder);}

            else
                holder = (ViewHolder) itemView.getTag();

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
/*
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
*/

}
