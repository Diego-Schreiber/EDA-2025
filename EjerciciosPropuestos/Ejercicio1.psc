Algoritmo Ejercicio1
    Definir N, i, j, suma, media, suma_cuadrados, desviacion_estandar Como Real
    Definir calificaciones Como Real
    Definir moda Como Real
    Definir max_frecuencia, frecuencia Como Entero
	
    Escribir "Ingrese el número de estudiantes: "
    Leer N
	
    Dimension calificaciones[N]
	
    Para i = 1 Hasta N Hacer
        Escribir "Ingrese la calificación del estudiante ", i, ": "
        Leer calificaciones[i]
    FinPara
	
    CalcularOrdenar(calificaciones, N)

    Si N Mod 2 = 0 Entonces
        media <- (calificaciones[N / 2] + calificaciones[(N / 2) + 1]) / 2
    Sino
        media <- calificaciones[(N / 2) + 1]
    FinSi
    Escribir "Mediana: ", media

    max_frecuencia <- 0
    Para i = 1 Hasta N Hacer
        frecuencia <- 0
        Para j = 1 Hasta N Hacer
            Si calificaciones[i] = calificaciones[j] Entonces
                frecuencia <- frecuencia + 1
            FinSi
        FinPara
        Si frecuencia > max_frecuencia Entonces
            max_frecuencia <- frecuencia
            moda <- calificaciones[i]
        FinSi
    FinPara
    Escribir "Moda: ", moda
	
    suma <- 0
    Para i = 1 Hasta N Hacer
        suma <- suma + calificaciones[i]
    FinPara
    media <- suma / N
	
    suma_cuadrados <- 0
    Para i = 1 Hasta N Hacer
        suma_cuadrados <- suma_cuadrados + (calificaciones[i] - media) ^ 2
    FinPara
	
    desviacion_estandar <- raiz(suma_cuadrados / N)
    Escribir "Desviación Estándar: ", desviacion_estandar
FinAlgoritmo

Funcion CalcularOrdenar(calificaciones, N)
    Definir i, j, temp Como Entero
    Para i = 2 Hasta N Hacer
        temp <- calificaciones[i]
        j <- i - 1
		
        Mientras j >= 1 Y calificaciones[j] > temp Hacer
            calificaciones[j + 1] <- calificaciones[j]
            j <- j - 1
        FinMientras
		
        calificaciones[j + 1] <- temp
    FinPara
FinFuncion
