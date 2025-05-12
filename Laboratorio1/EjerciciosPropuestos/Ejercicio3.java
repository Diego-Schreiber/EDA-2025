package com.mycompany.eda_lab1;
//Autor: Diego Schreiber
//Ordenamiento
import java.util.*;
public class Ejercicio3 {
    public static void ordenamientoPorInsercion(int[] lista) {
        for (int i = 1; i < lista.length; i++) {
            int elementoActual = lista[i];
            int j = i - 1;
            while (j >= 0 && lista[j] > elementoActual) {
                lista[j + 1] = lista[j];
                j--;
            }
            lista[j + 1] = elementoActual;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el tamaño del arreglo: ");
        int n = scanner.nextInt();
        int[] lista = new int[n];
        System.out.println("Ingrese los elementos del arreglo:");
        for (int i = 0; i < n; i++) {
            lista[i] = scanner.nextInt();
        }
        ordenamientoPorInsercion(lista);
        System.out.println("Arreglo ordenado:");
        for (int i : lista) {
            System.out.print(i + " ");
        }
    }
}
