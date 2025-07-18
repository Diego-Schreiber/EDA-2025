package Ejercicio;
//Autor: Diego Schreiber
//Clase para la cola
public class QueueList<T>{
    private Nodo<T> frente;
    private Nodo<T> fin;
    public QueueList(){
        frente = fin = null;
    }
    public void enqueue(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (isEmpty()) {
            frente = fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }
    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Cola vacía");
        T dato = frente.getDato();
        frente = frente.getSiguiente();
        if (frente == null) fin = null;
        return dato;
    }
    public T front() {
        if (isEmpty()) throw new RuntimeException("Cola vacía");
        return frente.getDato();
    }
    public T back() {
        if (isEmpty()) throw new RuntimeException("Cola vacía");
        return fin.getDato();
    }
    public boolean isEmpty() {
        return frente == null;
    }
    public boolean isFull() {
        return false;
    }
    public void destroyQueue() {
        frente = fin = null;
    }
    public void printQueue() {
        Nodo<T> actual = frente;
        while (actual != null) {
            System.out.print(actual.getDato() + " ");
            actual = actual.getSiguiente();
        }
        System.out.println();
    }
}
