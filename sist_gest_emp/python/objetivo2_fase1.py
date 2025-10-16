#Eva Pérez Carmona 

#Tras pedir dos números, sacamos por pantalla las operaciones de suma,resta,multiplicación y división
print("---1---")
numero1 = int(input("Dame un número: "))
numero2 = int(input("Dame otro número: "))
print("El resultado es",(numero1+numero2))
print("El resultado es",(numero1-numero2))
print("El resultado es",(numero1*numero2))
print("El resultado es",(numero1/numero2))


#Pido tres números que clasifico como float, luego calculo el promedio sumando estos números y diviendolos por el número de números que son,
# luego se redondea con el round, poniendo en primer lugar el número que queremos redondear y segundo cuántos decimales queremos que tenga dicho redondeo.
print("---2---")
numero1 = float(input("Dame un número: "))
numero2 = float(input("Dame otro número: "))
numero3 = float(input("Dame un último número: "))
promedio = float((numero1+numero2+numero3)/3)
print("El promedio de estos números es: ",promedio)
print("El promedio redondeado es: ",round(promedio,2))


#Después de pedir por teclado dos números se hacen variables con las condiciones que pide y luego se imprimen por pantalla.
print("---3---")
numero1 = int(input("Dame un número: "))
numero2 = int(input("Dame otro número: "))
es_mayor = (numero1 > numero2)
son_iguales = (numero1 == numero2)
segundo_distinto_cero = (numero2 != 0)
print ("¿El primer número es mayor que el segundo?",es_mayor)
print ("¿El primer número y el segundo son iguales?",son_iguales)
print ("¿El segundo número es distinto de cero?",segundo_distinto_cero)


#Se piden los valores de los booleanos y se validan, una vez hecho se imprimen por pantalla las validaciones correspondientes,
#comprobaremos que están bien fijándonos en el ejemplo de los apuntes
print("---4---")
valor1 = eval(input("Introduce el primer valor lógico (True/False):"))
valor2 = eval(input("Introduce el segundo valor lógico (True/False):"))
print ("Resultado and:",valor1 and valor2)
print("Resultado or:",valor1 or valor2)
print("Resultado not primer valor:",not valor1)
print("Resultado not segundo valor:",not valor2)

#Pedimos dos números que guardaremos como string para luego pasar su valor a int, tras ello mostraremos el resultado de las operaciones pedidas.
print("---5---")
numero1 = str(input("Dame una edad: "))
numero2 = str(input("Dame otra edad: "))
valor1 = int(numero1)
valor2 = int(numero2)
print ("Suma edades:",valor1+valor2)
print("Promedio edades:",((valor1+valor2)/2))

#Se piden dos números y se sacan por pantalla las operaciones pedidas, saldrá una afirmación a negación tipo booleano.
print("---6---")
numero1 = int(input("Dame un número: "))
numero2 = int(input("Dame otro número: "))
print("(numero1 > 10) and (numero2 < 5)",(numero1 > 10) and (numero2 < 5))
print("(numero1 == numero2) or (numero2 > 0)",(numero1 == numero2) or (numero2 > 0))
print("not (numero1 < numero2)",not (numero1 < numero2))

#Se piden dos números reales y tras ello se hacen las operaciones pedidas, todas realizadas en los ejercicios de arriba.
print("---7---")
numero1 = float(input("Dame un real: "))
numero2 = float(input("Dame otro real: "))
print("División edades:",(numero1/numero2))
print("Redonde a un decimal:",round((numero1/numero2),1))



