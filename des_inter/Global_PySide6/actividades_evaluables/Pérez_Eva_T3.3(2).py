#Eva Pérez Carmona
import sys
from PySide6.QtWidgets import (
    QApplication,
    QWidget,
    QMainWindow,
    QVBoxLayout,
    QPushButton
)
from PySide6.QtGui import QPainter, QColor, QPen
from PySide6.QtCore import Qt, QRect,QTimer

class Circulo(QWidget):
    def __init__(self, color):
        super().__init__()
        self.encendida = False #definimos que la luz está apagado de primeras
        self.color = color

    def paintEvent(self, event):
        painter = QPainter(self) #definimos el painter (con bordes y todo)
        painter.setRenderHint(QPainter.Antialiasing)
        painter.setPen(QPen(Qt.black))

        color_final = QColor("gray")

        if self.color == "rojo": #condiciones para asignar colores al semáforo
            if self.encendida:
                color_final = QColor("#FF0000")
            else:
                color_final = QColor("#4E4A4A") #color gris al estar desactivado
        elif self.color == "amarillo":
            if self.encendida:
                color_final = QColor("#FFFF00")
            else:
                color_final = QColor("#4E4A4A")
        elif self.color == "verde":
            if self.encendida:
                color_final = QColor("#00FF00")
            else:
                color_final = QColor("#4E4A4A")

        painter.setBrush(color_final) #le asignamos el color que quede tras la condición

        lado = min(self.width(), self.height()) #definimos sus medidas y nos aseguramos que no se deforme
        recto = QRect(
            (self.width() - lado) // 2,
            (self.height() - lado) // 2,
            lado,
            lado
        )
        painter.drawEllipse(recto)

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Semáforo 1:Cambiar mediante botón")
        self.resize(300, 500)
        self.estado = "rojo" #definimos el estado principal del semáforo

        self.temporizador = QTimer(self) #definimos el temporizador QTimer y se lo asociamos a una función
        self.temporizador.timeout.connect(self.cambiar)
        self.temporizador.start(1000)

        self.contenedor = QWidget()
        self.contenedor.setStyleSheet("background-color: #000000;") #ponemos el color de fondo negro para que se parezca a un semáforo
        self.layout = QVBoxLayout(self.contenedor)

        self.rojo = Circulo("rojo") #definimos tres circulos
        self.amarillo = Circulo("amarillo")
        self.verde = Circulo("verde")

        self.layout.addWidget(self.rojo)
        self.layout.addWidget(self.amarillo)
        self.layout.addWidget(self.verde)

        self.setCentralWidget(self.contenedor)
        self.actualizar() #necesario para que el semáforo salga en rojo al principio

    def cambiar(self): #función para actualizar el estado
        if self.estado == "rojo":
            self.estado = "amarillo"
        elif self.estado == "amarillo":
            self.estado = "verde"
        elif self.estado == "verde":
            self.estado = "rojo"
        self.actualizar()

    def actualizar(self): #actualizamos los estados de los circulos
        if self.estado == "rojo":
            self.rojo.encendida = True
        else:
            self.rojo.encendida = False

        if self.estado == "amarillo":
            self.amarillo.encendida = True
        else:
            self.amarillo.encendida = False

        if self.estado == "verde":
            self.verde.encendida = True
        else:
            self.verde.encendida = False

        self.rojo.update() 
        self.amarillo.update()
        self.verde.update()

if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()