package Ejercicio;
//Autor: Diego Schreiber
//Main del ejercicio 4
import java.util.Scanner;
public class Ejercicio4 {
    public static void main(String[] args) {
        QueueList<Integer> cola = new QueueList<>();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("COLA:");
            System.out.println("1. Enqueue\n2. Dequeue\n3. Front\n4. Back\n5. isEmpty\n6. isFull\n7. Destroy\n8. Imprimir\n0. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Elemento a agregar: ");
                    cola.enqueue(sc.nextInt());
                    break;
                case 2:
                    System.out.println("Eliminado: " + cola.dequeue());
                    break;
                case 3:
                    System.out.println("Frente: " + cola.front());
                    break;
                case 4:
                    System.out.println("Final: " + cola.back());
                    break;
                case 5:
                    System.out.println("¿Vacía?: " + cola.isEmpty());
                    break;
                case 6:
                    System.out.println("¿Llena?: " + cola.isFull());
                    break;
                case 7:
                    cola.destroyQueue();
                    break;
                case 8:
                    cola.printQueue();
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opcion != 0);
    }
}
