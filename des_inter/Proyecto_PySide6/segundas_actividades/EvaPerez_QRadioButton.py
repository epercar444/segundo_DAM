#Eva Pérez Carmona

import sys
from PySide6.QtWidgets import QApplication, QMainWindow, QRadioButton

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Ejemplo QRadioButton")

        self.boton = QRadioButton("Activar función")
        self.boton.toggled.connect(self.boton_estado)

        self.setCentralWidget(self.boton)

    def boton_estado(self, checked):
        checked = self.boton.isChecked()
        if checked :
            self.setWindowTitle("Función ACTIVADA")
        else :
            self.setWindowTitle("Función DESACTIVADA")


app = QApplication(sys.argv)
window = MainWindow()
window.show()
app.exec()