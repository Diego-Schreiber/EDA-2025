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
    private AVLNode<T> minNode(AVLNode<T> nodo) {
        while (nodo.izquierda != null) nodo = nodo.izquierda;
        return nodo;
    }
    private AVLNode<T> maxNode(AVLNode<T> nodo) {
        while (nodo.derecha != null) nodo = nodo.derecha;
        return nodo;
    }
    public T Min() {
        return isEmpty() ? null : minNode(raiz).valor;
    }
    public T Max() {
        return isEmpty() ? null : maxNode(raiz).valor;
    }
    public boolean search(T valor) {
        return buscar(raiz, valor);
    }
    private boolean buscar(AVLNode<T> nodo, T valor) {
        if (nodo == null) return false;
        if (valor.compareTo(nodo.valor) == 0) return true;
        return valor.compareTo(nodo.valor) < 0
            ? buscar(nodo.izquierda, valor)
            : buscar(nodo.derecha, valor);
    }
    public T predecesor(T valor) {
        AVLNode<T> nodo = raiz;
        T pred = null;
        while (nodo != null) {
            if (valor.compareTo(nodo.valor) > 0) {
                pred = nodo.valor;
                nodo = nodo.derecha;
            } else {
                nodo = nodo.izquierda;
            }
        }
        return pred;
    }
    public T sucesor(T valor) {
        AVLNode<T> nodo = raiz;
        T succ = null;
        while (nodo != null) {
            if (valor.compareTo(nodo.valor) < 0) {
                succ = nodo.valor;
                nodo = nodo.izquierda;
            } else {
                nodo = nodo.derecha;
            }
        }
        return succ;
    }
    public void inOrder() {
        inOrder(raiz);
        System.out.println();
    }
    private void inOrder(AVLNode<T> nodo) {
        if (nodo != null) {
            inOrder(nodo.izquierda);
            System.out.print(nodo.valor + " ");
            inOrder(nodo.derecha);
        }
    }
}
