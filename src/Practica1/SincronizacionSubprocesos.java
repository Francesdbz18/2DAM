package Practica1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Ejecuta comandos de PowerShell para contar líneas y palabras en archivos de texto diferentes,
 * manejando la sincronización de los subprocesos correspondientes.
 * @author Francesco Fevoli Chacón
 * @version 1.0
 */
public class SincronizacionSubprocesos {
    /**
     * Método principal. Define archivos a usar y devuelve
     * los resultados de los comandos ejecutados, por separado y también combinados.
     * Comprueba la existencia de los archivos.
     */
    public static void main(String[] args) {
        String ruta1 = "src\\archivo1.txt";
        String ruta2 = "src\\archivo2.txt";
        File archivo1 = new File(ruta1);
        File archivo2 = new File(ruta2);
        if (archivo1.exists()&&archivo2.exists()) {
            try {
                int nLineas = ejecutar("Get-Content " + archivo1 + " | Measure-Object -Line");
                int nPalabras = ejecutar("Get-Content " + archivo2 + " | Measure-Object -Word");
                System.out.println("Líneas en archivo1.txt: " + nLineas);
                System.out.println("Palabras en archivo2.txt: " + nPalabras);
                System.out.println("Total combinado de líneas y palabras: " + (nLineas + nPalabras));

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        } else System.out.println("Error en los archivos.");
    }

    /**
     * Ejecuta un comando de PowerShell y devuelve el resultado numérico.
     * @param comando Comando a ejecutar.
     * @return El resultado del proceso.
     * @throws IOException Si hay un error de entrada/salida.
     * @throws InterruptedException Si se interrumpe el proceso.
     */
    private static int ejecutar (String comando) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder("powershell.exe", "-Command", comando);
        Process proceso = builder.start();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
            String resultado;
            while ((resultado = reader.readLine()) != null) {
                if (resultado.trim().matches("^\\d+$")) {
                    return Integer.parseInt(resultado.trim());
                }
            }
        } proceso.waitFor();
        System.err.println("ERROR");
        return 0;
    }
}
