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
    public boolean isEmpty() {
        return root.keys.isEmpty();
    }
    public void insert(T key) {
        BPlusNode<T> r = root;
        if (r.keys.size() == 2 * order - 1) {
            BPlusNode<T> s = new BPlusNode<>(false);
            s.children.add(r);
            dividedNode(s, 0);
            root = s;
        }
        insertNonFull(root, key);
    }
    private void insertNonFull(BPlusNode<T> node, T key) {
        int i = Collections.binarySearch(node.keys, key);
        if (i >= 0) return;
        i = -(i + 1);
        if (node.isLeaf) {
            node.keys.add(i, key);
        } else {
            BPlusNode<T> child = node.children.get(i);
            if (child.keys.size() == 2 * order - 1) {
                dividedNode(node, i);
                if (key.compareTo(node.keys.get(i)) > 0)
                    i++;
            }
            insertNonFull(node.children.get(i), key);
        }
    }
}
