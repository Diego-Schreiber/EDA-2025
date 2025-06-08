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
}
