package Ejercicio;
//Autor: Diego Schreiber
//Clase genérica Nodo
public class Nodo<E> {
    E dato;
    Nodo<E> anterior;
    Nodo<E> siguiente;

    public Nodo(E dato) {
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }
    public E getDato(){
        return dato;
    }
    public void setDato(E d){
        dato=d;
    }
    public Nodo getSig(){
        return siguiente;
    }
    public Nodo getAnt(){
        return anterior;
    }
    public void setSig(Nodo n){
        siguiente=n;
    }
    public void setAnt(Nodo n){
        anterior=n;
    }
}
