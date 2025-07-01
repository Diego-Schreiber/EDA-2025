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
    public void insert(T valor) {
        raiz = insertar(raiz, valor);
    }
    private AVLNode<T> insertar(AVLNode<T> nodo, T valor) {
        if (nodo == null) return new AVLNode<>(valor);
        if (valor.compareTo(nodo.valor) < 0)
            nodo.izquierda = insertar(nodo.izquierda, valor);
        else if (valor.compareTo(nodo.valor) > 0)
            nodo.derecha = insertar(nodo.derecha, valor);
        else
            return nodo; 
        nodo.altura = 1 + Math.max(altura(nodo.izquierda), altura(nodo.derecha));
        int balance = balanceFactor(nodo);
        if (balance > 1 && valor.compareTo(nodo.izquierda.valor) < 0)
            return rotacionSimpleDerecha(nodo);
        if (balance < -1 && valor.compareTo(nodo.derecha.valor) > 0)
            return rotacionSimpleIzquierda(nodo);
        if (balance > 1 && valor.compareTo(nodo.izquierda.valor) > 0) {
            nodo.izquierda = rotacionSimpleIzquierda(nodo.izquierda);
            return rotacionSimpleDerecha(nodo);
        }
        if (balance < -1 && valor.compareTo(nodo.derecha.valor) < 0) {
            nodo.derecha = rotacionSimpleDerecha(nodo.derecha);
            return rotacionSimpleIzquierda(nodo);
        }
        return nodo;
    }
    public void remove(T valor) {
        raiz = eliminar(raiz, valor);
    }
    private AVLNode<T> eliminar(AVLNode<T> nodo, T valor) {
        if (nodo == null) return null;
        if (valor.compareTo(nodo.valor) < 0)
            nodo.izquierda = eliminar(nodo.izquierda, valor);
        else if (valor.compareTo(nodo.valor) > 0)
            nodo.derecha = eliminar(nodo.derecha, valor);
        else {
            if (nodo.izquierda == null || nodo.derecha == null) {
                nodo = (nodo.izquierda != null) ? nodo.izquierda : nodo.derecha;
            } else {
                AVLNode<T> sucesor = minNode(nodo.derecha);
                nodo.valor = sucesor.valor;
                nodo.derecha = eliminar(nodo.derecha, sucesor.valor);
            }
        }
        if (nodo == null) return null;
        nodo.altura = 1 + Math.max(altura(nodo.izquierda), altura(nodo.derecha));
        int balance = balanceFactor(nodo);
        if (balance > 1 && balanceFactor(nodo.izquierda) >= 0)
            return rotacionSimpleDerecha(nodo);
        if (balance > 1 && balanceFactor(nodo.izquierda) < 0) {
            nodo.izquierda = rotacionSimpleIzquierda(nodo.izquierda);
            return rotacionSimpleDerecha(nodo);
        }
        if (balance < -1 && balanceFactor(nodo.derecha) <= 0)
            return rotacionSimpleIzquierda(nodo);
        if (balance < -1 && balanceFactor(nodo.derecha) > 0) {
            nodo.derecha = rotacionSimpleDerecha(nodo.derecha);
            return rotacionSimpleIzquierda(nodo);
        }
        return nodo;
    }
}
