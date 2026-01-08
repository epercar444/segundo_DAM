import sys
import os
from PySide6.QtWidgets import (
    QApplication,
    QWidget,
    QPushButton,
    QLabel,
    QHBoxLayout,
    QVBoxLayout,
    QMainWindow
)
from PySide6.QtCore import Signal
from PySide6.QtGui import QPainter, QColor, QPen
from PySide6.QtCore import QRect, Qt

class Boton(QPushButton):
    valor_actualizado = Signal(int)
    def __init__(self, texto):
        self.texto_inicial = texto
        super().__init__(texto)
        self.bateria = 50

        self.valor_actualizado.emit(self.bateria)


class Bateria(QWidget):
    def __init__(self, parent=None):
        super().__init__(parent)
        self.texto_bateria = "50%"
        self.valorBateria = 50

    def setTexto(self, texto):
        self.texto_bateria = texto
        self.update()

    def paintEvent(self, event):
        painter = QPainter(self)
        painter.drawRect(5,5,250,95)
        painter.setPen(QPen(Qt.black,5)) #no cambia el grosor

        painter1 = QPainter(self)
        painter1.setPen(Qt.NoPen) 
        painter1.setBrush(QColor("#ffee00"))
        painter1.drawRect(15,15,230,75)

        if self.valorBateria < 60 :
            painter1.setBrush(QColor("#ffee00"))
        elif self.valorBateria > 60 :
            painter1.setBrush(QColor("#065a11"))
        else :
            painter1.setBrush(QColor("#ff1100"))



        lado = min(self.width(), self.height())
        recto = QRect(
            (self.width() - lado) // 2,   # posición X centrada
            (self.height() - lado) // 2,  # posición Y centrada
            lado,                         # ancho del cuadrado
            lado                          # alto del cuadrado
        )
        painter1.setPen(QPen(Qt.black))
        painter1.drawText(recto, 180, self.texto_bateria)





class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Monitor nivel de batería")
        self.resize(200, 300)

        # Crear widget central
        contenedor = QWidget(self)
        layout = QVBoxLayout(contenedor)

        layout_horizontal = QHBoxLayout()
        self.boton_cargar = Boton("Cargar +10%")
        self.boton_cargar.clicked.connect(self.incrementar)
        self.boton_descargar = Boton("Gastar +15%")
        self.boton_descargar.clicked.connect(self.decrementar)
        self.boton_reiniciar = Boton("Reiniciar (50%)")
        self.boton_reiniciar.clicked.connect(self.reiniciar)

        self.estado = QLabel()
        self.estado.setAutoFillBackground(True)
        if self.boton_cargar.bateria < 60 :
            self.estado.setText("ESTADO : AVISO")
        elif self.boton_cargar.bateria > 60 :
            self.estado.setText("ESTADO : OK")
        else :
            self.estado.setText("ESTADO : CRÍTICO")


        self.bateria = Bateria()

        layout_horizontal.addWidget(self.boton_cargar)
        layout_horizontal.addWidget(self.boton_descargar)
        layout_horizontal.addWidget(self.boton_reiniciar)

        layout.addWidget(self.bateria)
        layout.addLayout(layout_horizontal)
        layout.addWidget(self.estado)

        self.setCentralWidget(contenedor)
        
        app.setStyle("Fusion")
        #busca la carpeta donde está ubicado el archivo .py
        carpeta_actual = os.path.dirname(os.path.abspath(__file__))
        #busca el nombre del archivo que introduzcamos en la ruta de la carpeta que hemos guardado anteriormente
        ruta_qss = os.path.join(carpeta_actual, "Pérez_Eva_estilosExRecT3.qss")
        #abre el archivo .qss
        with open(ruta_qss, "r") as f:
            app.setStyleSheet(f.read())


    def incrementar(self):
       self.boton_cargar.bateria = self.boton_cargar.bateria + 10
       self.bateria.valorBateria = self.boton_cargar.bateria
       self.bateria.setTexto(str(self.boton_cargar.bateria)+"%")
       if self.boton_cargar.bateria > 90 :
           self.boton_cargar.bateria = 90

    def decrementar(self):
       self.boton_cargar.bateria = self.boton_cargar.bateria - 15
       self.bateria.valorBateria = self.boton_cargar.bateria
       self.bateria.setTexto(str(self.boton_cargar.bateria)+"%")
       if self.boton_cargar.bateria < 15 :
           self.boton_cargar.bateria = 15
    
    def reiniciar(self) :
        self.boton_cargar.bateria = 50
        self.bateria.valorBateria = self.boton_cargar.bateria
        self.bateria.setTexto(str(self.boton_cargar.bateria)+"%")





if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    sys.exit(app.exec())