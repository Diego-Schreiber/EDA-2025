package Ejercicio;
//Autor: Diego Schreiber
//Main ejercicio2
import java.util.Scanner;
public class Ejercicio2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BST<Character> arbol = new BST<>();
        System.out.print("Ingrese una palabra: ");
        String palabra = scanner.nextLine();
        for (char c : palabra.toCharArray()) {
            arbol.insert(c);
        }
        System.out.println("Recorrido en orden (segun codigo ASCII):"+arbol.inOrder());
    }
}
