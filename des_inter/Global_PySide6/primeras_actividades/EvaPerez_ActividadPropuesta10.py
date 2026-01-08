from PySide6.QtWidgets import QApplication, QMainWindow
from PySide6.QtGui import QAction, QKeySequence
#Eva Pérez Carmona

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Ventana principal con menús")

        barra_menu = self.menuBar() #creamos referenica menú de la VentanaPrincipal
        menu = barra_menu.addMenu("&Archivo")

        # Creamos una acción
        accion = QAction("Mostrar mensaje", self)
        accion.setShortcut(QKeySequence("Ctrl+M"))  # Atajo de teclado
        accion.triggered.connect(self.mostrar_mensaje)  # Vinculamos acción con método
        # Añadimos la acción al menú
        menu.addAction(accion)

        menu.addSeparator() #Añadimos las separaciones

        # Creamos una acción
        accion = QAction("Cambiar título ventana", self)
        accion.setShortcut(QKeySequence("Ctrl+L"))  # Atajo de teclado
        accion.triggered.connect(self.cambiar_titulo)  # Vinculamos acción con método
        # Añadimos la acción al menú
        menu.addAction(accion)

        menu.addSeparator()

        # Creamos una acción
        accion = QAction("Salida", self)
        accion.setShortcut(QKeySequence("Ctrl+Q"))  # Atajo de teclado
        accion.triggered.connect(self.salir_programa)  # Vinculamos acción con método

        # Añadimos la acción al menú
        menu.addAction(accion)


    def mostrar_mensaje(self):
        print("Hola desde el menú.")

    def cambiar_titulo(self):
        self.setWindowTitle("Título cambiado desde el menú.")

    def salir_programa(self):
        self.close()

app = QApplication([])
ventana = VentanaPrincipal()
ventana.show()
app.exec()