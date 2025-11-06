#Eva Pérez Carmona
import os
import sys
from PySide6.QtGui import QPixmap
from PySide6.QtWidgets import QApplication, QLabel, QMainWindow
ruta_base = os.path.dirname(__file__)
print("Current working folder:", os.getcwd())  
print("Paths are relative to:", ruta_base)       
class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("My App")
        etiqueta = QLabel("Hello")
        etiqueta.setPixmap(QPixmap(os.path.join(ruta_base, "otje.jpg")))
        etiqueta.setScaledContents(True)
        self.setCentralWidget(etiqueta)

app = QApplication(sys.argv)
ventana = VentanaPrincipal()
ventana.show()
app.exec()