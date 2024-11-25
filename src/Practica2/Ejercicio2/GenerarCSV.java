package Practica2.Ejercicio2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GenerarCSV {

    public void generarCSV(ArrayList<String> ids, String nombreArchivo1, String nombreArchivo2, int nLineas) {
        Random random = new Random();
        try (BufferedWriter writer1 = new BufferedWriter(new FileWriter(nombreArchivo1));
             BufferedWriter writer2 = new BufferedWriter(new FileWriter(nombreArchivo2))) {
            for (int i = 0; i < nLineas; i++) {
                String id = getRandom(ids);
                int numero = random.nextInt(20000 + 1);
                writer1.write(id + "," + numero);
                writer1.newLine();
                writer2.write(id + " " + numero);
                writer2.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error de entrada/salida");
        }
    }
    private String getRandom(ArrayList<String> ids) {
        int i = new Random().nextInt(ids.size());
        return ids.get(i);
    }

    public static void main(String[] args) {
        GenerarID generadorIds = new GenerarID();
        ArrayList<String> ids = generadorIds.generarIds();

        GenerarCSV generarCSV = new GenerarCSV();
        generarCSV.generarCSV(ids, "datos1.csv", "datos2.csv", 50000);
    }
}