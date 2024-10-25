package Tema2_MultiHilos;

public class HiloEjemploInterrup extends Thread {
    public void run() {
        try {
            while (!isInterrupted()) {
                System.out.println("En el Hilo");
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println("HA OCURRIDO UNA EXCEPCION");
        } // run
        System.out.println("FIN HILO");
    }

    public void interrumpir() {
        interrupt();
    } // interrumpir

    public static void main(String[] args) {
        HiloEjemploInterrup h = new HiloEjemploInterrup();
        h.start();
        for (int i = 0; i < 1000000000; i++); // no hago nada
        h.interrumpir();
    } //Fin main

}//Fin class

