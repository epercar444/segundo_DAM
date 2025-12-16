# Eva Pérez Carmona
import sys
from PySide6.QtWidgets import QApplication, QMainWindow, QSlider
from PySide6.QtCore import Qt

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Ejemplo QSlider")
        self.slider = QSlider() #puedes definir si el QSlider es horizontal o vertical
        self.slider.setRange(0, 100) #rango de Slider
        self.slider.setValue(50) #valor por el que empieza
        self.slider.valueChanged.connect(self.mostrar_valor)
        self.setCentralWidget(self.slider)
        self.mostrar_valor(50)

    def mostrar_valor(self, valor):
        print(f"Nivel de brillo: {valor}%") #se usa f para acceder a las variables

app = QApplication(sys.argv)
window = MainWindow()
window.show()
app.exec()
