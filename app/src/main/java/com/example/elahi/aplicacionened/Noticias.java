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
public class Noticias extends Fragment {
    private List<Clase_noticia> Noticia=new ArrayList<Clase_noticia>();
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_noticias, container, false);
        Noticia();
        NoticiaView();
        return view;

    }


    private void  Noticia(){
        //JORNADA1
        Noticia.add(new Clase_noticia ("OAXACA GOLEA A PACHUCA","El ITO golea al Instituto Tecnologico de Pachuca tras anotar 6 goles en el partido realizado en Nazareno",R.drawable.noticiafut));

    }

    private void NoticiaView(){
        ArrayAdapter<Clase_noticia> adapter=new MyListAdapter();
        ListView list=(ListView) view.findViewById(R.id.listview);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Clase_noticia>{
        public MyListAdapter(){
            super(getActivity(), R.layout.item_view_noticias, Noticia);
        }

        public View getView (int position, View convertView, ViewGroup parent){
            ViewHolder holder = null;
            View itemView = convertView;
            if (itemView==null){
                itemView=getLayoutInflater().inflate(R.layout.item_view_noticias, parent,false);

                holder = new ViewHolder();

                holder.imageView = (ImageView) itemView.findViewById(R.id.logo) ;
                holder.Texto=(TextView) itemView.findViewById(R.id.fecha) ;
                holder.Encabezado=(TextView) itemView.findViewById(R.id.textView);

                itemView.setTag(holder);}

            else
                holder = (ViewHolder) itemView.getTag();

            Clase_noticia CurrentPartido= Noticia.get(position);

            holder.imageView.setImageResource(CurrentPartido.getImagen());
            holder.Texto.setText(CurrentPartido.getTexto());
            holder.Encabezado.setText(CurrentPartido.getEncabezado());

            return itemView;
        }

    }

    static class ViewHolder{
        ImageView imageView;
        TextView Texto;
        TextView Encabezado;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Noticia.clear();
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



