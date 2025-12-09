import sys
from PySide6.QtWidgets import QApplication, QWidget, QVBoxLayout, QPushButton, QMainWindow
from PySide6.QtGui import QPainter, QColor, QPen
from PySide6.QtCore import Qt, QTimer

class SemaforoRealista(QWidget):
    def __init__(self):
        super().__init__()
        self.__estado_actual = "rojo"
        
        self.temporizador = QTimer(self)
        self.temporizador.timeout.connect(self.cambiar_estado)
        self.temporizador.start(1000)
        
        layout = QVBoxLayout(self)
        layout.addStretch()
        
        self.boton = QPushButton("Forzar Cambio", self)
        self.boton.clicked.connect(self.cambiar_estado)
        layout.addWidget(self.boton)

    def paintEvent(self, event):
        painter = QPainter(self)
        painter.setRenderHint(QPainter.Antialiasing)
        
        alto_disponible = self.height() - self.boton.height() - 20
        ancho_caja = min(self.width() - 40, 150)
        alto_caja = min(alto_disponible, 400)
        
        x_caja = (self.width() - ancho_caja) // 2
        y_caja = 10
        
        painter.setPen(QPen(Qt.black, 2))
        painter.setBrush(QColor(40, 40, 40))
        painter.drawRect(x_caja, y_caja, ancho_caja, alto_caja)
        
        diametro = min(ancho_caja - 20, (alto_caja - 40) // 3)
        x_luz = x_caja + (ancho_caja - diametro) // 2
        y_luz = y_caja + 10
        
        colores = {
            "rojo": ("red", "#330000", "#330000"),
            "amarillo": ("#333300", "yellow", "#333300"),
            "verde": ("#003300", "#003300", "green")
        }
        c1, c2, c3 = colores.get(self.__estado_actual)
        
        painter.setPen(QPen(Qt.black, 1))
        
        painter.setBrush(QColor(c1))
        painter.drawEllipse(x_luz, y_luz, diametro, diametro)
        
        y_luz += diametro + 10
        painter.setBrush(QColor(c2))
        painter.drawEllipse(x_luz, y_luz, diametro, diametro)
        
        y_luz += diametro + 10
        painter.setBrush(QColor(c3))
        painter.drawEllipse(x_luz, y_luz, diametro, diametro)

    def cambiar_estado(self):
        if self.__estado_actual == "rojo":
            self.__estado_actual = "amarillo"
        elif self.__estado_actual == "amarillo":
            self.__estado_actual = "verde"
        else:
            self.__estado_actual = "rojo"
        self.update()

class VentanaSemaforo(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Semaforo Realista")
        self.resize(300, 500)
        self.setCentralWidget(SemaforoRealista())

if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaSemaforo()
    ventana.show()
    app.exec()