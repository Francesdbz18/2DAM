package Practica2.Ejercicio4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Crea un número específico de palabras con conjuntos de letras aleatorios, y los guarda en un archivo específico.
 * @author Francesco Fevoli Chacón
 * @date 15/11/2024
 */
public class Lenguaje implements Runnable {
    private static final String ruta = "src\\Ejercicio4\\";
    private final int nPalabras;
    private final String archivo;

    /**
     * Constructor de Lenguaje.
     *
     * @param nPalabras Palabras a generar.
     * @param archivo Archivo donde se escribirán las palabras.
     */
    public Lenguaje(int nPalabras, String archivo) {
        this.nPalabras = nPalabras;
        this.archivo = ruta + archivo; // Ruta más el fichero
    }

    /**
     * Método que se ejecuta al lanzar el hilo. Genera palabras y las escribe en un archivo.
     */
    @Override
    public void run() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            for (int i = 0; i < nPalabras; i++) {
                StringBuilder palabra = new StringBuilder();

                // Genera una longitud aleatoria entre 3 y 10 para cada palabra
                int length = 3 + (int) (Math.random() * 8);

                // Genera una palabra con la longitud aleatoria
                for (int j = 0; j < length; j++) {
                    char letra = (char) ('a' + (int) (Math.random() * 26));
                    palabra.append(letra);
                }

                writer.write(palabra.toString());
                writer.newLine();
            } // Fin for
        } catch (IOException e) {
            System.err.println("Error de entrada/salida");
        } // Fin try-catch
    } // Fin run

    /**
     * Método principal para generar un único archivo con el Lenguaje y especificar número de palabras y nombre de archivo.
     *
     * @param args no se utiliza.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca el número de palabras a generar: ");
        int nPalabras = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Archivo donde se guardará el lenguaje: ");
        String archivo = scanner.nextLine();

        // Crear instancia de Lenguaje y ejecutar
        Lenguaje lenguaje = new Lenguaje(nPalabras, archivo);
        lenguaje.run();
    } // Fin main
} // Fin class