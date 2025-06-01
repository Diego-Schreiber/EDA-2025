package Ejercicio;
//Autor: Diego Schreiber
//Lista doblemente enlazada
public class linkedList <E>{
    private Nodo<E> cabeza;
    private Nodo<E> cola;
    public linkedList(){
        cabeza=null;
        cola=null;
    }
    public void agregarAlFinal(E dato) {
        Nodo<E> nuevo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
    }
}
