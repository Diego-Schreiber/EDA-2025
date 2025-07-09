package Ejercicio;
//Autor: Diego Schreiber
//Clase Test del ejercicio 4
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ARBOL B ===");
        System.out.print("Ingrese el grado minimo del arbol (T ≥ 2): ");
        int grado = scanner.nextInt();
        if (grado < 2) {
            System.out.println("El grado debe ser al menos 2. Finalizando.");
            return;
        }
        BTree<Integer> tree = new BTree<>(grado);
        int option;
        do {
            System.out.println("\n--- MENU ARBOL B ---");
            System.out.println("1. Insertar");
            System.out.println("2. Eliminar");
            System.out.println("3. Buscar");
            System.out.println("4. Minimo");
            System.out.println("5. Maximo");
            System.out.println("6. Predecesor");
            System.out.println("7. Sucesor");
            System.out.println("8. Mostrar Arbol");
            System.out.println("9. Destruir Arbol");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            option = scanner.nextInt();
            switch (option) {
                case 1: {
                    System.out.print("Valor a insertar: ");
                    tree.insert(scanner.nextInt());
                } break;
                case 2: {
                    System.out.print("Valor a eliminar: ");
                    tree.remove(scanner.nextInt());
                }break;
                case 3: {
                    System.out.print("Valor a buscar: ");
                    System.out.println(tree.search(scanner.nextInt()) ? "Encontrado" : "No encontrado");
                }break;
                case 4: System.out.println("Minimo: " + tree.Min());break;
                case 5: System.out.println("Maximo: " + tree.Max());break;
                case 6: {
                    System.out.print("Valor para predecesor: ");
                    System.out.println("Predecesor: " + tree.Predecesor(scanner.nextInt()));
                }break;
                case 7: {
                    System.out.print("Valor para sucesor: ");
                    System.out.println("Sucesor: " + tree.Sucesor(scanner.nextInt()));
                }break;
                case 8: {
                    System.out.println("Mostrando arbol graficamente...");
                    tree.writeTree();
                }break;
                case 9: {
                    tree.destroy();
                    System.out.println("Arbol destruido.");
                }break;
                case 0: System.out.println("Saliendo...");break;
                default: System.out.println("Opcion invalida.");
            }
        } while (option != 0);
        scanner.close();
    }
}
