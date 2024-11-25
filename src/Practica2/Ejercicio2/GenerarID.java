package Practica2.Ejercicio2;

import java.util.ArrayList;
import java.util.Random;

/**
 * Clase que genera identificadores alfanuméricos de 6 caracteres.
 * @author Francesco Fevoli Chacón
 * @date 15/11/2024
 */

public class GenerarID {
    static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    /**
     * Genera un ArrayList de IDs.
     *
     * @return ArrayList<String> que contiene los IDs generados.
     */
    public ArrayList<String> generarIds() {
        ArrayList<String> ids = new ArrayList<>();
        Random random = new Random();
        while (ids.size() < 200) {
            StringBuilder id = new StringBuilder(6);
            for (int i = 0; i < 6; i++) {
                id.append(CHARS.charAt(random.nextInt(CHARS.length())));
            }
            ids.add(id.toString());
        }
        return ids;
    }
}