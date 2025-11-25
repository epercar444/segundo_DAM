import os
from PySide6.QtCore import Qt
from PySide6.QtGui import QAction, QIcon, QKeySequence
from PySide6.QtWidgets import (
    QApplication, QMainWindow, QToolBar, QLabel, QDockWidget, QTextEdit
)

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Ejercicio - Componentes Acoplables")

        self.setCentralWidget(QLabel("Área principal de la aplicación"))

        # PANEL 1
        panel1 = QDockWidget("Panel 1", self)
        panel1.setWidget(QTextEdit("Panel de notas"))
        panel1.setFeatures(QDockWidget.NoDockWidgetFeatures)  # Fijo
        self.addDockWidget(Qt.LeftDockWidgetArea, panel1)

        # PANEL 2
        panel2 = QDockWidget("Panel 2", self)
        panel2.setWidget(QLabel("Panel de estado"))
        panel2.setFeatures(QDockWidget.DockWidgetFloatable)  # Flotante
        self.addDockWidget(Qt.RightDockWidgetArea, panel2)

        # PANEL 3
        panel3 = QDockWidget("Panel 3", self)
        panel3.setWidget(QLabel("Panel de ayuda"))
        panel3.setFeatures(
            QDockWidget.DockWidgetFloatable |
            QDockWidget.DockWidgetClosable
        )  # Flotante + cerrable
        self.addDockWidget(Qt.BottomDockWidgetArea, panel3)

        # BARRA DE ESTADO 
        barra_estado = self.statusBar()
        barra_estado.showMessage("Listo. Paneles creados correctamente.", 3000)

        # BARRA DE HERRAMIENTAS 
        barra_herramientas = QToolBar("Barra Principal")
        self.addToolBar(barra_herramientas)

        ruta_icono = os.path.join(os.path.dirname(__file__), "console-log-icon.png")
        accion_imprimir = QAction(QIcon(ruta_icono), "Imprimir en consola", self)
        accion_imprimir.setShortcut(QKeySequence("Ctrl+P"))
        accion_imprimir.triggered.connect(self.print_to_console)
        barra_herramientas.addAction(accion_imprimir)

    def print_to_console(self):
        print("Acción ejecutada desde la barra de herramientas.")

if __name__ == "__main__":
    app = QApplication([])
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()
