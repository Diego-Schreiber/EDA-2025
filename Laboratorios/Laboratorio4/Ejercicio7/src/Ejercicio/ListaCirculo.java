package Ejercicio;
//Autor: Diego Schreiber
//Clase lista circular
public class ListaCirculo<T> {
    private Nodo<T> cabeza;
    private Nodo<T> cola;
    public ListaCirculo(){
        cabeza=null;
        cola=null;
    }
    public void insert(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            cola.siguiente = cabeza;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
            cola.siguiente = cabeza;
        }
    }
    public void addFirst(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            cola.siguiente = cabeza;
        } else {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
            cola.siguiente = cabeza;
        }
    }
    public void addLast(T dato) {
        insert(dato);
    }
    public void deleteByKey(T clave) {
        if (cabeza == null) return;

        if (cabeza.dato.equals(clave)) {
            removeFirst();
            return;
        }
        Nodo<T> actual = cabeza;
        Nodo<T> anterior = null;
        do {
            anterior = actual;
            actual = actual.siguiente;
            if (actual.dato.equals(clave)) {
                if (actual == cola) {
                    cola = anterior;
                }
                anterior.siguiente = actual.siguiente;
                break;
            }
        } while (actual != cabeza);
    }
    public void deleteAtPosition(int posicion) {
        if (cabeza == null || posicion < 0) return;
        if (posicion == 0) {
            removeFirst();
            return;
        }
        Nodo<T> actual = cabeza;
        Nodo<T> anterior = null;
        int index = 0;
        do {
            anterior = actual;
            actual = actual.siguiente;
            index++;
            if (index == posicion) {
                if (actual == cola) {
                    cola = anterior;
                }
                anterior.siguiente = actual.siguiente;
                break;
            }
        } while (actual != cabeza);
    }
    public void removeFirst() {
        if (cabeza == null) return;
        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {
            cabeza = cabeza.siguiente;
            cola.siguiente = cabeza;
        }
    }
    public void removeLast() {
        if (cabeza == null) return;
        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.siguiente != cola) {
                actual = actual.siguiente;
            }
            actual.siguiente = cabeza;
            cola = actual;
        }
    }
    public int size() {
        if (cabeza == null) return 0;
        int count = 0;
        Nodo<T> actual = cabeza;
        do {
            count++;
            actual = actual.siguiente;
        } while (actual != cabeza);
        return count;
    }
    public void printList() {
        if (cabeza == null) {
            System.out.println("Lista vacía.");
            return;
        }
        Nodo<T> actual = cabeza;
        do {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        System.out.println();
    }
}
