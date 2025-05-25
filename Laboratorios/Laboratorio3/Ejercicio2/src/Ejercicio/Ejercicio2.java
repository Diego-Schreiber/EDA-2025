package Ejercicio;
//Autor: Diego Schreiber
//Clase main para el ejercicio2
import java.util.Scanner;
public class Ejercicio2 {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int opcion=0;
        double rpta=0;
        while(opcion!=8){
            double v=0;
            System.out.println("1.Suma\n2.Resta\n3.Producto\n4.Division\n5.Potencia\n6.Raiz Cuadrada\n7.Raiz cubica\n8.Salir");
            System.out.print("Ingrese operacion: ");
            opcion=scan.nextInt();
            if(opcion>0&&opcion<6){
                System.out.print("Ingrese dato: ");
                v=scan.nextDouble();
            }
            System.out.print("Ingrese dato: ");
            double v1=scan.nextDouble();
            switch(opcion){
                case 1: rpta=suma(v,v1); break;
                case 2: rpta=resta(v,v1); break;
                case 3: rpta=producto(v,v1); break;
                case 4: rpta=division(v,v1); break;
                case 5: rpta=potencia(v,v1); break;
                case 6: rpta=raizCuadrada(v1); break;
                case 7: rpta=raizCubica(v1); break;
                case 8: System.out.println("Chau"); break;
                default: System.out.println("Operacion invalida"); break;
            }
        }
    }
    static <T extends Number>double suma(T valor1, T valor2){
        return valor1.doubleValue()+valor2.doubleValue();
    }
    static <T extends Number>double resta(T valor1, T valor2){
        return valor1.doubleValue()-valor2.doubleValue();
    }
    static <T extends Number>double producto(T valor1, T valor2){
        return valor1.doubleValue()*valor2.doubleValue();
    }
    static <T extends Number>double division(T valor1, T valor2){
        return valor1.doubleValue()/valor2.doubleValue();
    }
    static <T extends Number>double potencia(T valor1, T valor2){
        return Math.pow(valor1.doubleValue(),valor2.doubleValue());
    }
    static <T extends Number> double raizCuadrada(T numero) {
        return Math.sqrt(numero.doubleValue());
    }
    static <T extends Number> double raizCubica(T numero) {
        return Math.cbrt(numero.doubleValue());
    }
}
