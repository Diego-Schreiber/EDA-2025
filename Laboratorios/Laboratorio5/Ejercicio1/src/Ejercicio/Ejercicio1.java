package Ejercicio;
//Autor: Diego Schreiber
//Clase main del ejercicio1
public class Ejercicio1 {
    public static void main(String[] args) {
        StackList<Integer> pila = new StackList<>();
        for (int i = 1; i <= 10; i++) {
            pila.push(i);
        }
        System.out.println("Contenido de la pila:");
        pila.printStack();
    }
}
