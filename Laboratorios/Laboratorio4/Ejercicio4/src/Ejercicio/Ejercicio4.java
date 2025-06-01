package Ejercicio;
//Autor: Diego Schreiber
//Main del ejercicio4
import java.util.LinkedList;
public class Ejercicio4{
    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();
        for (int i = 1; i <= 12; i++) {
            lista.add(i);
        }
        System.out.println("Recorrido circular (2 ciclos):");
        int ciclos = 2;
        int total = lista.size() * ciclos;
        int index = 0;
        for (int i = 0; i < total; i++) {
            System.out.print(lista.get(index) + " ");
            index = (index + 1) % lista.size(); 
        }
        System.out.println();
    }
}
