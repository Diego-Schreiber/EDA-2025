package Ejercicio;
//Autor: Diego Schreiber
//Clase lista circular
public class listaCircular{
    private Nodo cabeza;
    public listaCircular() {
        cabeza = null;
    }
    public void agregar(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.siguiente = cabeza;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != cabeza) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
            nuevo.siguiente = cabeza;
        }
    }
}
