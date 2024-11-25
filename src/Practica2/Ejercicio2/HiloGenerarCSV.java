package Practica2.Ejercicio2;

import java.util.ArrayList;

public class HiloGenerarCSV implements Runnable {
    private ArrayList<String> ids;
    private String nombreArchivo;
    private int nLineas;

    public HiloGenerarCSV(ArrayList<String> identificadores, String nombreArchivo, int nLineas) {
        this.ids = identificadores;
        this.nombreArchivo = nombreArchivo;
        this.nLineas = nLineas;
    }

    @Override
    public void run() {
        GenerarCSV generarCSV = new GenerarCSV();
        generarCSV.generarCSV(ids, nombreArchivo, nombreArchivo, nLineas);
    }
}