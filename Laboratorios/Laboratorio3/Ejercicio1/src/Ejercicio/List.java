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
    public boolean add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNextNode() != null) {
                current = current.getNextNode();
            }
            current.setNextNode(newNode);
        }
        size++;
        return true;
    }
    public void add(int index, T element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        Node<T> newNode = new Node<>(element);
        if (index == 0) {
            newNode.setNextNode(head);
            head = newNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNextNode();
            }
            newNode.setNextNode(current.getNextNode());
            current.setNextNode(newNode);
        }
        size++;
    }
    public boolean remove(Object o) {
        Node<T> current = head;
        Node<T> previous = null;
        while (current != null) {
            if (current.getDato().equals(o)) {
                if (previous == null) {
                    head = current.getNextNode();
                } else {
                    previous.setNextNode(current.getNextNode());
                }
                size--;
                return true;
            }
            previous = current;
            current = current.getNextNode();
        }
        return false;
    }
    public T remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<T> current = head;
        Node<T> previous = null;
        for (int i = 0; i < index; i++) {
            previous = current;
            current = current.getNextNode();
        }
        if (previous == null) {
            head = current.getNextNode();
        } else {
            previous.setNextNode(current.getNextNode());
        }
        size--;
        return current.getDato();
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
}
