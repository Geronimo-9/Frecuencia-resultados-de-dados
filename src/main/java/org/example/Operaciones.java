package org.example;

import java.util.Arrays;
import java.util.Random;

public class Operaciones {

    // Llena el arreglo con lanzamientos aleatorios (1 a 6)
    public static void lanzar(Dado dado) {
        Random random = new Random();
        int[] lanz = dado.getLanzamientos();
        for (int i = 0; i < lanz.length; i++) {
            lanz[i] = random.nextInt(dado.getCaras()) + 1;
        }
    }

    // PASO 1 de Counting Sort: contar frecuencias
    public static void calcularFrecuencias(Dado dado) {
        int[] frec = dado.getFrecuencias();
        Arrays.fill(frec, 0);
        for (int valor : dado.getLanzamientos()) {
            frec[valor]++;
        }
    }

    // PASO 2 de Counting Sort: reconstruir el arreglo ordenado desde las frecuencias
    public static void reconstruirOrdenado(Dado dado) {
        int[] frec = dado.getFrecuencias();
        int[] ord = dado.getOrdenado();
        int pos = 0;
        for (int cara = 1; cara <= dado.getCaras(); cara++) {
            for (int veces = 0; veces < frec[cara]; veces++) {
                ord[pos++] = cara;
            }
        }
    }




    // Counting Sort completo (opción 1)
    public static void ordenar(Dado dado) {
        calcularFrecuencias(dado);
        reconstruirOrdenado(dado);
    }

    // Devuelve la(s) cara(s) con mayor frecuencia (puede haber empate)
    public static int[] resultadosMasFrecuentes(Dado dado) {
        int[] frec = dado.getFrecuencias();
        int max = 0;
        for (int cara = 1; cara <= dado.getCaras(); cara++) {
            if (frec[cara] > max) {
                max = frec[cara];
            }
        }

        int cantidad = 0;
        for (int cara = 1; cara <= dado.getCaras(); cara++) {
            if (frec[cara] == max) {
                cantidad++;
            }
        }

        int[] resultado = new int[cantidad];
        int idx = 0;
        for (int cara = 1; cara <= dado.getCaras(); cara++) {
            if (frec[cara] == max) {
                resultado[idx++] = cara;
            }
        }
        return resultado;
    }
}