package com.example.elahi.aplicacionened;

public class Clase_futbol {
    int imagen;
    String Equipo1;
    String Equipo2;
    String Sede;
    String Horario;

    public Clase_futbol(String Equipo1, String Equipo2, String Sede, String Horario,int imagen){
        setImagen(imagen);
        setEquipo1(Equipo1);
        setEquipo2(Equipo2);
        setSede(Sede);
        setHorario(Horario);
    }

    public int getImagen() {
        return imagen;
    }

    public String getEquipo1() {
        return Equipo1;
    }

    public String getEquipo2() {
        return Equipo2;
    }

    public String getSede() {
        return Sede;
    }

    public String getHorario() {
        return Horario;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public void setEquipo1(String equipo1) {
        Equipo1 = equipo1;
    }

    public void setEquipo2(String equipo2) {
        Equipo2 = equipo2;
    }

    public void setSede(String sede) {
        Sede = sede;
    }

    public void setHorario(String horario) {
        Horario = horario;
    }
}
