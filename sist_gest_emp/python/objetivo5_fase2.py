#Eva Pérez Carmona

#Invocamos dentro de una función otras funciones para así ahorrarnos código.
def SumarRestar(param1, param2):
    return Sumar(param1, param2), Restar(param1, param2)

def Sumar(sumando1, sumando2):
    return sumando1 + sumando2

def Restar(minuendo, sustraendo):
    return minuendo - sustraendo

numero1 = int(input("Introduce el primer número: "))
numero2 = int(input("Introduce el segundo número: "))

resultadoSuma, resultadoResta = SumarRestar(numero1, numero2)

print("El resultado de la suma es:", resultadoSuma)
print("El resultado de la resta es:", resultadoResta)