package Ejercicio;
//Autor: Diego Schreiber
//Clase para arbol B+
import java.util.*;
public class BPlusTree<T extends Comparable<T>> {
    private BPlusNode<T> root;
    private int order;
    public BPlusTree(int order) {
        this.order = order;
        this.root = new BPlusNode<>(true);
    }
    public void destroy() {
        root = new BPlusNode<>(true);
    }
}
