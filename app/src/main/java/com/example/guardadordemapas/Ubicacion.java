package com.example.guardadordemapas;

public class Ubicacion {
    String longitud ,latitud;
    int id;
    public  Ubicacion(){
    }
    public  Ubicacion(String longitud,String latitud,int id){
        this.id = id;
        this.latitud = longitud;
        this.latitud = latitud;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}
