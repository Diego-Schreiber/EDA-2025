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
}
