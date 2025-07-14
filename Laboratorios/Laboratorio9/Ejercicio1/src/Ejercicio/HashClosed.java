package Ejercicio;
//Autor: Diego Schreiber
//Clase de hash cerrado
public class HashClosed<E>{
    private Register<E>[] table;
    private int size;
    @SupressWarnings("unchecked")
    public HashClosed(int capacity){
        table=new Register[capacity];
        size=0;
    }
    public HashClosed(){
        this(16);
    }
    private int hash(int key) {
        return (key & 0x7fffffff) % table.length;
    }
    private int nextIndex(int index) {
        return (index + 1) % table.length;
    }
    public void insert(Register<E> reg) {
        if (size == table.length) {
            System.out.println("Tabla hash llena. No se puede insertar.");
            return;
        }
        int index = hash(reg.getKey());
        int start = index;
        do {
            Register<E> current = table[index];
            if (current == null || current.isDeleted()) {
                table[index] = reg;
                size++;
                System.out.println("Insertado: " + reg);
                return;
            }
            if (current.getKey() == reg.getKey() && !current.isDeleted()) {
                System.out.println("Clave duplicada: " + reg.getKey());
                return;
            }
            index = nextIndex(index);
        } while (index != start);

        System.out.println("No se pudo insertar, tabla llena.");
    }
    public void delete(int key) {
        int index = hash(key);
        int start = index;
        do {
            Register<E> current = table[index];
            if (current == null) {
                System.out.println("Clave no encontrada: " + key);
                return;
            }
            if (current.getKey() == key && !current.isDeleted()) {
                current.delete();
                size--;
                System.out.println("Eliminado logicamente: " + key);
                return;
            }
            index = nextIndex(index);
        } while (index != start);

        System.out.println("Clave no encontrada: " + key);
    }
    public Register<E> search(int key) {
        int index = hash(key);
        int start = index;
        do {
            Register<E> current = table[index];
            if (current == null) {
                return null;
            }
            if (current.getKey() == key && !current.isDeleted()) {
                return current;
            }
            index = nextIndex(index);
        } while (index != start);
        return null;
    }
    public void showTable() {
        System.out.println("\n--- Estado de la Tabla Hash (Cerrado) ---");
        for (int i = 0; i < table.length; i++) {
            System.out.print(i + ": ");
            if (table[i] == null) {
                System.out.println("[VACIO]");
            } else {
                System.out.println(table[i]);
            }
        }
    }
}
