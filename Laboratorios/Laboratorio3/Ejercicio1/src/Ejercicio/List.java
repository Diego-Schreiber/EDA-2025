package Ejercicio;
//Autor: Diego Schreiber
//Clase Lista que almacena nodos
public class List<T> {
    private Node<T> head;
    private int size;
    public List() {
        this.head = null;
        this.size = 0;
    }
}
