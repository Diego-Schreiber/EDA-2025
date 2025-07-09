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
    public void remove(T key) {
        if (root == null) {
            return;
        }
        remove(root, key);
        if (root.keys.isEmpty()) {
            if (root.isLeaf) {
                root = null;
            } else {
                root = root.children.get(0);
            }
        }
    }
    private void remove(Node<T> node, T key) {
        int index = findKey(node, key);
        if (index < node.keys.size() && node.keys.get(index).equals(key)) {    
            if (node.isLeaf) {
                node.keys.remove(index);
            } else {
                Node<T> child = node.children.get(index);
                if (child.keys.size() > t - 1) {
                    T predecessor = getPredecessor(child);
                    node.keys.set(index, predecessor);
                    remove(child, predecessor);
                } else {
                    Node<T> nextChild = node.children.get(index + 1);                
                    if (nextChild.keys.size() > t - 1) {
                        T successor = getSuccessor(nextChild);
                        node.keys.set(index, successor);
                        remove(nextChild, successor);
                    } else {
                        fuse(node, index);
                        remove(child, key);
                    }
                }
            }
        } else {
            Node<T> child = node.children.get(index);
            if (child.keys.size() == t - 1) {
                fill(node, index);
            }
            remove(node.children.get(index), key);
        }
    }
    public boolean search(T key) {
        return search(root, key);
    }
    private boolean search(Node<T> node, T key) {
        int i = findKey(node, key);
        if (i < node.keys.size() && node.keys.get(i).equals(key)) {
            return true;
        }
        if (node.isLeaf) {
            return false;
        }
        return search(node.children.get(i), key);
    }
    public T Min() {
        if (root == null) return null;
        Node<T> node = root;
        while (!node.isLeaf) {
            node = node.children.get(0);
        }
        return node.keys.get(0);
    }
    public T Max() {
        if (root == null) return null;
        Node<T> node = root;
        while (!node.isLeaf) {
            node = node.children.get(node.children.size() - 1);
        }
        return node.keys.get(node.keys.size() - 1);
    }
}
