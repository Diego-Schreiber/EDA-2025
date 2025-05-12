Algoritmo Ejercicio2
    Definir limite, i, j, raizLimite Como Entero
    Definir esPrimo Como Entero
    Definir N Como Entero
	
    Escribir "Ingrese el límite superior del rango: "
    Leer limite
	
    raizLimite <- raiz(limite)
	
    raizLimite <- raizLimite 
    Dimension esPrimo[limite + 1]
    Para i = 0 Hasta limite Hacer
        esPrimo[i] <- 1
    FinPara
	
    esPrimo[0] <- 0
    esPrimo[1] <- 0
	
    Para i = 2 Hasta raizLimite Hacer
        Si esPrimo[i] = 1 Entonces
            Para j = i * i Hasta limite Hacer
                esPrimo[j] <- 0
            FinPara
        FinSi
    FinPara
	
    N <- 0
    Para i = 2 Hasta limite Hacer
        Si esPrimo[i] = 1 Entonces
            N <- N + 1
        FinSi
    FinPara
	
    Escribir "Los números primos hasta ", limite, " son: "
    Para i = 2 Hasta limite Hacer
        Si esPrimo[i] = 1 Entonces
            Escribir i
        FinSi
    FinPara

FinAlgoritmo
