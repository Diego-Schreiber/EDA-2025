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
    public void insert(T key) {
        if (root.keys.size() == 2 * t - 1) {
            Node<T> newRoot = new Node<>(false);
            newRoot.children.add(root);
            root = newRoot;
            split(root, 0);
        }
        insertNonFull(root, key);
    }
    private void insertNonFull(Node<T> node, T key) {
        int i = node.keys.size() - 1;
        if (node.isLeaf) {
            node.keys.add(null);
            while (i >= 0 && key.compareTo(node.keys.get(i)) < 0) {
                node.keys.set(i + 1, node.keys.get(i));
                i--;
            }
            node.keys.set(i + 1, key);
        } else {
            while (i >= 0 && key.compareTo(node.keys.get(i)) < 0) {
                i--;
            }
            i++;

            Node<T> child = node.children.get(i);
            if (child.keys.size() == 2 * t - 1) {
                split(node, i);
                if (key.compareTo(node.keys.get(i)) > 0) {
                    i++;
                }
            }
            insertNonFull(node.children.get(i), key);
        }
    }
    private void split(Node<T> parent, int index) {
        Node<T> fullNode = parent.children.get(index);
        Node<T> newNode = new Node<>(fullNode.isLeaf);
        T midKey = fullNode.keys.get(t - 1);
        List<T> keysToMove = new ArrayList<>(fullNode.keys.subList(t, fullNode.keys.size()));
        newNode.keys.addAll(keysToMove);
        fullNode.keys.subList(t - 1, fullNode.keys.size()).clear();
        if (!fullNode.isLeaf) {
            List<Node<T>> childrenToMove = fullNode.children.subList(t, fullNode.children.size());
            for (Node<T> child : childrenToMove) {
                newNode.children.add(child);
            }
            childrenToMove.clear();
        }
        parent.keys.add(index, midKey);
        parent.children.add(index + 1, newNode);
    }
}
