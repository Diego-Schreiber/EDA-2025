package Ejercicio;
//Autor: Diego Schreiber
//Clase operador genérica
public class Operador <T extends Number>{
    private T valor1;
    private T valor2;
    
    public Operador(T v1, T v2){
        this.valor1=v1;
        this.valor2=v2;
    }
}
