Algoritmo Calculadora
    Definir num1, num2, resultado Como Entero // Definimos las variables num1, num2 y resultado como enteros
    Definir operacion Como Caracter // Definimos la variable operacion como un carácter
	
    Escribir "Calculadora Simple" // Mensaje de bienvenida
    Escribir "------------------"
	
    Escribir "Paso 1: Ingrese el primer valor entero:" // Solicitamos al usuario el primer número
    Leer num1 // Leemos el primer número ingresado por el usuario
	
    Escribir "Paso 2: Ingrese el segundo valor entero:" // Solicitamos al usuario el segundo número
    Leer num2 // Leemos el segundo número ingresado por el usuario
	
    Escribir "Valores ingresados:" // Mostramos los valores ingresados por el usuario
    Escribir "Número 1: ", num1
    Escribir "Número 2: ", num2
	
    Escribir "Paso 3: Ingrese la operación a realizar (suma, resta, multiplicación o división):"
    Leer operacion // Leemos la operación ingresada por el usuario
	
    // Evaluación en paralelo de la operación
    Segun operacion Hacer
        "suma":
            resultado <- 0
            Para i <- 1 Hasta num2 Hacer
                resultado <- resultado + num1 // Realizamos la suma utilizando un bucle FOR
            FinPara
        "resta":
            resultado <- 0
            Mientras num1 > num2 Hacer
                resultado <- resultado + 1
                num1 <- num1 - num2 // Realizamos la resta utilizando un bucle WHILE
            FinMientras
        "multiplicación":
            resultado <- 0
            Para i <- 1 Hasta num2 Hacer
                resultado <- resultado + num1 // Realizamos la multiplicación utilizando un bucle FOR
            FinPara
        "división":
            resultado <- 0
            Mientras num1 >= num2 Hacer
                resultado <- resultado + 1
                num1 <- num1 - num2 // Realizamos la división utilizando un bucle WHILE
            FinMientras
        De Otro Modo:
            Escribir "Operación no válida"
    FinSegun
	
    // Mostrar el resultado si la operación es válida
    Si operacion = "suma" o operacion = "resta" o operacion = "multiplicación" o operacion = "división" Entonces
        Escribir "Operación seleccionada: ", operacion // Mostramos la operación seleccionada
        Escribir "Resultado: ", resultado // Mostramos el resultado
    FinSi
FinAlgoritmo
