package Practica2.Ejercicio1;

/**
 * Modificación de TareaCalculo que implementa la interfaz Runnable.
 * @author Francesco Fevoli Chacón
 * @date 15/11/2024
 */

public class TareaCalculo2 implements Runnable{
    public int suma = 0;
    public int n;

    @Override
    public void run() {
        while(true) {
            try {
                n = (int) (Math.random() * 901 + 100);
                suma += n;
                System.out.println("(" + Thread.currentThread().getName() + ") Acumulado: " + suma);
                Thread.sleep(10000);
            } catch (InterruptedException e){
                System.err.println("Hilo "+  Thread.currentThread().getName() +" interrumpido.");
                break;
            }
        }
    }
}
