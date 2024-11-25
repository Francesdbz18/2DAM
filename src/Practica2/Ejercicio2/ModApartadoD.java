package Practica2.Ejercicio2;

import java.util.ArrayList;

/**
 * Variación para adaptarse al apartado d).
 * @author Francesco Fevoli Chacón
 * @date 15/11/2024
 */
public class ModApartadoD {
    public void generarArchivos(ArrayList<String> ids) {
        for (int i = 0; i < 50; i++) {
            new Thread(new HiloGenerarCSV(ids, "archivo" + i + ".csv", 50000)).start();
        }
    }

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        GenerarID generadorIds = new GenerarID();
        ArrayList<String> ids = generadorIds.generarIds();
        ModApartadoD generar = new ModApartadoD();
        generar.generarArchivos(ids);
        long finalPrograma = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución: " + (finalPrograma - inicio) + " ms");
    }
}