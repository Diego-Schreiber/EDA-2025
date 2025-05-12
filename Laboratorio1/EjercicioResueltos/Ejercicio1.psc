Proceso EdadesGrupo
    Definir n, i, edad, suma, mayor, menor Como Entero
    Definir promedio Como Real
    Escribir "Ingrese el número de personas: "
    Leer n
    Dimension edades[n]
	
    Escribir "Ingrese las edades:"
    Para i <- 0 Hasta n - 1 Con Paso 1
        Leer edades[i]
    Fin Para
	
    suma <- 0
    mayor <- edades[0]
    menor <- edades[0]
	
    Para i <- 0 Hasta n - 1 Con Paso 1
        edad <- edades[i]
        suma <- suma + edad
        Si edad > mayor Entonces
            mayor <- edad
        Fin Si
        Si edad < menor Entonces
            menor <- edad
        Fin Si
    Fin Para
	
    promedio <- suma / n
	
    Escribir "Edad promedio: ", promedio
    Escribir "Edad mayor: ", mayor
    Escribir "Edad menor: ", menor
FinProceso

