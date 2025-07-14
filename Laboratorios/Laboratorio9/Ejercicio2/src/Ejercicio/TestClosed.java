package Ejercicio;
//Autor: Diego Schreiber
//Clase de prueba para el hash Cerrado
import java.util.Scanner;
public class TestClosed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- INICIALIZAR HASH CERRADO ---");
        System.out.print("Ingrese el tamano inicial de la tabla hash: ");
        int tamano = scanner.nextInt();
        scanner.nextLine();
        HashClosed<String> hashTable = new HashClosed<>(tamano);
        int opcion;
        do {
            System.out.println("\n--- MENU HASH CERRADO ---");
            System.out.println("1. Insertar elemento");
            System.out.println("2. Buscar elemento");
            System.out.println("3. Eliminar elemento");
            System.out.println("4. Mostrar tabla hash");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor ingrese un numero valido.");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:{
                    System.out.print("Ingrese la clave (entero): ");
                    int clave = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el valor (texto): ");
                    String valor = scanner.nextLine();
                    hashTable.insert(new Register<>(clave, valor));
                } break;
                case 2:{
                    System.out.print("Ingrese la clave a buscar: ");
                    int clave = scanner.nextInt();
                    Register<String> resultado = hashTable.search(clave);
                    if (resultado != null) {
                        System.out.println("Valor encontrado: " + resultado.getValue());
                    } else {
                        System.out.println("Clave no encontrada.");
                    }
                } break;
                case 3:{
                    System.out.print("Ingrese la clave a eliminar: ");
                    int clave = scanner.nextInt();
                    hashTable.delete(clave);
                } break;
                case 4: hashTable.showTable(); break;
                case 0: System.out.println("Saliendo..."); break;
                default: System.out.println("Opcion invalida. Intente de nuevo.");
            }
        } while (opcion != 0);
        scanner.close();
    }
}
