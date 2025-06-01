package Ejercicio;
//Autor: Diego Schreiber
//Clase lista con todos lo metodos
public class listaEnlazada<T>{
    private Nodo<T> cabeza;
    public listaEnlazada(){
        cabeza=null;
    }
    public void insert(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }
    public void addFirst(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }
    public void addLast(T dato) {
        insert(dato);
    }
    public void deleteByKey(T clave) {
        if (cabeza == null) return;
        if (cabeza.dato.equals(clave)) {
            cabeza = cabeza.siguiente;
            return;
        }
        Nodo<T> actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.dato.equals(clave)) {
            actual = actual.siguiente;
        }
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
        }
    }
    public void deleteAtPosition(int posicion) {
        if (posicion < 0 || cabeza == null) return;

        if (posicion == 0) {
            cabeza = cabeza.siguiente;
            return;
        }
        Nodo<T> actual = cabeza;
        for (int i = 0; actual != null && i < posicion - 1; i++) {
            actual = actual.siguiente;
        }
        if (actual != null && actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
        }
    }
}
