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
    public void remove(T x){
        this.root = removeNode(x, this.root);
    }
    protected Node<T> removeNode(T x, Node<T> actual) {
        if (actual == null) {
            System.out.println(x + " no esta");
            return null;
        }
        int resC = actual.getDato().compareTo(x);
        if (resC < 0) {
            actual.setRight(removeNode(x, actual.getRight()));
        } else if (resC > 0) {
            actual.setLeft(removeNode(x, actual.getLeft()));
        } else {
            if (actual.getLeft() != null && actual.getRight() != null) {
                Node<T> min = minRecover(actual.getRight());
                actual.setDato(min.getDato());
                actual.setRight(minRemove(actual.getRight()));
            } else {
                actual = (actual.getLeft() != null) ? actual.getLeft() : actual.getRight();
            }
        }
        return actual;
    }
    public T minRemove() {
        T min = minRecover();
        this.root = minRemove(this.root);
        return min;
    }
    protected Node<T> minRemove(Node<T> actual) {
        if (actual.getLeft() != null) {
            actual.setLeft(minRemove(actual.getLeft()));
        }
        else {
            actual = actual.getRight();
        }
        return actual;
    }
    public T search(T x){
        Node<T> res = searchNode(x, root);
        if(res == null){
            System.out.println("El dato "+ x + " no esta");
            return null;
        }
        return res.getDato();
    }
    protected Node<T> searchNode(T x, Node<T> n){
        if (n == null) return null;
        else {
            int resC = n.getDato().compareTo(x);
        if (resC < 0) return searchNode(x, n.getRight());
        else if (resC > 0) return searchNode(x, n.getLeft());
        else return n;
        }
    }
    public T minRecover(){
        return minRecover(this.root).getDato();
    }
    public Node<T> minRecover(Node<T> subArbol){
        Node<T> actual=subArbol;
        while(actual.getLeft() != null){
            actual=actual.getLeft();
        }
        return actual;
    }
    public T maxRecover(){
        return maxRecover(this.root).getDato();
    }
    public Node<T> maxRecover(Node<T> subArbol){
        Node<T> actual=subArbol;
        while(actual.getRight() != null){
            actual=actual.getRight();
        }
        return actual;
    }
    public String postOrder(){
        if (this.root != null) return postOrder(this.root);
        else return "*";
    }
    protected String postOrder(Node<T> actual){
        String res = "";
        if (actual.getLeft() != null) res += postOrder(actual.getLeft());
        if (actual.getRight() != null) res += postOrder(actual.getRight());
        return res + actual.getDato().toString() + ",";
    }
    public String preOrder(){
        if (this.root != null) return preOrder(this.root);
        else return "*";
    }
    protected String preOrder(Node<T> actual){
        String res = "";
        res += actual.getDato().toString() + ",";
        if (actual.getLeft() != null) res += preOrder(actual.getLeft());
        if (actual.getRight() != null) res += preOrder(actual.getRight());
        return res;
    }
    public String inOrder(){
        if (this.root != null) return inOrder(this.root);
        else return "*";
    }
    protected String inOrder(Node<T> actual){
        String res = "";
        if (actual.getLeft() != null) res += inOrder(actual.getLeft());
        res += actual.getDato().toString() + ","; 
        if (actual.getRight() != null) res += inOrder(actual.getRight());
        return res;
    }
    public T sucesor(Node<T> n){
        Node<T> actual=n.getRight();
        while(actual.getLeft()!=null)
            actual=actual.getLeft();
        return actual.getDato();
    }
    public T predecesor(Node<T> n){
        Node<T> actual=n.getLeft();
        while(actual.getRight()!=null)
            actual=actual.getRight();
        return actual.getDato();
    }
}
