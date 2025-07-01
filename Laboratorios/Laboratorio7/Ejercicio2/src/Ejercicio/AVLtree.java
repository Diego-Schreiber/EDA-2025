package Ejercicio;
//Autor: Diego Schreiber
//Clase arbol AVL
public class AVLTree<T extends Comparable<T>> {
    private AVLNode<T> raiz;
    public AVLTree (){
        raiz=null;
    }
    public boolean isEmpty() {
        return raiz == null;
    }
}
