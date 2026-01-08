#Eva Pérez Carmona
from PySide6.QtWidgets import QApplication, QMainWindow, QPushButton
class VentanaPrincipal(QMainWindow):
        def __init__(self):
            super().__init__()
            self.setWindowTitle("Venatana Principal")
            self.boton = QPushButton("Pulsar")
            self.boton.pressed.connect(self.el_boton_fue_presionado)
            self.boton.released.connect(self.boton_soltado)
            self.setCentralWidget(self.boton)

        def el_boton_fue_presionado(self) :
            self.boton.setText("Soltar")
            print("Botón presionado")
        
        def boton_soltado (self) :
            self.boton.setText("Pulsar")
            print("Botón liberado")

app = QApplication()
window = VentanaPrincipal()
window.show()
app.exec()