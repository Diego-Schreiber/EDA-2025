package Ejercicio;
import java.util.ArrayList;
import java.util.List;
//Autor: Diego Schreiber
//Clase nodo
class Node<T extends Comparable<T>> {
    List<T> keys = new ArrayList<>();
    List<Node<T>> children = new ArrayList<>();
    boolean isLeaf;
    public Node(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }
}
