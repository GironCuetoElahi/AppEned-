package com.example.elahi.aplicacionened;


import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
<<<<<<< HEAD
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
=======

>>>>>>> 9323aa3c35ca9d791a2d4e04c8bda28f22b4fadf
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Noticias extends Fragment {
<<<<<<< HEAD
    private List<Obj_noticias> Noticias=new ArrayList<Obj_noticias>();

=======
    private List<Clase_noticia> Noticia=new ArrayList<Clase_noticia>();
>>>>>>> 9323aa3c35ca9d791a2d4e04c8bda28f22b4fadf
    View view;
    private String DEBUG_TAG;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_noticias, container, false);
<<<<<<< HEAD
        buscar();
        PartidoView();
=======
        Noticia();
        NoticiaView();
>>>>>>> 9323aa3c35ca9d791a2d4e04c8bda28f22b4fadf
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

<<<<<<< HEAD
    /**************************************************************************************************************************/

    private void PartidoView(){
        ArrayAdapter<Obj_noticias> adapter=new MyListAdapter();
        ListView list=(ListView) view.findViewById(R.id.listview);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Obj_noticias>{
        public MyListAdapter(){
            super(getActivity(), R.layout.item_view_not,Noticias);
        }

        public View getView (int position, View convertView, ViewGroup parent){
            Noticias.ViewHolder holder = null;
            View itemView = convertView;
            if (itemView==null){
                itemView=getLayoutInflater().inflate(R.layout.item_view, parent,false);

                holder = new ViewHolder();

                holder.imageView = (ImageView) itemView.findViewById(R.id.logo) ;
                holder.Encabezado=(TextView) itemView.findViewById(R.id.Equipo1) ;
                holder.Texto=(TextView) itemView.findViewById(R.id.Equipo2);

                itemView.setTag(holder);}

            else
                holder = (Noticias.ViewHolder) itemView.getTag();

            Obj_noticias CurrentPartido= Noticias.get(position);

            holder.imageView.setImageResource(CurrentPartido.getImagen());
            holder.Encabezado.setText(CurrentPartido.getEncabezado());
            holder.Texto.setText(CurrentPartido.getTexto());

            return itemView;
        }

    }

    static class ViewHolder{
        ImageView imageView;
        TextView Encabezado;
        TextView Texto;

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Noticias.clear();
    }

    /**************************************************************************************************************************/
    public void imprime(String aux) {
            String[] parts = aux.split(";");
            for(int i=0;i<parts.length-1;i++){
                if (!parts[i+1].equals("")) {
                    String[] parts2=parts[i].split("&");
                    //Activity algo=this.getActivity();
                    Noticias.add(new Obj_noticias(R.drawable.beisbol,parts2[0],parts2[1]));
                    //Toast.makeText(algo,parts2[0]+parts2[1], Toast.LENGTH_LONG).show();
            }

        }



    }

    public  boolean isConected(Context context) {

        boolean connected = false;

        ConnectivityManager connec = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        // Recupera todas las redes (tanto móviles como wifi)
        NetworkInfo[] redes = connec.getAllNetworkInfo();

        for (int i = 0; i < redes.length; i++) {
            // Si alguna red tiene conexión, se devuelve true
            if (redes[i].getState() == NetworkInfo.State.CONNECTED) {
                connected = true;
            }
        }
        return connected;
    }

    public void buscar(){
        DEBUG_TAG= "https://elahito.000webhostapp.com/php/conection.php";
        new Noticias.DownloadWebpageTask().execute(DEBUG_TAG);

    }




    private class DownloadWebpageTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            try {
                return downloadUrl(urls[0]);
            } catch (IOException e) {
                return "No se puede recuperar la página web. URL puede no ser válida.";
            }
        }

        // onPostExecute muestra el resultado de AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            imprime(result);
        }
    }

    private String downloadUrl(String myurl) throws IOException {
        InputStream is = null;

        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milisegundos */);
            conn.setConnectTimeout(15000 /* milisegundos */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // Inicia la consulta
            conn.connect();
            int response = conn.getResponseCode();
            Log.d(DEBUG_TAG, "La respuesta es: " + response);
            is = conn.getInputStream();
            //Para descargar la página web completa
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String webPage = "";
            String data = "";
            while ((data = reader.readLine()) != null) {
                webPage += data + "\n";
            }
            return webPage;
            // Se asegura de que el InputStream se cierra después de la aplicación deja de usarla.
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }
=======
>>>>>>> 9323aa3c35ca9d791a2d4e04c8bda28f22b4fadf

}



