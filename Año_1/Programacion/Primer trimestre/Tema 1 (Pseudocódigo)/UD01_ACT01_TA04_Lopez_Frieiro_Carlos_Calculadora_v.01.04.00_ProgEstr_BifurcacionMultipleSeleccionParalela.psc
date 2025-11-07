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
            resultado <- num1 + num2 // Realizamos la suma si la operación es "suma"
        "resta":
            resultado <- num1 - num2 // Realizamos la resta si la operación es "resta"
        "multiplicación":
            resultado <- num1 * num2 // Realizamos la multiplicación si la operación es "multiplicación"
        "división":
            Si num2 <> 0 Entonces // Comprobamos que el divisor no sea cero si la operación es "división"
                resultado <- num1 / num2 // Realizamos la división si es segura
            Sino
                Escribir "Error: No se puede dividir por cero." // Mostramos un mensaje de error si se intenta dividir por cero
            FinSi
        De Otro Modo:
            Escribir "Operación no válida" // Mostramos un mensaje si la operación no es válida
    FinSegun
	
    // Mostrar el resultado si la operación es válida
    Si operacion = "suma" o operacion = "resta" o operacion = "multiplicación" o operacion = "división" Entonces
        Escribir "Operación seleccionada: ", operacion // Mostramos la operación seleccionada
        Escribir "Resultado: ", resultado // Mostramos el resultado
    FinSi
FinAlgoritmo
