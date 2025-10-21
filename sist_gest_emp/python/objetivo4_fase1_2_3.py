#Eva Pérez Carmona

#Pido un número de alumos y con ellos pido los datos de dicho alumno las veces que haya introducido por pantalla. Para acabar, hago las medias tanto individuales como a nivel grupo.
print("---1---")
suma_medias = 0
aprobados = 0
alumnos_a_mejorar = 0
suspensos = 0
numero = int(input("Introduce el número de alumnos: "))
while numero <= 0 :
    numero = int(input("Introduce el número de alumnos (distinto a 0): "))

for i in range(numero):
    print ("Alumno",(i+1))
    nombre = input("Nombre: ")
    numero_notas = int(input("¿Cuántas notas tiene "+nombre+"?: "))
    suma_notas = 0
    for i in range(numero_notas):
        nota = int(input("Introduce una nota: "))
        while (nota < 0):
            nota = int(input("Introduce una nota (no puede ser negativa): "))
        suma_notas += nota
    media_notas = suma_notas / numero_notas
    suma_medias += media_notas
    if media_notas >= 5 :
        texto = "Aprobado"
        aprobados += 1
    elif 4 <= media_notas < 5 :
        texto = "Necesita mejorar"
        alumnos_a_mejorar += 1
    elif media_notas < 4:
        texto = "Suspenso"
        suspensos += 1
    print("Media de",nombre,":",media_notas,"->",texto)

print ("---MEDIA GRUPO---")
media_grupo = suma_medias / numero
print("Media del grupo:",media_grupo)
print ("Número de aprobados:",aprobados)
print("Numero de alumnos que necesitan mejorar:",alumnos_a_mejorar)
print("Número de suspensos:",suspensos)
