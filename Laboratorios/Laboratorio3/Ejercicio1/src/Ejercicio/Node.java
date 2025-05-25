package Ejercicio;
//Autor: Diego Schreiber
//Clase genérica Node
public class Node <T>{
    T dato;
    Node nextNode;
    public Node(T d){
        dato=d;
    }
    public T getDato(){
        return dato;
    }
    public void setDato(T d){
        dato=d;
    }
    public void setNextNode(Node n){
        nextNode=n;
    }
    public Node getNextNode(){
        return nextNode;
    }
}
