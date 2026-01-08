print("Hola mundo")

print("1", "2", "3", sep="-", end=" FIN")
#sep → define el separador entre los elementos (por defecto es un espacio).
#end → define lo que aparece al final del mensaje (por defecto es un salto de línea).

print("Hola\nmundo")

nombre = input("¿Cómo te llamas?: ")
print("Encantado de conocerte,", nombre)

edad = int(input("¿Cuántos años tienes?: "))
print("Tienes", edad, "años.")

numero1 = int(input("Dame un número: "))
numero2 = int(input("Dame otro número: "))
print("El resultado es",(numero1+numero2))

print("¡Hola Time of Software!")
print("Este es mi primer programa con Python")


print(1, 2, 3, 4, 5)
print(1, 2, 3, 4, 5, sep=",")

print(1, 2, 3, 4, 5, sep=",", end="-")

print("¡Hola! Somos Time of Software, ¿Cómo te llamas?")
nombre = input()
print("Nos alegramos mucho de que nos hayas elegido para aprender Python,", nombre)

edad = input("¿Cuántos años tienes?: ")
print("Tienes", edad, "años.")

edad = int(input("¿Cuántos años tienes?: "))
es_mayor = (edad > 18)
print(es_mayor)
