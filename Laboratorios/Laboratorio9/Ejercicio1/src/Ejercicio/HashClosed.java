package Ejercicio;
//Autor: Diego Schreiber
//Clase de hash cerrado
public class HashClosed<E>{
    private Register<E>[] table;
    private int size;
    @SupressWarnings("unchecked")
    public HashClosed(int capacity){
        table=new Register[capacity];
        size=0;
    }
    public HashClosed(){
        this(16);
    }
}
