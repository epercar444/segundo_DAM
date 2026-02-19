import sys
import os
from PyQt6.QtWidgets import QApplication, QMainWindow, QWidget, QVBoxLayout, QComboBox, QLabel
from PyQt6.QtCore import QUrl
from PyQt6.QtWebEngineWidgets import QWebEngineView

class Ejercicio2App(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Ejercicio 2: Visor QWebEngine")
        self.resize(1000, 700)

        self.informes = [
            "DI_U05_A02_03.html", 
            "DI_U05_A02_08.html", 
            "DI_U05_A03_11.html"
        ]

        widget = QWidget()
        self.setCentralWidget(widget)
        layout = QVBoxLayout(widget)

        self.combo = QComboBox()
        self.combo.addItems(self.informes)
        self.combo.currentTextChanged.connect(self.cargar_web)
        
        layout.addWidget(QLabel("Selecciona informe para ver dentro de la app:"))
        layout.addWidget(self.combo)

        self.visor = QWebEngineView()
        layout.addWidget(self.visor)

        self.cargar_web(self.combo.currentText())

    def cargar_web(self, archivo):
        ruta = os.path.abspath(archivo)
        url = QUrl.fromLocalFile(ruta)
        self.visor.load(url)

if __name__ == "__main__":
    app = QApplication(sys.argv)
    window = Ejercicio2App()
    window.show()
    sys.exit(app.exec())