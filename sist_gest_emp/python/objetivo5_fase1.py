#Eva Pérez Carmona

#Hacemos una función que no reciba parámetros ni devuelva nada, que tenga como única función imprimir por pantalla.
print("--Ejercicio1--")
def Saludar() :
    print("¡Hola Time of Software!")

Saludar()

#Definimos la función EsMayorQueCero que recibe un parámetro y comprueba si el mismo es mayor que cero.
print("--Ejercicio2--")
def EsMayorQueCero(param) :
    if param > 0:
        print(param, "es mayor que cero")
    else:
        print(param, "no es mayor que cero")

numero = int(input("Introduce un número: "))
EsMayorQueCero(numero)

#Tenemos la función Sumar que recibe dos números como parámetro, los suma y devuelve su resultado.
print("--Ejercicio3--")
def Sumar(param1, param2):
    return param1 + param2

sumando1 = int(input("Introduce el primer sumando: "))
sumando2 = int(input("Introduce el segundo sumando: "))

resultado = Sumar(sumando1, sumando2)
print("El resultado de la suma es:", resultado)

#Ahora definimos la función SumarRestar que hace exactamente lo mismo que la anterior, añandiendo la resta.
print("--Ejercicio4--")
def SumarRestar(param1, param2):
    return param1 + param2, param1 - param2

numero1 = int(input("Introduce el primer número: "))
numero2 = int(input("Introduce el segundo número: "))

resultadoSuma, resultadoResta = SumarRestar(numero1, numero2)
print("El resultado de la suma es:", resultadoSuma)
print("El resultado de la resta es:", resultadoResta)
