# Eva Pérez Carmona

#He realizado los menús y las operaciones qe piden y he estructura la clase para que salgan los menús cuando los necesito y haciendo las llamadas a las clases que necesito.

import math

def MostrarMenu():
    print("\n--- MENÚ DE LA CALCULADORA ---")
    print("1. Sumar")
    print("2. Restar")
    print("3. Multiplicar")
    print("4. Dividir")
    print("5. Operaciones avanzadas")
    print("6. Salir")

def MostrarSubMenu():
    print("\n--- OPERACIONES AVANZADAS ---")
    print("A. Potencia")
    print("B. Raíz cuadrada")
    print("C. Módulo")
    print("D. Volver")

def Sumar():
    numero1 = float(input("Introduce el primer número: "))
    numero2 = float(input("Introduce el segundo número: "))
    return round(numero1 + numero2, 2)

def Restar():
    numero1 = float(input("Introduce el primer número: "))
    numero2 = float(input("Introduce el segundo número: "))
    return round(numero1 - numero2, 2)

def Multiplicar():
    numero1 = float(input("Introduce el primer número: "))
    numero2 = float(input("Introduce el segundo número: "))
    return round(numero1 * numero2, 2)

def Dividir():
    numero1 = float(input("Introduce el primer número: "))
    numero2 = float(input("Introduce el segundo número: "))
    while numero2 == 0:
        print("Error: No se puede dividir entre cero.")
        numero2 = float(input("Introduce el segundo número: "))
    return round(numero1 / numero2, 2)

def Potencia():
    numero1 = float(input("Introduce el número base: "))
    potencia = float(input("Introduce la potencia: "))
    return round(numero1 ** potencia, 2)

def RaizCuadrada():
    numero1 = float(input("Introduce un número: "))
    while numero1 < 0:
        print("Error: No se puede calcular la raíz cuadrada de un número negativo.")
        numero1 = float(input("Introduce un número: "))
    return round(math.sqrt(numero1), 2)

def Modulo():
    numero1 = float(input("Introduce el dividendo: "))
    numero2 = float(input("Introduce el divisor: "))
    while numero2 == 0:
        print("Error: No se puede dividir entre cero.")
        numero2 = float(input("Introduce el divisor: "))
    return round(numero1 % numero2, 2)


opcion = 0

while opcion != 6:
    MostrarMenu()
    opcion = int(input("Selecciona una opción: "))

    if opcion == 1:
        print("Resultado:", Sumar())
    elif opcion == 2:
        print("Resultado:", Restar())
    elif opcion == 3:
        print("Resultado:", Multiplicar())
    elif opcion == 4:
        print("Resultado:", Dividir())
    elif opcion == 5:
        sub_opcion = ""
        while sub_opcion != "D":
            MostrarSubMenu()
            sub_opcion = input("Selecciona una opción avanzada: ").upper()

            if sub_opcion == "A":
                print("Resultado:", Potencia())
            elif sub_opcion == "B":
                print("Resultado:", RaizCuadrada())
            elif sub_opcion == "C":
                print("Resultado:", Modulo())
            elif sub_opcion == "D":
                print("Volviendo al menú principal.")
            else:
                print("Opción no válida. Intenta de nuevo.")
    elif opcion == 6:
        print("Saliendo del programa.")
    else:
        print("Opción no válida. Intenta de nuevo.")
