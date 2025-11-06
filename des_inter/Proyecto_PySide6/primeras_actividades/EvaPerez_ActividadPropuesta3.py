#Eva Pérez Carmona
from PySide6.QtWidgets import QApplication, QMainWindow, QPushButton,QLineEdit,QLabel
from PySide6.QtCore import Qt

class VentanaPrincipal(QMainWindow):
        def __init__(self):
            super().__init__()
            self.setWindowTitle("Venatana Principal")

            etiqueta = QLabel("Sistema en espera")
            fuente = etiqueta.font()
            fuente.setPointSizeF(24)

            etiqueta.setFont(fuente)
            etiqueta.setAlignment(Qt.AlignHCenter | Qt.AlignBottom)

            self.setCentralWidget(etiqueta)

            etiqueta.setText("Sistema operativo iniciado")

app = QApplication()
window = VentanaPrincipal()
window.show()
app.exec()