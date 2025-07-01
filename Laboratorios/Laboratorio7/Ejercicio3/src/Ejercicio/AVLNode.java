package Ejercicio;
//Autor: Diego Schreiber
//Clase nodo para el arbol AVL
public class AVLNode<T extends Comparable<T>>{
    T valor;
    AVLNode<T> izquierda, derecha;
    int altura;
    public AVLNode(T valor) {
        this.valor = valor;
        this.altura = 1;
    }
    public void setValor(T v){
        valor=v;
    }
    public T getValor(){
        return valor;
    }
    public void setIzquierda(AVLNode i){
        izquierda=i;
    }
    public AVLNode getIzquierda(){
        return izquierda;
    }
    public void setDerecha(AVLNode d){
        izquierda=d;
    }
    public AVLNode getDerecha(){
        return derecha;
    }
    public void setAltura(int a){
        altura=a;
    }
    public int getAltura(){
        return altura;
    }
}
