#Eva Pérez Carmona

#Definimos las clases que nos piden, montamos su constructor y sus métodos.
#Montamos los métodos del menú principal haciendo llamadas a las clases creadas.
#Por último, definimos que queremos que pase por cada opción del menú que seleccionemos.


class Autor :
    def __init__(self,nombre,apellidos):
        self.nombre = nombre
        self.apellidos = apellidos
    
    def MostrarAutor(self) :
        print("El autor es",self.nombre,self.apellidos)

    
class Libro:
    def __init__(self,titulo,ISBN):
        self.titulo = titulo
        self.ISBN = ISBN
        self.autor = None

    def AnadirAutor(self,autor) :
        self.autor = autor

    def MostrarLibro (self) :
        print ("La información del libro es: " \
        "titulo ->",self.titulo, \
        "ISBN ->",self.ISBN, \
        "autor ->"),self.autor.MostrarAutor()

    def ObtenerTitulo (self) :
        return self.titulo
    

class Biblioteca :
    def __init__(self,listaLibros):
        self.listaLibros = listaLibros

    def NumeroLibros (self) :
        return len(self.listaLibros)
    
    def AnadirLibro (self,libro) :
        if libro not in self.listaLibros :
            self.listaLibros.append(libro)

    def BorrarLibro (self,titulo) :
        for libro in self.listaLibros :
            if (libro.titulo == titulo) :
                self.listaLibros.remove(libro)
                print("Libro eliminado correctamente")

    def MostrarBiblioteca(self):
        for libro in self.listaLibros:
            print(libro.MostrarLibro())



def MostrarMenu():
    print("--- MENÚ DE LA BIBLIOTECA ---")
    print("1. Añadir libro a la biblioteca")
    print("2. Mostrar biblioteca")
    print("3. Borrar libro de la biblioteca")
    print("4. Mostrar el número de libros")
    print("5. Salir")


def MostrarBiblioteca(biblioteca):
    biblioteca.MostrarBiblioteca()

def BorrarLibro(biblioteca, titulo):
    biblioteca.BorrarLibro(titulo)

def NumeroLibros (biblioteca) :
    return biblioteca.NumeroLibros()


biblioteca= Biblioteca([])

MostrarMenu()
opcion = int(input("Seleccione opción: "))

while opcion != 5:

    if opcion == 1:
        titulo = input("Introduzca el título del libro: ")
        isbn = input("Introduzca el ISBN del libro: ")
        nombre_autor = input("Introduzca el nombre del autor: ")
        apellido_autor = input("Introduzca el apellido del autor: ")
        autor = Autor(nombre_autor,apellido_autor)
        libro = Libro(titulo, isbn)
        libro.AnadirAutor(autor)
        biblioteca.AnadirLibro(libro)
        print("Libro añadido.")

    elif opcion == 2:
        print("Biblioteca:")
        MostrarBiblioteca(biblioteca)

    elif opcion == 3:
        titulo = input("Introduzca el título del libro a borrar: ")
        BorrarLibro(biblioteca,titulo)

    elif opcion == 4:
        print("Número de libros:",NumeroLibros(biblioteca))

    else :
        print("No ha introducido una opción válida. Por favor, elija una opción correcta.")

    MostrarMenu()
    opcion = int(input("Seleccione opción: "))

print("Saliendo del programa")
