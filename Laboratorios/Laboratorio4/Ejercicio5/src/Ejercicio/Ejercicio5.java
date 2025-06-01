package Ejercicio;
//Autor: Diego Schreiber
//Main del ejercicio5
import java.util.Scanner;
public class Ejercicio5 {
    public static void main(String[] args) {
        listaEnlazada lista = new listaEnlazada();
        for (int i = 1; i <= 10; i++) {
            lista.insert(i);
        }
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n--- Menu Lista Enlazada Simple ---");
            System.out.println("1. Mostrar lista");
            System.out.println("2. Insertar al final");
            System.out.println("3. Insertar al inicio");
            System.out.println("4. Eliminar por clave");
            System.out.println("5. Eliminar por posicion");
            System.out.println("6. Eliminar primero");
            System.out.println("7. Eliminar ultimo");
            System.out.println("8. Tamano de la lista");
            System.out.println("9. Salir");
            System.out.print("Elige una opcion: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    lista.printList();
                    break;
                case 2:
                    System.out.print("Dato a insertar al final: ");
                    int datoFinal = scanner.nextInt();
                    lista.addLast(datoFinal);
                    break;
                case 3:
                    System.out.print("Dato a insertar al inicio: ");
                    int datoInicio = scanner.nextInt();
                    lista.addFirst(datoInicio);
                    break;
                case 4:
                    System.out.print("Clave a eliminar: ");
                    int clave = scanner.nextInt();
                    lista.deleteByKey(clave);
                    break;
                case 5:
                    System.out.print("Posicion a eliminar (0-indexada): ");
                    int pos = scanner.nextInt();
                    lista.deleteAtPosition(pos);
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
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 9);
    }
}
