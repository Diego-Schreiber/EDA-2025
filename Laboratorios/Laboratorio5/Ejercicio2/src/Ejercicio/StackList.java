package Ejercicio;
//Autor:Diego Hans Schreiber Landeo
//Clase stack
public class StackList<T>{
    private Nodo<T> cima;
    public StackList(){
        cima=null;
    }
    public void push(T dato){
        Nodo<T> nuevo =new Nodo<>(dato);
        nuevo.setSiguiente(cima);
        cima=nuevo;
    }
    public T pop() {
        if (isEmpty()) throw new RuntimeException("Pila vacía");
        T dato = cima.getDato();
        cima = cima.getSiguiente();
        return dato;
    }
    public T top() {
        if (isEmpty()) throw new RuntimeException("Pila vacía");
        return cima.getDato();
    }
    public boolean isEmpty() {
        return cima == null;
    }
    public boolean isFull() {
        return false;
    }
    public void destroyStack() {
        cima = null;
    }
    public void printStack() {
        Nodo<T> actual = cima;
        while (actual != null) {
            System.out.print(actual.getDato() + " ");
            actual = actual.getSiguiente();
        }
        System.out.println();
    }
}
