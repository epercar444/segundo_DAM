import sys
import os
from PyQt6.QtWidgets import QApplication, QMainWindow, QWidget, QVBoxLayout, QHBoxLayout, QPushButton, QLabel
from PyQt6.QtCore import QUrl
from PyQt6.QtGui import QDesktopServices

class VentanaNavegadorExterno(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Ejercicio 1 - Navegador Externo")
        self.resize(400, 150)

        self.informes = [
            "DI_U05_A02_03.html", 
            "DI_U05_A02_08.html", 
            "DI_U05_A03_11.html"
        ]

        central_widget = QWidget()
        self.setCentralWidget(central_widget)
        layout = QVBoxLayout(central_widget)
        
        layout.addWidget(QLabel("Seleccione un informe para abrir en el navegador:"))

        layout_botones = QHBoxLayout()
        for nombre in self.informes:
            btn = QPushButton(nombre)
            btn.clicked.connect(lambda checked, n=nombre: self.abrir_en_sistema(n))
            layout_botones.addWidget(btn)
        
        layout.addLayout(layout_botones)

    def abrir_en_sistema(self, nombre_archivo):
        ruta = os.path.abspath(nombre_archivo)
        url = QUrl.fromLocalFile(ruta)
        QDesktopServices.openUrl(url)

if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaNavegadorExterno()
    ventana.show()
    sys.exit(app.exec())