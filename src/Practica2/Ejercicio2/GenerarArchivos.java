package Practica2.Ejercicio2;

import java.util.ArrayList;

/**
 * Clase que genera archivos CSV con un identificador alfanumérico en cada línea y un número aleatorio utilizando hilos.
 * @author Francesco Fevoli Chacón
 * @date 15/11/2024
 */
public class GenerarArchivos {
    /**
     * Método genera archivos con hilos.
     * @param ids Identificadores alfanuméricos.
     */
    public void generarArchivos(ArrayList<String> ids) {
        for (int i = 0; i < 100; i++) {
            new Thread(new HiloGenerarCSV(ids, "archivo_" + (i + 1) + ".csv", 100000)).start();
        }
    }

    /**
     * Método principal que genera identificadores y los mete en archivos CSV.
     */
    public static void main(String[] args) {
        GenerarID generadorIds = new GenerarID();
        ArrayList<String> ids = generadorIds.generarIds();
        GenerarArchivos generarArchivos = new GenerarArchivos();
        generarArchivos.generarArchivos(ids);
    }
}
