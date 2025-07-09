package Ejercicio;
/7Autor: Diego Schreiber
//Clase Arbol B
import java.util.*;
class BTree <Textends Comparable<T>>{
    private int t;
    private Node<T> root;
    public BTree(int t) {
        this.t = t;
        this.root = new Node<>(true);
    }
    public void destroy() {
        root = null;
    }
    public boolean isEmpty() {
        return root == null || root.keys.isEmpty();
    }
}
