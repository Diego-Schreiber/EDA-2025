package Ejercicio;
//Autor: Diego Schreiber
// Clase nodo para arbol B+
import java.util.*;
class BPlusNode<T extends Comparable<T>> {
    boolean isLeaf;
    List<T> keys;
    List<BPlusNode<T>> children;
    BPlusNode<T> next;
    public BPlusNode(boolean isLeaf) {
        this.isLeaf = isLeaf;
        keys = new ArrayList<>();
        children = new ArrayList<>();
        next = null;
    }
}
