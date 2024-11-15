package Practica1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Comprime archivos especificados por el usuario
 * @author Francesco Fevoli Chacón
 * @version 1.0
 */
public class GestorTareas {

    /**
     * Método principal. Recoge las rutas del teclado y comprime los archivos en caso de que existan.
     */
    public static void main(String[] args) {
        ArrayList<File> archivos = new ArrayList<>();
        ArrayList<Process> procesos = new ArrayList<>();
        ArrayList<String> resultados = new ArrayList<>();
        recogerArchivos(archivos);
        comprimir(archivos, procesos, resultados);
        mostrarResultados(procesos, resultados, archivos);
    }

    /**
     * Muestra los resultados de los procesos.
     * @param procesos Lista de procesos.
     * @param resultados Lista de resultados obtenidos.
     * @param archivos Lista de archivos comprimidos.
     */
    private static void mostrarResultados(ArrayList<Process> procesos, ArrayList<String> resultados, ArrayList<File> archivos) {
        for (int i = 0; i < procesos.size(); i++) {
            Process proceso = procesos.get(i);
            String tar = resultados.get(i);
            try {
                int exitCode = proceso.waitFor();
                if (exitCode == 0) {
                    System.out.println("Compresión exitosa: " + tar);
                } else {
                    System.out.println("Error al comprimir " + archivos.get(i).getName() + ". Código de salida: " + exitCode);
                }
            } catch (InterruptedException e) {
                System.err.println("ERROR: Proceso interrumpido.");
            }
        }
    }

    /**
     * Comprime los archivos especificados con los comandos tar de la línea de comandos.
     * @param archivos Lista de archivos a comprimir.
     * @param procesos Lista de procesos.
     * @param resultados Lista de resultados obtenidos.
     */
    private static void comprimir(ArrayList<File> archivos, ArrayList<Process> procesos, ArrayList<String> resultados) {
        for (File archivo : archivos) {
            String tar = archivo.getAbsolutePath() + ".tar";
            ProcessBuilder pb = new ProcessBuilder("tar", "-cvf", tar, archivo.getAbsolutePath());
            pb.redirectErrorStream(true);
            try {
                Process proceso = pb.start();
                procesos.add(proceso);
                resultados.add(tar);
            } catch (IOException e) {
                System.err.println("Error");
            }
        }
    }

    /**
     * Recoge de teclado los archivos a usar en otras partes del programa. Comprueba su existencia.
     * @param archivos
     */
    private static void recogerArchivos(ArrayList<File> archivos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los archivos a comprimir. Escriba 0 para terminar:");
        while (true) {
            String ruta = scanner.nextLine();
            if (ruta.equals("0")) {
                break;
            }
            File archivo = new File(ruta);
            if (archivo.exists() && archivo.isFile()) {
                archivos.add(archivo);
            } else {
                System.out.println("El archivo no existe. Inténtelo de nuevo.");
            }
        }
    }
}