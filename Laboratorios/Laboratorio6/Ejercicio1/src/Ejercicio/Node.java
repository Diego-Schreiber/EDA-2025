package Ejercicio;
//Autor: Diego Schreiber
//Clase nodo para BST
public class Node <T extends Comparable>{
    private T dato;
    private Node<T> left;
    private Node<T> right;
    public Node(T d, Node<T> l, Node<T> r){
        dato=d;
        left=l;
        right=r;
    }
    public Node(T d){
        this(d,null,null);
    }
}
