package Ejercicio;
//Autor: Diego Schreiber
//Clase main del Ejercicio 2
import java.util.Scanner;
public class Ejercicio2 {
    public static void main(String[] args) {
        StackList pila = new StackList();
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("1. Push\n2. Pop\n3. Top\n4. isEmpty\n5. Destroy\n6. Imprimir\n0. Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Elemento a agregar: ");
                    pila.push(sc.nextInt());
                    break;
                case 2:
                    System.out.println("Eliminado: " + pila.pop());
                    break;
                case 3:
                    System.out.println("Tope: " + pila.top());
                    break;
                case 4:
                    System.out.println("¿Vacía?: " + pila.isEmpty());
                    break;
                case 5:
                    pila.destroyStack();
                    break;
                case 6:
                    pila.printStack();
                    break;
            }
        } while (opcion != 0);
    }
}
