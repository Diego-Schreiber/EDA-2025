Proceso ListaOrdenada
    Definir n, i Como Entero
    Definir estaOrdenada Como Logico
    Escribir "Ingrese el número de elementos: "
    Leer n
    Dimension numeros[n]
	
    Escribir "Ingrese los números:"
    i <- 1
    Mientras i <= n Hacer
        Leer numeros[i]
        i <- i + 1
    FinMientras
	
    estaOrdenada <- Verdadero
    i <- 2
    Mientras i <= n Y estaOrdenada Hacer
        Si numeros[i] < numeros[i - 1] Entonces
            estaOrdenada <- Falso
        Fin Si
        i <- i + 1
    FinMientras
	
    Si estaOrdenada Entonces
        Escribir "¿Está ordenada la lista?: Sí"
    Sino
        Escribir "¿Está ordenada la lista?: No"
    Fin Si
FinProceso
