#Eva Pérez Carmona
import sys
from PySide6.QtWidgets import QApplication, QMainWindow, QLineEdit

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("ActividadPropuesta7")

        texto = QLineEdit()
        texto.setMaxLength(20)
        texto.setPlaceholderText("Escribe tu ciudad")

        texto.returnPressed.connect(self.renombre_ventana)

        self.setCentralWidget(texto)
        self.texto = texto

    def renombre_ventana(self):
        contenido = self.texto
        if contenido:
            self.setWindowTitle(contenido)
        else:
            self.setWindowTitle("Sin ciudad")

app = QApplication(sys.argv)
window = VentanaPrincipal()
window.show()
app.exec()
