#Eva Pérez Carmona
import sys
from PySide6.QtWidgets import QApplication, QMainWindow, QTextEdit

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("ActividadPropuesta8")

        campo = QTextEdit()
        campo.setPlainText("Bienvenido/a al editor de texto.")
        campo.setPlaceholderText("Escribe aquí tu mensaje...")

        campo.textChanged.connect(self.texto_modificado)

        self.setCentralWidget(campo)
        self.campo = campo

    def texto_modificado(self):
        print(self.campo.toPlainText())

app = QApplication(sys.argv)
window = MainWindow()
window.show()
app.exec()