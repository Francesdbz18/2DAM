package Practica2.Ejercicio5;

/**
 * Clase que comprueba prioridades de hilos.
 * @author Francesco Fevoli Chacón
 * @date 15/11/2024
 */
public class HiloPrioridades extends Thread {
    /**
     * Constructor con nombre y prioridad de cada hilo.
     *
     * @param nombre Nombre.
     * @param prioridad Prioridad.
     */
    public HiloPrioridades(String nombre, int prioridad) {
        setName(nombre);
        setPriority(prioridad);
    }

    /**
     * Comprueba la prioridad del hilo para ejecutar la tarea correspondiente. Espera un segundo tras comprobar.
     */
    @Override
    public void run() {
        System.out.println(getName()+ " iniciado.");
        while (true) {
            switch (getPriority()) {
                case 1:
                    tarea1();
                    break;
                case 3:
                    tarea3();
                    break;
                case 5:
                    tarea5();
                    break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println(getName() + " interrumpido.");
                break;
            }
        }
    }

    /**
     * Método que se ejecuta al detectar un hilo de prioridad lenta, o 1.
     */
    private void tarea1() {
        System.out.println(getName() + " (prioridad " + getPriority() + "): tarea lenta");
    }

    /**
     * Método que se ejecuta al detectar un hilo de prioridad media, o 3.
     */
    private void tarea3() {
        System.out.println(getName() + " (prioridad " + getPriority() + "): tarea normal");
    }

    /**
     * Método que se ejecuta al detectar un hilo de prioridad alta, o 5.
     */
    private void tarea5() {
        System.out.println(getName() + " (prioridad " + getPriority() + "): tarea rápida");
    }
}
