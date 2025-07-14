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
    private int hash(int key) {
        return (key & 0x7fffffff) % table.length;
    }
    private int nextIndex(int index) {
        return (index + 1) % table.length;
    }
}
