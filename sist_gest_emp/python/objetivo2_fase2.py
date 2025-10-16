#Eva Pérez Carmona 
#He hecho mediante \n que significa salto de línea
#\t que significa tabulación, es decir, un espaciado más grande al normal
#Por último, en la línea de la ruta he decidido concatenar con + para evitar los espacios que Python introduce por defecto concatenando con las comas.



print("---1---")
nombre = str(input("Dame tu nombre: "))
curso = str(input("Dame tu curso: "))
grupo = str(input("Dame tu grupo: "))
carpeta = str(input("Dame tu carpeta de proyecto(nombre): "))

print("------------------------------",
"\n\tFicha del alumno/a",
"\n------------------------------",
"\nNombre:",(nombre),
"\nCurso:",(curso),"\tGrupo:",(grupo),
"\nRuta del proyecto: C:\\Users\\"+nombre+"\\DAM\\"+(carpeta),
"\n------------------------------")





