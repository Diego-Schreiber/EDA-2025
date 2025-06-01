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
}
