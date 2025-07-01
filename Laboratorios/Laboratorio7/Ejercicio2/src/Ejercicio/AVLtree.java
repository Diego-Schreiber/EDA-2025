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
    public void destroy() {
        raiz = null;
    }
    private int altura(AVLNode<T> nodo) {
        return nodo == null ? 0 : nodo.altura;
    }
    private int balanceFactor(AVLNode<T> nodo) {
        return nodo == null ? 0 : altura(nodo.izquierda) - altura(nodo.derecha);
    }
}
