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
    public void dividedNode(BPlusNode<T> parent, int i) {
        BPlusNode<T> full = parent.children.get(i);
        BPlusNode<T> sibling = new BPlusNode<>(full.isLeaf);
        int mid = order;
        sibling.keys.addAll(full.keys.subList(mid, full.keys.size()));
        full.keys.subList(mid, full.keys.size()).clear();
        if (!full.isLeaf) {
            sibling.children.addAll(full.children.subList(mid, full.children.size()));
            full.children.subList(mid, full.children.size()).clear();
        } else {
            sibling.next = full.next;
            full.next = sibling;
        }
        parent.keys.add(i, sibling.keys.get(0));
        parent.children.add(i + 1, sibling);
    }
    public void remove(T key) {
        List<T> all = getAllKeys();
        if (all.remove(key)) {
            destroy();
            for (T k : all) insert(k);
        }
    }
    public boolean search(T key) {
        return searchRecursive(root, key);
    }
    private boolean searchRecursive(BPlusNode<T> node, T key) {
        int i = Collections.binarySearch(node.keys, key);
        if (i >= 0 && node.isLeaf) return true;
        if (node.isLeaf) return false;

        i = i >= 0 ? i + 1 : -(i + 1);
        return searchRecursive(node.children.get(i), key);
    }
}
