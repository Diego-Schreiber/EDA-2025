package Ejercicio;
//Autor: Diego Schreiber
//Clase main de ejercicio7
import java.util.Scanner;
public class Ejercicio7 {
    public static void main(String[] args) {
        DobleEnlazamiento<Integer> lista = new DobleEnlazamiento<>();
        for (int i = 1; i <= 10; i++) {
            lista.insert(i);
        }
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n--- Menu Lista Doblemente Enlazada ---");
            System.out.println("1. Mostrar lista");
            System.out.println("2. Insertar al inicio");
            System.out.println("3. Insertar al final");
            System.out.println("4. Eliminar por clave");
            System.out.println("5. Eliminar por posicion");
            System.out.println("6. Eliminar primero");
            System.out.println("7. Eliminar ultimo");
            System.out.println("8. Tamano de la lista");
            System.out.println("9. Salir");
            System.out.print("Opcion: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    lista.printList();
                    break;
                case 2:
                    System.out.print("Dato a insertar al inicio: ");
                    lista.addFirst(scanner.nextInt());
                    break;
                case 3:
                    System.out.print("Dato a insertar al final: ");
                    lista.addLast(scanner.nextInt());
                    break;
                case 4:
                    System.out.print("Clave a eliminar: ");
                    lista.deleteByKey(scanner.nextInt());
                    break;
                case 5:
                    System.out.print("Posicion a eliminar (0-indexada): ");
                    lista.deleteAtPosition(scanner.nextInt());
                    break;
                case 6:
                    lista.removeFirst();
                    break;
                case 7:
                    lista.removeLast();
                    break;
                case 8:
                    System.out.println("Tamano de la lista: " + lista.size());
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 9);
    }
}

