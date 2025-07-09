package Ejercicio;
//Autor: Diego Schreiber
//Clase para arbol B+
import java.util.*;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
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
    public T Min() {
        BPlusNode<T> curr = root;
        while (!curr.isLeaf)
            curr = curr.children.get(0);
        return curr.keys.get(0);
    }
    public T Max() {
        BPlusNode<T> curr = root;
        while (!curr.isLeaf)
            curr = curr.children.get(curr.children.size() - 1);
        return curr.keys.get(curr.keys.size() - 1);
    }
    public T Predecesor(T key) {
        List<T> all = getAllKeys();
        int index = all.indexOf(key);
        if (index > 0) return all.get(index - 1);
        return null;
    }
    public T Sucesor(T key) {
        List<T> all = getAllKeys();
        int index = all.indexOf(key);
        if (index >= 0 && index < all.size() - 1) return all.get(index + 1);
        return null;
    }
    public void remove(T key) {
        List<T> all = getAllKeys();
        if (all.remove(key)) {
            destroy();
            for (T k : all) insert(k);
        }
    }
    public String toString() {
        return writeTree();
    }
    public String writeTree() {
        StringBuilder sb = new StringBuilder();
        Queue<BPlusNode<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                BPlusNode<T> node = queue.poll();
                sb.append(node.keys).append(" ");
                if (!node.isLeaf)
                    queue.addAll(node.children);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    private List<T> getAllKeys() {
        List<T> result = new ArrayList<>();
        BPlusNode<T> curr = root;
        while (!curr.isLeaf) curr = curr.children.get(0);
        while (curr != null) {
            result.addAll(curr.keys);
            curr = curr.next;
        }
        return result;
    }
    public void drawGraph() {
        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new SingleGraph("B+ Tree");
        Queue<BPlusNode<T>> queue = new LinkedList<>();
        Queue<String> names = new LinkedList<>();
        int idCounter = 0;
        queue.add(root);
        names.add("n" + (idCounter++));
        graph.addNode("n0").setAttribute("ui.label", root.keys.toString());
        while (!queue.isEmpty()) {
            BPlusNode<T> node = queue.poll();
            String parentId = names.poll();
            for (int i = 0; i < node.children.size(); i++) {
                BPlusNode<T> child = node.children.get(i);
                String childId = "n" + (idCounter++);
                org.graphstream.graph.Node gNode = graph.addNode(childId);
                gNode.setAttribute("ui.label", child.keys.toString());
                graph.addEdge(parentId + "-" + childId, parentId, childId, true);
                queue.add(child);
                names.add(childId);
            }
        }
        graph.setAttribute("ui.stylesheet", styleSheet());
        graph.display();
    }
    private String styleSheet() {
        return """
            node {
                shape: box;
                fill-color: #6699cc;
                size: 60px, 30px;
                text-size: 16px;
                text-alignment: center;
                text-color: black;
                stroke-mode: plain;
                stroke-color: black;
            }
            edge {
                arrow-size: 10px, 5px;
            }
            """;
    }
}
