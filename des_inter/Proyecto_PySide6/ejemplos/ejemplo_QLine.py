import sys
from PySide6.QtWidgets import QApplication, QMainWindow, QLineEdit

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Ejemplo QLineEdit")

        texto = QLineEdit()
        texto.setMaxLength(10)
        texto.setPlaceholderText("Introduce tu nombre")

        texto.returnPressed.connect(self.mostrar_mensaje)
        texto.textChanged.connect(self.texto_modificado)
        texto.textEdited.connect(self.texto_editado)

        self.setCentralWidget(texto)
        self.texto = texto

    def mostrar_mensaje(self):
        print("Se pulsó Enter")
        self.texto.setText("¡Hola!")

    def texto_modificado(self, s):
        print("Texto modificado:", s)

    def texto_editado(self, s):
        print("Texto editado por el usuario:", s)

app = QApplication(sys.argv)
window = MainWindow()
window.show()
app.exec()