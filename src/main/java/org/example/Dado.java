package org.example;

public class Dado {

    private final int CARAS = 6;

    private int[] lanzamientos;
    private int[] frecuencias = new int[CARAS + 1];
    private int[] ordenado;

    public Dado(int cantidadLanzamientos) {
        this.lanzamientos = new int[cantidadLanzamientos];
        this.ordenado = new int[cantidadLanzamientos];
    }

    public int getCaras() { return CARAS; }
    public int[] getLanzamientos() { return lanzamientos; }
    public int[] getFrecuencias() { return frecuencias; }
    public int[] getOrdenado() { return ordenado; }

}
