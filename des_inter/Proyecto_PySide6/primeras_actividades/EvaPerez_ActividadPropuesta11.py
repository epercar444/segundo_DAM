from PySide6.QtWidgets import QToolBar, QMainWindow,QApplication
from PySide6.QtGui import QAction, QKeySequence,QIcon
from PySide6.QtCore import Qt
import os

#Eva Pérez Carmona

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Ventana principal con menús")

        barra_menu = self.menuBar() #creamos referenica menú de la VentanaPrincipal
        menu = barra_menu.addMenu("&Archivo")
        ruta_icono = os.path.join(os.path.dirname(__file__), "usuario.png")

        self.barra_herramientas = QToolBar("Barra principal") #Definimos la barra principal
        self.barra_herramientas.setToolButtonStyle(Qt.ToolButtonTextUnderIcon)
        self.addToolBar(self.barra_herramientas)


        # Creamos una acción
        self.accion1 = QAction(QIcon(ruta_icono),"Mostrar mensaje", self)
        self.accion1.setShortcut(QKeySequence("Ctrl+M"))  # Atajo de teclado
        self.accion1.setWhatsThis("Imprime un texto por consola al pulsar el botón o atajo")
        self.accion1.triggered.connect(self.mostrar_mensaje)  # Vinculamos acción con método
        # Añadimos la acción al menú
        menu.addAction(self.accion1)
        self.barra_herramientas.addAction(self.accion1) #Añadimos la acción a la barra de herramientas principal


        # Creamos una acción
        self.accion2 = QAction(QIcon(ruta_icono),"Cambiar título ventana", self)
        self.accion2.setShortcut(QKeySequence("Ctrl+L"))  # Atajo de teclado
        self.accion2.setWhatsThis("Cambia el título de la ventana por consola al pulsar el botón o atajo")
        self.accion2.triggered.connect(self.cambiar_titulo)  # Vinculamos acción con método
        # Añadimos la acción al menú
        menu.addAction(self.accion2)
        self.barra_herramientas.addAction(self.accion2)


        # Creamos una acción
        self.accion3 = QAction(QIcon(ruta_icono),"Desactivar acciones", self)
        self.accion3.setShortcut(QKeySequence("Ctrl+Q"))  # Atajo de teclado
        self.accion3.setWhatsThis("Desactiva las acciones anteriores por consola al pulsar el botón o atajo")
        self.accion3.triggered.connect(self.desactivar_acciones)  # Vinculamos acción con método
        # Añadimos la acción al menú
        menu.addAction(self.accion3)
        self.barra_herramientas.addAction(self.accion3)

        self.barra_herramientas2 = QToolBar("Barra secundaria") #Definimos la barra secundaria
        self.barra_herramientas2.setToolButtonStyle(Qt.ToolButtonTextUnderIcon)
        self.addToolBar(self.barra_herramientas2)

        self.accion4 = QAction(QIcon(ruta_icono),"Activar acciones", self)
        self.accion4.setShortcut(QKeySequence("Ctrl+W"))
        self.accion4.setWhatsThis("Vuelve a activar las acciones desactivadas.")
        self.accion4.triggered.connect(self.activar_acciones)
        self.barra_herramientas2.addAction(self.accion4)



    def mostrar_mensaje(self):
        print("Hola")

    def cambiar_titulo(self):
        self.setWindowTitle("Título cambiado")

    def desactivar_acciones(self):
        self.accion1.setEnabled(False)
        self.accion2.setEnabled(False)
        self.accion3.setEnabled(False)

    def activar_acciones(self):
        self.accion1.setEnabled(True)
        self.accion2.setEnabled(True)
        self.accion3.setEnabled(True)

app = QApplication([])
ventana = VentanaPrincipal()
ventana.show()
app.exec()