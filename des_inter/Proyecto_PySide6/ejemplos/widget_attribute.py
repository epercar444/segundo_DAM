from PySide6.QtCore import QSize
from PySide6.QtWidgets import QApplication, QMainWindow, QPushButton,QLineEdit
class VentanaPrincipal(QMainWindow):
        def __init__(self):
            super().__init__()
            self.setWindowTitle("Venatana Principal")
            self.setMinimumSize(QSize(300,200))

            texto = QLineEdit()
            texto.textChanged.connect(self.texto_modificado)

            self.texto = texto

            self.setCentralWidget(texto)
        
        def texto_modificado(self) :
            self.setWindowTitle(self.texto.text())

app = QApplication()
window = VentanaPrincipal()
window.show()
app.exec()