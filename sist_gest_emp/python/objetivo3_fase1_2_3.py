#Eva Pérez Carmona

#Pido un número entero y tras comparar su valor, imprimo si es mayor o menor que 0.
print("---1---")
numero = int(input("Dame un número: "))
if numero > 0:
    print("El número es positivo")
elif numero < 0:
    print("El número es negativo")
else :
    print ("El número es 0")


#Hago lo mismo que el en caso anterior pero en vez de comparar con el 0, comparo por un segundo número pedido.
print("---2---")
numero1 = int(input("Dame un número: "))
numero2 = int(input("Dame otro número: "))
if numero1 > numero2:
    print("El primero es mayor que el segundo")
elif numero2 > numero1:
    print("El segundo es mayor que el primero")
else :
    print("Ambos son iguales")


#Pido por pantalla una frase y una plaabra, si la frase contiene dicha palaba haremos una condición, sino, otra.
print("---3---")
frase = input("Introduce una frase: ")
palabra = input("Introduce la palabra a buscar: ")
if palabra in frase :
    print("La palabra está en la frase")
else :
    print("La palabra no se encuentra")


#Verficiar varias características mediante condiciones.
print("---4---")
mayusculas = tuple("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
texto = input("Introduce un texto: ")
empieza_mayuscula = texto.startswith(mayusculas)
termina_punto = texto.endswith(".")
if empieza_mayuscula and termina_punto:
    print("Empieza por mayúscula y termina en punto.")
elif empieza_mayuscula:
    print("Empieza por mayúscula.")
elif termina_punto:
    print("Termina en punto.")
else:
    print("El texto no cumple las condiciones.")



#Pido por pantalla una nota y saco el valor de la misma.
print("---5---")
nota = int(input("Dame tu nota: "))
if 0 <= nota <= 4 :
    print("Insuficiente")
elif nota == 5 :
    print ("Suficiente")
elif nota == 6 :
    print("Bien")
elif nota == 7 or nota == 8 :
    print("Notable")
elif nota== 9 or nota == 10 :
    print("Sobresaliente")
else :
    print("Nota no válida")
