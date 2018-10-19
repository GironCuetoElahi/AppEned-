package com.example.elahi.aplicacionened.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PartidoModel {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("local")
    @Expose
    private String local;

    @SerializedName("visita")
    @Expose
    private String visita;

    @SerializedName("sede")
    @Expose
    private String sede;

    public String getVisita() {
        return visita;
    }

    public void setVisita(String visita) {
        this.visita = visita;
    }

    @SerializedName("jornada")
    @Expose
    private String Jornada;

    @SerializedName("hora")
    @Expose
    private String hora;

    @SerializedName("disciplina")
    @Expose
    private String genero;


    public PartidoModel(String id, String local, String visita, String sede, String jornada, String hora, String genero) {
        this.id = id;
        this.local = local;
        this.visita = visita;
        this.sede = sede;
        Jornada = jornada;
        this.hora = hora;
        this.genero = genero;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getJornada() {
        return Jornada;
    }

    public void setJornada(String jornada) {
        Jornada = jornada;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


}
