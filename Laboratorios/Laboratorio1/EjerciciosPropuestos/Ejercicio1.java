package com.mycompany.eda_lab1;
//Autor: Diego Schreiber
//SistemaCalificaciones
import java.util.*;
public class Ejercicio1 {

    public static double calcularMediana(ArrayList<Integer> calificaciones) {
        Collections.sort(calificaciones);
        int size = calificaciones.size();
        if (size % 2 == 0) {
            return (calificaciones.get(size / 2 - 1) + calificaciones.get(size / 2)) / 2.0;
        } else {
            return calificaciones.get(size / 2);
        }
    }

    public static ArrayList<Integer> calcularModa(ArrayList<Integer> calificaciones) {
        Map<Integer, Integer> frecuencia = new HashMap<>();
        for (int calificacion : calificaciones) {
            frecuencia.put(calificacion, frecuencia.getOrDefault(calificacion, 0) + 1);
        }

        int maxFrecuencia = Collections.max(frecuencia.values());
        ArrayList<Integer> modas = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frecuencia.entrySet()) {
            if (entry.getValue() == maxFrecuencia) {
                modas.add(entry.getKey());
            }
        }
        return modas;
    }

    public static double calcularDesviacionEstandar(ArrayList<Integer> calificaciones) {
        double promedio = calificaciones.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        double sumaCuadrados = 0;
        for (int calificacion : calificaciones) {
            sumaCuadrados += Math.pow(calificacion - promedio, 2);
        }
        return Math.sqrt(sumaCuadrados / calificaciones.size());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de estudiantes: ");
        int n = scanner.nextInt();
        ArrayList<Integer> calificaciones = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese la calificación del estudiante " + (i + 1) + ": ");
            int calificacion = scanner.nextInt();
            calificaciones.add(calificacion);
        }

        double mediana = calcularMediana(calificaciones);
        ArrayList<Integer> modas = calcularModa(calificaciones);
        double desviacionEstandar = calcularDesviacionEstandar(calificaciones);

        System.out.println("\nResultados:");
        System.out.println("Mediana: " + mediana);
        System.out.print("Moda: ");
        if (modas.size() == 1) {
            System.out.println(modas.get(0));
        } else {
            System.out.println(modas);
        }
        System.out.println("Desviación Estándar: " + desviacionEstandar);
    }
}
