package Ejercicio;
//Autor: Diego Schreiber
//Clase de prueba para clase List
public class Ejercicio1 {
    public static void main(String[] args) {
        List<Persona> personas = new List<>();
        personas.add(new Persona("Ana"));
        personas.add(new Persona("Luis"));
        personas.add(new Persona("Carlos"));
        System.out.println("Lista de personas: " + personas);
        personas.set(0, new Persona("Briis"));
        System.out.println("Despues de modificar el indice 1: " + personas);

        List<String> cadenas = new List<>();
        cadenas.add("Laptop");
        cadenas.add("Mouse");
        cadenas.add("Teclado");
        System.out.println("\nLista de productos: " + cadenas);
        cadenas.remove(1); 
        System.out.println("Despues de eliminar el indice 1: " + cadenas);
    }
}
