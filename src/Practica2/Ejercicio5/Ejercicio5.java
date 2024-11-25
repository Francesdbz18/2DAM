package Practica2.Ejercicio5;

/**
 * Lanza hilos con distintas prioridades para comprobarlas con HiloPrioridades.
 * @author Francesco Fevoli Chacón
 * @date 15/11/2024
 */
public class Ejercicio5 {

    /**
     * Método principal. Crea y ejecuta hilos.
     */
    public static void main(String[] args) {
        HiloPrioridades hilo1 = new HiloPrioridades("Hilo1", 1);
        HiloPrioridades hilo2 = new HiloPrioridades("Hilo2", 3);
        HiloPrioridades hilo3 = new HiloPrioridades("Hilo3", 5);
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}
