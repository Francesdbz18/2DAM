package Practica1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Ejecuta comandos de la línea de comandos del sistema operativo usando procesos.
 * @author Francesco Fevoli Chacón
 * @version 1.0
 */
public class EjecutorComandos {
    /**
     * Ejecuta un comando y devuelve el código de salida.
     *
     * @param comando El comando a ejecutar.
     * @return El código de salida del proceso.
     */
    public int ejecutarComando(String comando) {
        try {
            ProcessBuilder builder = new ProcessBuilder("cmd", "/c", comando);
            Process proceso = builder.start(); // Se inicia
            proceso.waitFor();
            return proceso.exitValue(); // Devuelve una salida
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return -1;
        }
    }
    /**
     * Ejecuta un comando y proporciona entrada estándar.
     * @param comando El comando a ejecutar.
     * @param entrada La entrada que se pasará al comando.
     * @return El código de salida del proceso.
     */
    public int ejecutarComandoConEntrada(String comando, String entrada) {
        try {
            ProcessBuilder builder = new ProcessBuilder("cmd", "/c", comando);
            Process proceso = builder.start();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(proceso.getOutputStream()));
            writer.write(entrada);
            writer.flush();
            writer.close();
            proceso.waitFor();
            return proceso.exitValue();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return -1;
        }
    }
    /**
     * Ejecuta un comando y redirige la salida a un archivo.
     * @param comando El comando a ejecutar.
     * @param archivoSalida El archivo donde se redirigirá la salida. Se comprueba su existencia.
     * @return El código de salida del proceso.
     */
    public int ejecutarComandoConRedireccion(String comando, File archivoSalida) {
        try {
            if (!archivoSalida.exists()) {
                archivoSalida.createNewFile();
            }
            ProcessBuilder builder = new ProcessBuilder("cmd", "/c", comando);
            builder.redirectOutput(archivoSalida);
            Process proceso = builder.start();
            proceso.waitFor();
            return proceso.exitValue();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
