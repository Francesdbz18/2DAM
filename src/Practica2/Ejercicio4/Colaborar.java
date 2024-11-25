package Practica2.Ejercicio4;

/**
 * Lanza gran número de hilos de Lenguaje, aumentando exponencialmente el número de palabras.
 * @author Francesco Fevoli Chacón
 * @date 15/11/2024
 */
public class Colaborar {

    /**
     * Método principal que lanza los hilos.
     * @param args
     */
    public static void main(String[] args) {
        int nHilos = 20;
        String archivo = "colaborarFichero.txt";
        for (int i = 1; i <= nHilos; i++) {
            int nPalabras = i * 10;
            Thread hilo = new Thread(new Lenguaje(nPalabras, archivo));
            hilo.start();
            try {
                hilo.join();
            } catch (InterruptedException e) {
                System.err.println("Hilo interrumpido.");
            }
        }
    }
}

