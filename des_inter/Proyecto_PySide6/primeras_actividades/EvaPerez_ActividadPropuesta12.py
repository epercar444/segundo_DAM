import os
import platform
import getpass
from PySide6.QtGui import QAction, QIcon, QKeySequence
from PySide6.QtCore import QTimer
from PySide6.QtWidgets import QApplication, QMainWindow, QToolBar, QLabel

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Mi aplicación")

        barra_menu = self.menuBar()
        menu_archivo = barra_menu.addMenu("&Archivo")

        # Ruta del icono
        ruta_icono = os.path.join(os.path.dirname(__file__), "usuario.png")

        # Mostrar mensaje temporal
        accion_mensaje_temporal = QAction(QIcon(ruta_icono), "Mostrar mensaje temporal", self)
        accion_mensaje_temporal.setStatusTip("Muestra un mensaje temporal en la barra de estado")
        accion_mensaje_temporal.setShortcut(QKeySequence("Ctrl+T"))
        accion_mensaje_temporal.triggered.connect(self.show_temporary_message)

        # Limpiar mensaje
        accion_limpiar_mensaje = QAction(QIcon(ruta_icono), "Limpiar mensaje", self)
        accion_limpiar_mensaje.setStatusTip("Limpia el mensaje de la barra de estado")
        accion_limpiar_mensaje.setShortcut(QKeySequence("Ctrl+L"))
        accion_limpiar_mensaje.triggered.connect(self.statusBar().clearMessage)

        # Mostrar información del sistema
        accion_info_sistema = QAction(QIcon(ruta_icono), "Mostrar información del sistema", self)
        accion_info_sistema.setStatusTip("Añade información del sistema a la barra de estado")
        accion_info_sistema.setShortcut(QKeySequence("Ctrl+I"))
        accion_info_sistema.triggered.connect(self.show_system_info)

        # Agregar acciones al menú
        menu_archivo.addAction(accion_mensaje_temporal)
        menu_archivo.addAction(accion_limpiar_mensaje)
        menu_archivo.addAction(accion_info_sistema)

        # BARRA DE HERRAMIENTAS
        barra_herramientas = QToolBar("Barra Principal")
        barra_herramientas.addAction(accion_mensaje_temporal)
        barra_herramientas.addAction(accion_limpiar_mensaje)
        barra_herramientas.addAction(accion_info_sistema)
        self.addToolBar(barra_herramientas)

        # BARRA DE ESTADO
        self.barra_estado = self.statusBar()

        # Añadir un componente permanente con el usuario actual
        usuario = getpass.getuser()
        etiqueta_usuario = QLabel(f"Usuario: {usuario}")
        self.barra_estado.addPermanentWidget(etiqueta_usuario)

        # Mensaje inicial de 2 segundos
        self.barra_estado.showMessage("Aplicación iniciada correctamente", 2000)

        # QTimer para mostrar mensajes alternos
        self.mensajes = ["Esperando acción…", "Listo para trabajar"]
        self.indice_mensaje = 0

        self.temporizador = QTimer()
        self.temporizador.timeout.connect(self.show_alternating_message)
        self.temporizador.start(4000)  # Cada 4 segundos

    # Mostrar un mensaje temporal en la barra de estado
    def show_temporary_message(self):
        self.barra_estado.showMessage("Mensaje temporal: desaparece en 3 segundos", 3000)

    # Añadir información del sistema a la barra de estado
    def show_system_info(self):
        nombre_sistema = platform.system()
        etiqueta = QLabel(f"Sistema: {nombre_sistema}")
        self.barra_estado.addWidget(etiqueta)

    # Alternar mensajes cada pocos segundos
    def show_alternating_message(self):
        self.barra_estado.showMessage(self.mensajes[self.indice_mensaje], 3000)
        self.indice_mensaje = (self.indice_mensaje + 1) % len(self.mensajes)


if __name__ == "__main__":
    app = QApplication([])
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()
