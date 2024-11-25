package Practica2.Ejercicio1;

/**
 * Clase que hereda Thread. Asigna un número al hilo y lo suma con el resto.
 *
 * @author Francesco Fevoli Chacón
 * @date 15/11/2024
 */
public class TareaCalculo extends Thread {
    // Variable de la suma total
    private int suma = 0;

    /**
     * Método ejecutado al lanzarse cada hilo en Ejercicio_1
     * Asigna un número aleatorio a cada hilo y lo suma a un acumulado.
     */
    @Override
    public void run() {
        while (true) {
            try {
                int n = (int) (Math.random() * 901 + 100);
                suma += n; // Suma el número al acumulado
                System.out.println(Thread.currentThread().getName() + " - Valor acumulado: " + suma);
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " ha sido interrumpido.");
                Thread.currentThread().interrupt();
            }
        }
    }
}
