Algoritmo Ejercicio3
    Definir n, i, j, clave Como Entero
    Definir arreglo Como Entero
	
    Escribir "Ingrese el tamaño del arreglo: "
    Leer n
	
    Dimension arreglo[n]
	
    Escribir "Ingrese los elementos del arreglo: "
    Para i = 1 Hasta n Hacer
        Escribir "Elemento ", i, ": "
        Leer arreglo[i]
    FinPara
	
    // Ordenamiento por inserción
    Para i = 2 Hasta n Hacer
        clave <- arreglo[i]
        j <- i - 1
        Mientras j >= 1 Y arreglo[j] > clave Hacer
            arreglo[j + 1] <- arreglo[j]
            j <- j - 1
        FinMientras
        arreglo[j + 1] <- clave
    FinPara
	
    Escribir "El arreglo ordenado es: "
    Para i = 1 Hasta n Hacer
        Escribir arreglo[i]
    FinPara
	
FinAlgoritmo
