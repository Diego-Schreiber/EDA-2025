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
}
