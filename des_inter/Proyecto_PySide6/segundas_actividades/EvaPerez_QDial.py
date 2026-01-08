# Eva Pérez Carmona
import sys
from PySide6.QtWidgets import QApplication, QMainWindow, QDial

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.dial = QDial()
        self.dial.setRange(0, 10)
        self.dial.setNotchesVisible(True) #hacemos que se muestren las divisiones del control deslizante
        self.dial.valueChanged.connect(self.actualizar_volumen)
        self.setCentralWidget(self.dial)
        self.actualizar_volumen(0)

    def actualizar_volumen(self, valor):
        self.setWindowTitle(f"Volumen: {valor} / 10")
        if valor == 10:
            print("¡Volumen máximo alcanzado!")

app = QApplication(sys.argv)
window = MainWindow()
window.show()
app.exec()
