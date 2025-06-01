package Ejercicio;
//Autor: Diego Schreiber
//Clase de lista doble enlazada
public class DobleEnlazamiento<T>{
    private Nodo<T> cabeza;
    private Nodo<T> cola;
    public DobleEnlazamiento(){
        cabeza=null;
        cola=null;
    }
    public void insert(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
    }
    public void addFirst(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        }
    }
    public void addLast(T dato) {
        insert(dato);
    }
    public void printList() {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
    public void deleteByKey(T clave) {
        if (cabeza == null) return;
        Nodo<T> actual = cabeza;
        while (actual != null && !actual.dato.equals(clave)) {
            actual = actual.siguiente;
        }
        if (actual == null) return;
        if (actual == cabeza) {
            cabeza = actual.siguiente;
            if (cabeza != null) cabeza.anterior = null;
            else cola = null;
        } else if (actual == cola) {
            cola = actual.anterior;
            cola.siguiente = null;
        } else {
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;
        }
    }
    public void deleteAtPosition(int posicion) {
        if (posicion < 0 || cabeza == null) return;
        Nodo<T> actual = cabeza;
        int contador = 0;
        while (actual != null && contador < posicion) {
            actual = actual.siguiente;
            contador++;
        }
        if (actual == null) return;
        if (actual == cabeza) {
            removeFirst();
        } else if (actual == cola) {
            removeLast();
        } else {
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;
        }
    }
    public void removeFirst() {
        if (cabeza == null) return;
        cabeza = cabeza.siguiente;
        if (cabeza != null) cabeza.anterior = null;
        else cola = null;
    }
    public void removeLast() {
        if (cola == null) return;
        cola = cola.anterior;
        if (cola != null) cola.siguiente = null;
        else cabeza = null;
    }
    public int size() {
        int count = 0;
        Nodo<T> actual = cabeza;
        while (actual != null) {
            count++;
            actual = actual.siguiente;
        }
        return count;
    }
}
