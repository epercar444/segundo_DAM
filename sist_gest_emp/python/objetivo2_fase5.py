#Eva Pérez Carmona

#He pedido al usuario una cadena y le he cambiado los formatos, luego los he sacado por pantalla.
frase = input("Introduce una frase o palabra: ")
print("--- FORMATO DE TEXTO ---")
print("Capitalizada:",frase.capitalize())
print("Mayúsculas:",frase.upper())
print("Minúsculas:",frase.lower())
print("Invertida:",frase.swapcase())


#He mostrado por pantalla información de la frase.
print("--- ANÁLISIS DEL CONTENIDO ---")
print("¿Solo letras?:",frase.isalpha())
print("¿Solo números?:",frase.isdigit())
print("¿Letras y números?:",frase.isalnum())
print("¿Está en minúsculas?:",frase.islower())
print("¿Está en mayúsculas?:",frase.isupper())


#Mostramos número total de carácteres y carácteres reales.
frase_replace = frase.replace(" ","")
print("--- LONGITUD ---")
print("Número total de caracteres:",len(frase))
print("Caracteres reales (sin espacio):",len(frase_replace))


#Mostramos por pantalla la frase sin espacios sobrantes.
print("--- LIMPIEZA ---")
print("Sin espacios al principio:",frase.strip())
print("Sin espacios al final:",frase.lstrip())
print("Sin espacios en ambos lados:",frase.rstrip())


#Reemplazamos una palabra de la frase y la mostramos por pantalla.
print("--- REEMPLAZO CARÁCTERES ---")
antiguo = input("Palabra a buscar: ")
nuevo = input("Palabra nueva: ")
print("Frase modificada:",frase.replace(antiguo,nuevo))


#Ordeno los carácteres alfabéticamente y muestro por pantalla el resultado.
print("--- CARÁCTERES ---")
print("Carácter mayor:",max(frase))
print("Carácter menor:",min(frase))

#Separo la frase en una lista de palabras y su número de carácteres.
frase_split = frase.split()
print("--- LISTA DE PALABRAS ---")
print("Lista:",frase_split)
print("Número de palabras:",len(frase_split))


#Separo el texto mediante el carácter "/" y lo imprimo en la consola.
print("--- DIVISIÓN POR '/' ---")
print("Resultado del split ('/'):",frase.split("/"))










