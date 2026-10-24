package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("¿Cuántos lanzamientos desea realizar? ");
        int cantidad = teclado.nextInt();

        Dado dado = new Dado(cantidad);
        Operaciones.lanzar(dado);
        Operaciones.calcularFrecuencias(dado);

        System.out.println("Lanzamientos originales: " + Arrays.toString(dado.getLanzamientos()));




        int opcion;
        do {
            mostrarMenu();
            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    Operaciones.ordenar(dado);
                    System.out.println("Original: " + Arrays.toString(dado.getLanzamientos()));
                    System.out.println("Ordenado: " + Arrays.toString(dado.getOrdenado()));
                    break;

                case 2:
                    for (int cara = 1; cara <= dado.getCaras(); cara++) {
                        System.out.println("Cara " + cara + ": " + dado.getFrecuencias()[cara] + " veces");
                    }
                    break;

                case 3:
                    Operaciones.reconstruirOrdenado(dado);
                    System.out.println("Reconstruido: " + Arrays.toString(dado.getOrdenado()));
                    System.out.println("Original:     " + Arrays.toString(dado.getLanzamientos()));
                    break;

                case 4:
                    int[] masFrecuentes = Operaciones.resultadosMasFrecuentes(dado);
                    int veces = dado.getFrecuencias()[masFrecuentes[0]];
                    System.out.println("Más frecuente(s): " + Arrays.toString(masFrecuentes)
                            + " con " + veces + " apariciones");
                    break;

                case 5:
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida, intente de nuevo.");
                    break;
            }

        } while (opcion != 5);

        teclado.close();
    }





    private static void mostrarMenu() {
        System.out.println();
        System.out.println("|---||Juego de Dados||---|");
        System.out.println("[1]: Ordenar lanzamientos");
        System.out.println("[2]: Mostrar frecuencia de cada cara");
        System.out.println("[3]: Reconstruir el arreglo ordenado desde las frecuencias");
        System.out.println("[4]: Mostrar resultado más frecuente");
        System.out.println("[5]: Salir");
        System.out.print("Opción: ");
    }
}