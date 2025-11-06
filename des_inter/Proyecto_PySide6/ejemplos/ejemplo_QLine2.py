import sys
from PySide6.QtWidgets import QApplication, QMainWindow, QLineEdit

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Máscara de entrada")

        ip = QLineEdit()
        ip.setInputMask("000.000.000.000;_")
        ip.setPlaceholderText("Introduce una dirección IP")

        self.setCentralWidget(ip)

app = QApplication(sys.argv)
window = MainWindow()
window.show()
app.exec()