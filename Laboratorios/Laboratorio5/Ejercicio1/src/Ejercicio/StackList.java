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
}
