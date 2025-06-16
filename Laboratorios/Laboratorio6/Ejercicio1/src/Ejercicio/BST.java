package Ejercicio;
//Autor: Diego Schreiber
//Clase arbol binario de busqueda
public class BST <T extends Comparable> {
    private Node<T> root;
    public BST (){
        this(null);
    }
    public BST (Node<T> r){
        root=r;
    }
    public Node<T> getRoot(){
        return root;
    }
    public boolean isEmpty(){
        return root==null;
    }
    public void destroy(){
        root=null;
    }
    public void insert(T x){
        this.root = insertNode(x, this.root);
    }
    protected Node<T> insertNode(T x, Node<T> actual) {
        if (actual == null) {
            return new Node<>(x);
        }
        int resC = actual.getDato().compareTo(x);
        if (resC == 0) {
            System.out.println(x + " esta duplicado");
        } else if (resC < 0) {
            actual.setRight(insertNode(x, actual.getRight()));
        } else {
            actual.setLeft(insertNode(x, actual.getLeft()));
        }
        return actual;
    }
}
