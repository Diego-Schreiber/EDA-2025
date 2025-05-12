Proceso EdadesGrupo
    Definir n, i, edad, suma, mayor, menor Como Entero
    Definir promedio Como Real
    Escribir "Ingrese el número de personas: "
    Leer n
    Dimension edades[n]
    
    Escribir "Ingrese las edades:"
    i <- 1
    Mientras i <= n Hacer
        Leer edades[i]
        i <- i + 1
    FinMientras
	
    suma <- 0
    mayor <- edades[1]
    menor <- edades[1]
	
    i <- 1
    Mientras i <= n Hacer
        edad <- edades[i]
        suma <- suma + edad
        Si edad > mayor Entonces
            mayor <- edad
        Fin Si
        Si edad < menor Entonces
            menor <- edad
        Fin Si
        i <- i + 1
    FinMientras
	
    promedio <- suma / n
	
    Escribir "Edad promedio: ", promedio
    Escribir "Edad mayor: ", mayor
    Escribir "Edad menor: ", menor
FinProceso