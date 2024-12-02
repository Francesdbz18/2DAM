package Practica2.Defensa;

public class ControlHilos extends Thread {
	
	public void run() {
        long tiempoInicial = System.currentTimeMillis();
        while (System.currentTimeMillis() - tiempoInicial < 10000) {
            int n = (int) (Math.random() * 100 + 1);
            System.out.println(Thread.currentThread().getName() + ": "+ n);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
