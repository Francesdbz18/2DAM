import Practica2.Defensa.ControlHilos;

public class Main {
    public static void main(String[] args) {
        ControlHilos controlHilos = new ControlHilos();
        Thread hilo = new Thread(controlHilos, "Hilo 1");
        Thread hilo2 = new Thread(controlHilos, "Hilo 2");
        Thread hilo3 = new Thread(controlHilos, "Hilo 3");
        hilo.start();
        hilo2.start();
        hilo3.start();
        try {
            hilo.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            System.err.println("Un hilo ha sido interrumpido.");
        }
        System.out.println("Todos los hilos han terminado su ejecución.");
    }
}
