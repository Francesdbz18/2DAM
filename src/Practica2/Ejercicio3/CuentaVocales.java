package Practica2.Ejercicio3;
public class CuentaVocales {
    static int conteoTotal = 0;
    final static Object lock = new Object();

    public static void main(String[] args) {
        String texto = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum lacus justo, condimentum nec aliquam nec, sodales quis mauris. Sed finibus.";
        Thread A = new Thread(new Contador('a', texto));
        Thread E = new Thread(new Contador('e', texto));
        Thread I = new Thread(new Contador('i',texto));
        Thread O = new Thread(new Contador('o',texto));
        Thread U = new Thread(new Contador('u',texto));
        A.start();
        E.start();
        I.start();
        O.start();
        U.start();
        System.out.println(texto);
        try {
            A.join();
            E.join();
            I.join();
            O.join();
            U.join();
        } catch (InterruptedException e) {
            System.err.println("Un hilo ha sido interrumpido.");
        }
        System.out.println("Total: " + conteoTotal + " vocales.");
    }

    static class Contador implements Runnable {
        private char vocal;
        private String texto;

        public Contador(char vocal, String texto) {
            this.vocal = vocal;
            this.texto = texto;
        }

        @Override
        public void run() {
            int conteo = 0;
            for (char c : texto.toLowerCase().toCharArray()) {
                if (c == vocal) {
                    conteo++;
                }
            }
            synchronized (lock) {
                conteoTotal += conteo;
            }
            System.out.println("Conteo de '" + vocal + "': " + conteo);
        }
    }
}

