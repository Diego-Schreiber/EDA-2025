package com.mycompany.eda_lab1;
//Autor: Diego Schreiber
//Criba de eratostenes
import java.util.*;
public class Ejercicio2 {
    public static ArrayList<Integer> cribaDeEratostenes(int max) {
        boolean[] esPrimo = new boolean[max + 1];
        Arrays.fill(esPrimo, true);
        esPrimo[0] = esPrimo[1] = false;
        for (int i = 2; i * i <= max; i++) {
            if (esPrimo[i]) {
                for (int j = i * i; j <= max; j += i) {
                    esPrimo[j] = false;
                }
            }
        }
        ArrayList<Integer> primos = new ArrayList<>();
        for (int i = 2; i <= max; i++) {
            if (esPrimo[i]) {
                primos.add(i);
            }
        }       
        return primos;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el límite superior del rango: ");
        int limite = scanner.nextInt();
        ArrayList<Integer> primos = cribaDeEratostenes(limite);
        System.out.println("Los números primos hasta " + limite + " son:");
        for (int primo : primos) {
            System.out.print(primo + " ");
        }
    }
}
