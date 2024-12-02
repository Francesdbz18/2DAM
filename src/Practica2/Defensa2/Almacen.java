package Practica2.Defensa2;

class Almacen {
	
	private int[] array = new int[30];

    public Almacen() {

    }

    public synchronized void agregar(int valor) throws InterruptedException {

    }

    public synchronized void eliminar(int valor) throws InterruptedException {
        boolean eliminado = false;
        while (!eliminado) {
            for (int i = 0; i < indice; i++) {
                if (array[i] == valor) {
                    array[i] = array[--indice];
                    eliminado = true;
                    notifyAll();  // Notificar a otros hilos que pueden continuar
                    break;
                }
            }
            if (!eliminado) {
                wait();  // Esperar si el valor no está en el array
            }
        }
    }
	
	//getters y setters

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }


    //toString()
	
}
