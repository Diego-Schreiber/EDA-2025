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
}
