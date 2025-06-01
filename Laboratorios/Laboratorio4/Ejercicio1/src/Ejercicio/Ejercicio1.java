package Ejercicio;
//Autor: Diego Schreiber
//Main ejercicio 1
public class Ejercicio1 {
    public static void main(String[] args) {
        linkedList<Integer> lista = new linkedList<>();
        for (int i = 1; i <= 10; i++) {
            lista.agregarAlFinal(i);
        }
        System.out.println("Lista hacia adelante:");
        lista.imprimirAdelante();
        System.out.println("Lista hacia atras:");
        lista.imprimirAtras();
        System.out.println("Primer elemento (obtenido con metodo generico): " + lista.obtenerPrimero());
    }
}
