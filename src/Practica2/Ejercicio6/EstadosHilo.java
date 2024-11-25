package Practica2.Ejercicio6;

/**
 * Clase que demuestra los principales estados de un hilo usando los métodos wait(), notify(), sleep() y join().
 * El hilo pasa por los estados: NEW, RUNNABLE, TIMED_WAITING, WAITING, y TERMINATED.
 * @author Francesco Fevoli Chacón
 * @date 15/11/2024
 */
public class EstadosHilo {
    static Object lock = new Object();
    /**
     * Método principal. Ejecuta un hilo para demostrar sus estados.
     */
    public static void main(String[] args) {
        Thread prueba = new Thread(() -> {
            try {
                System.out.println("Hilo listo para ejecutar.");
                System.out.println("Hilo en ejecución.");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.err.println("Hilo interrumpido.");
            }
        });
        System.out.println("Hilo nuevo: " + prueba.getState());
        prueba.start();
        try {
            Thread.sleep(1000);
            System.out.println("Hilo espera: " + prueba.getState());
            synchronized (lock) {
                lock.notify();
            }
            prueba.join();
            System.out.println("Hilo finalizado: " + prueba.getState());
        } catch (InterruptedException e) {
            System.err.println("Hilo interrumpido.");
        }
    }
}
