package Ejercicio;
//Autor: Diego Schreiber
//Clase Test
import java.util.Scanner;
public class EDALAB7 {
    public static void main(String[] args) {
        AVLTree<Integer> arbol = new AVLTree<>();
        Scanner scan = new Scanner(System.in);
        int opcion, valor;
        do {
            System.out.println("\n--- Menu AVL ---");
            System.out.println("1. Insertar");
            System.out.println("2. Eliminar");
            System.out.println("3. Buscar");
            System.out.println("4. Minimo");
            System.out.println("5. Maximo");
            System.out.println("6. Predecesor");
            System.out.println("7. Sucesor");
            System.out.println("8. InOrden");
            System.out.println("9. PreOrden");
            System.out.println("10. PostOrden");
            System.out.println("11. Vaciar arbol");
            System.out.println("12. Graficar arbol");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = scan.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Valor a insertar: ");
                    arbol.insert(scan.nextInt());
                    break;
                case 2:
                    System.out.print("Valor a eliminar: ");
                    arbol.remove(scan.nextInt());
                    break;
                case 3:
                    System.out.print("Valor a buscar: ");
                    valor = scan.nextInt();
                    System.out.println(arbol.search(valor) ? "Existe" : "No existe");
                    break;
                case 4:
                    System.out.println("Minimo: " + arbol.Min());
                    break;
                case 5:
                    System.out.println("Maximo: " + arbol.Max());
                    break;
                case 6:
                    System.out.print("Valor: ");
                    System.out.println("Predecesor: " + arbol.predecesor(scan.nextInt()));
                    break;
                case 7:
                    System.out.print("Valor: ");
                    System.out.println("Sucesor: " + arbol.sucesor(scan.nextInt()));
                    break;
                case 8:
                    arbol.inOrder();
                    break;
                case 9:
                    arbol.preOrder();
                    break;
                case 10:
                    arbol.postOrder();
                    break;
                case 11:
                    arbol.destroy();
                    System.out.println("Arbol vacio.");
                    break;
                case 12:
                    arbol.graficar();
                    break;
            }
        } while (opcion != 0);
        scan.close();
    }
}
