package Practica1;

import java.io.*;
import java.util.ArrayList;

/**
 * Comprime archivos mediante un subproceso usando el comando tar de la línea de comandos del sistema operativo.
 * @author Francesco Fevoli Chacón
 * @version 1.0
 */

public class ComprimirArchivos {

    /**
     * Método principal.
     * Gestiona paso a paso la compresión de los archivos obtenidos de la función crearArchivos()
     */
    public static void main(String[] args) {
        String tar = "src\\archivos_comprimidos.tar";

        try {
            ProcessBuilder pb = new ProcessBuilder("tar", "-cf", tar, "-T", "-");
            pb.redirectErrorStream(true);
            Process proceso = pb.start();
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(proceso.getOutputStream()))) {
                for (File archivo : crearArchivos()) {
                    writer.write(String.valueOf(archivo));
                    writer.newLine();
                }
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
            int exitCode = proceso.waitFor();
            if (exitCode == 0) {
                System.out.println("Archivos comprimidos: " + tar);
            } else {
                System.out.println("Error al comprimir. Código: " + exitCode);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Almacena los archivos en una lista para su uso en el programa principal, existan o no.
     * @return ArrayList de archivos.
     */
    public static ArrayList<File> crearArchivos() {
        String[] rutas = {"src\\archivo1", "src\\archivo2", "src\\archivo3"};
        ArrayList<File> archivos = new ArrayList<>();
        for (String ruta : rutas) {
            File file = new File(ruta);
            if (!file.exists()) {
                try {
                    if (file.createNewFile()) {
                        System.out.println("Archivo creado: " + ruta);
                        archivos.add(file);
                    }
                } catch (IOException e) {
                    System.err.println("No se pudo crear el archivo: " + ruta);
                    e.printStackTrace();
                }
            } else {
                System.out.println("El archivo ya existe: " + ruta);
                archivos.add(file);
            }
        }
        return archivos;
    }
}