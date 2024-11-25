package Practica2.Ejercicio1;

/**
 * Modificación de TareaCalculo que para la ejecución al llegar la suma acumulada a un millón con una variable booleana.
 *
 * @author Francesco Fevoli Chacón
 * @date 15/11/2024
 */

public class TareaCalculo3 implements Runnable{
    public int suma = 0;
    public int n;
    private boolean stopped = false;

    @Override
    public void run() {
        while(!stopped){
            try{
                n = (int) (Math.random() * 901) + 100;
                suma += n;
                System.out.println("(" + Thread.currentThread().getName() + ") Valor acumulado: " + suma);
                if (suma >= 1000000) {
                    stopped = true;
                }
                Thread.sleep(10000);

            }catch (InterruptedException e){
                System.err.println("Hilo "+  Thread.currentThread().getName() +" interrumpido.");
                break;
            }
        }
    }
}
