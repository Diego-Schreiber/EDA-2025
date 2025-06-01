package Ejercicio;
//Autor: Diego Schreiber
//Lista doble enlazada
import java.util.LinkedList;
import java.util.ListIterator;
public class Ejercicio3{
    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            lista.add(i);
        }
        System.out.println("Lista hacia adelante:");
        for (Integer numero : lista) {
            System.out.print(numero + " ");
        }
        System.out.println();
        System.out.println("Lista hacia atras:");
        ListIterator<Integer> iterador = lista.listIterator(lista.size());
        while (iterador.hasPrevious()) {
            System.out.print(iterador.previous() + " ");
        }
        System.out.println();
    }
}
