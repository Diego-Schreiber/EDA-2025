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
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNextNode();
        }
        return current.getDato();
    }
    public T set(int index, T element) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNextNode();
        }
        T oldValue = current.getDato();
        current.dato = element;
        return oldValue;
    }
}
