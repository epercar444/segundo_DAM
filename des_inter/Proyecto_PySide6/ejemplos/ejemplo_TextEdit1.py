import sys
from PySide6.QtWidgets import QApplication, QMainWindow, QTextEdit

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("QTextEdit solo lectura")

        texto = QTextEdit()
        texto.setPlainText("Bienvenido al módulo de Desarrollo de Interfaces.\n\nAquí podrás escribir tus apuntes o notas.")
        texto.setReadOnly(True)

        self.setCentralWidget(texto)

app = QApplication(sys.argv)
window = MainWindow()
window.show()
app.exec()