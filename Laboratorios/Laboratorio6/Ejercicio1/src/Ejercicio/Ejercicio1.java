package Ejercicio;
//Autor: Diego Schreiber
//Clase test del ejercicio1
public class Ejercicio1 {
    public static void main(String[] args) {
        BST<Integer> arbol1=new BST<>();
        arbol1.insert(10);
        arbol1.insert(10);
        arbol1.insert(15);
        arbol1.insert(5);
        arbol1.insert(2);
        System.out.println("Inorden: "+arbol1.inOrder());
        arbol1.remove(3);
        arbol1.remove(5);
        System.out.println("Postorden: "+arbol1.postOrder());
        System.out.println(arbol1.search(10));
        arbol1.search(12);
        System.out.println("Minimo: "+arbol1.minRecover());
        System.out.println("Maximo: "+arbol1.maxRecover());
        System.out.println("Predecesor: "+arbol1.predecesor(arbol1.getRoot()));
        System.out.println("Sucesor: "+arbol1.sucesor(arbol1.getRoot()));
        System.out.println("Preorden: "+arbol1.preOrder());
        arbol1.destroy();
        System.out.println("Destruido");
        System.out.println("vacio?: "+arbol1.isEmpty());
    }
}
