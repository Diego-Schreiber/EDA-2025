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

}
