package Ejercicio;
//Autor: Diego Schreiber
//Clase register
public Register<E> implements Comparable <Register<E>>{
    private int key;
    private E value;
    private boolean deleted;
    public Register(int key, E value){
        this.key=key;
        this.value=value;
        this.deleted=false;
    }
    public int getKey() {
        return key;
    }
    public E getValue() {
        return value;
    }
}
