package Ejercicio;
//Autor: Diego Schreiber
//Clase main del ejercicio 2
public class Ejercicio2 {
        public static void main(String[] args) {
        listaCircular lista = new listaCircular();
        for (int i = 1; i <= 12; i++) {
            lista.agregar(i);
        }
        System.out.println("Lista circular con elementos del 1 al 12:");
        lista.imprimir();
    }
}
