package Ejercicio;
//Autor: Diego Schreiber
//Clase persona para probar generacidad
public class Persona {
    private String nombre;
    public Persona(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return "Nombre='" + nombre;
    }
}
