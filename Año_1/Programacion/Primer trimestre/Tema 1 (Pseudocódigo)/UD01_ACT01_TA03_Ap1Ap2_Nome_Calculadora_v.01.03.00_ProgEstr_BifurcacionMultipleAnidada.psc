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
	
    Escribir "Paso 3: Ingrese la operación a realizar (suma, resta, multiplicación o división):" // Solicitamos la operación
    Leer operacion // Leemos la operación ingresada por el usuario
	
    Segun operacion Hacer
        "suma": // Si la operación es suma
            resultado <- num1 + num2 // Realizamos la suma
            Escribir "Operación seleccionada: Suma"
        "resta": // Si la operación es resta
            resultado <- num1 - num2 // Realizamos la resta
            Escribir "Operación seleccionada: Resta"
        "multiplicación": // Si la operación es multiplicación
            resultado <- num1 * num2 // Realizamos la multiplicación
            Escribir "Operación seleccionada: Multiplicación"
        "división": // Si la operación es división
            Si num2 <> 0 Entonces // Comprobamos que el divisor no sea cero
                resultado <- num1 / num2 // Realizamos la división
                Escribir "Operación seleccionada: División"
            Sino
                Escribir "Error: No se puede dividir por cero." // Mostramos un mensaje de error si se intenta dividir por cero
            FinSi
        De Otro Modo: // Si la operación no es ninguna de las anteriores
            Escribir "Operación no válida" // Mostramos un mensaje de operación no válida
    FinSegun
	
    Si operacion = "suma" o operacion = "resta" o operacion = "multiplicación" o operacion = "división" Entonces // Si la operación es válida
        Escribir "Resultado: ", resultado // Mostramos el resultado
    FinSi
FinAlgoritmo

