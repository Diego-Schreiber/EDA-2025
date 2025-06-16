package Ejercicio;
//Autor: Diego Schreiber
//Main del ejercicio 3
import java.util.Scanner;
public class Ejercicio3 {
    public static void main(String[] args) {
        BST<Integer> arbol = new BST<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa números separados por espacio para insertar en el BST:");
        String linea = sc.nextLine();
        String[] partes = linea.split("\\s+");
        for (String p : partes) {
            try {
                int val = Integer.parseInt(p);
                arbol.insert(val);
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida: " + p);
            }
        }
        System.out.println("Árbol inOrder: " + arbol.inOrder());
        arbol.graficar();
    }
}
