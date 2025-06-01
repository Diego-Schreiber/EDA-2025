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
    public E obtenerPrimero() {
        if (cabeza != null) {
            return cabeza.dato;
        }
        return null; 
    }
    public void imprimirAdelante() {
        Nodo<E> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}
