# Eva Pérez
from PySide6.QtCore import QSize
from PySide6.QtWidgets import QApplication, QMainWindow, QPushButton

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Mi Aplicación")
        boton = QPushButton("Púlsame!")
        # Tamaño fijo
        # self.setFixedSize(QSize(400, 300))
        self.setCentralWidget(boton)
        self.setMaximumSize(QSize(600, 400))
        self.setMinimumSize(QSize(300, 200))

class VentanaSecundaria(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Ventana secundaria")
        boton = QPushButton("¡Estoy en la ventana secundaria!")
        self.setFixedSize(QSize(400, 300))
        self.setCentralWidget(boton)

app = QApplication([])
window = VentanaPrincipal()
window2 = VentanaSecundaria()
window2.show()
window.show()
app.exec()
