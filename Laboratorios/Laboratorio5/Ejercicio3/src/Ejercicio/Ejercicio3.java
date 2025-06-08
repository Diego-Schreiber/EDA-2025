package Ejercicio;
//Autor: Diego Schreiber
//Clase main del ejercicio 3
public class Ejercicio3 {
        public static void main(String[] args) {
        QueueList cola = new QueueList();
        for (int i = 1; i <= 10; i++) {
            cola.enqueue(i);
        }
        System.out.println("Contenido de la cola:");
        cola.printQueue();
    }
}
