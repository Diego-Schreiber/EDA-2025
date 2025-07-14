package Ejercicio;
//Autor: Diego Schreiber
//Clase hash abierto
import java.util.LinkedList;
public class HashOpened<E>{
    private LinkedList<Register<E>>[] table;
    @SupressWarnings("unchecked")
    public HashOpened(int capacity){
        table=new LinkedList[capacity];
        for(int i=0;i<capacitu; i++){
            table[i]0new LinkedList<>();
        }
    }
    public HashOpened(){
        this(16);
    }
    private int hash(int key) {
        return (key & 0x7fffffff) % table.length;
    }
    public void insert(Register<E> reg) {
        int index = hash(reg.getKey());
        for (Register<E> r : table[index]) {
            if (r.getKey() == reg.getKey() && !r.isDeleted()) {
                System.out.println("Clave duplicada: " + reg.getKey());
                return;
            }
        }
        table[index].add(reg);
        System.out.println("Insertado: " + reg);
    }
    public void delete(int key) {
        int index = hash(key);
        for (Register<E> r : table[index]) {
            if (r.getKey() == key && !r.isDeleted()) {
                r.delete();
                System.out.println("Eliminado logicamente: " + key);
                return;
            }
        }
        System.out.println("Clave no encontrada: " + key);
    }
    public Register<E> search(int key) {
        int index = hash(key);
        for (Register<E> r : table[index]) {
            if (r.getKey() == key && !r.isDeleted()) {
                return r;
            }
        }
        return null;
    }
}
