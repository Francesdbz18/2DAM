package Practica2.Ejercicio1;

/**
 * Clase que inicia treinta hilos para ser usados en las demás clases del ejercicio.
 * @author Francesco Fevoli Chacón
 * @date 04/11/2024
 */

public class Ejercicio_1 {
    /**
     * Método principal que crea y lanza 30 hilos.
     */
    public static void main(String[] args) {
         for(int i = 1; i <= 30; i++){
             TareaCalculo tarea2 = new TareaCalculo();
            Thread hilo2 = new Thread(tarea2, "Hilo" + i);
             hilo2.start();
         }
    }
}
