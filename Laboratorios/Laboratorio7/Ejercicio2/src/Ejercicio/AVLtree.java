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
    private AVLNode<T> rotacionSimpleIzquierda(AVLNode<T> z) {
        AVLNode<T> y = z.derecha;
        AVLNode<T> T2 = y.izquierda;
        y.izquierda = z;
        z.derecha = T2;
        z.altura = Math.max(altura(z.izquierda), altura(z.derecha)) + 1;
        y.altura = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;
        return y;
    }
    private AVLNode<T> rotacionSimpleDerecha(AVLNode<T> z) {
        AVLNode<T> y = z.izquierda;
        AVLNode<T> T3 = y.derecha;
        y.derecha = z;
        z.izquierda = T3;
        z.altura = Math.max(altura(z.izquierda), altura(z.derecha)) + 1;
        y.altura = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;
        return y;
    }
}
