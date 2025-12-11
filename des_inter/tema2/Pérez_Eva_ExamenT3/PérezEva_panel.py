import sys
import os
from PySide6.QtWidgets import (
    QApplication,
    QWidget,
    QMainWindow,
    QVBoxLayout,
    QPushButton,
    QLabel
)
from PySide6.QtGui import QPainter, QColor, QPen,QPalette
from PySide6.QtCore import QRect, Qt


class Circulo(QWidget):
    def __init__(self):
        super().__init__()
        self._texto = "OK"
        self.valor_Indicador = 0

    def setTexto(self, texto):
        self._texto = texto
        self.update()

    def paintEvent(self, event):
        painter = QPainter(self)
        painter.setRenderHint(QPainter.Antialiasing)
        
        #intento cambio de color
        if self.valor_Indicador == 0 :
            painter.setBrush(QColor("#FFFBFB"))
        elif self.valor_Indicador >=1 and self.valor_Indicador <= 3 :
            painter.setBrush(QColor("#25C517"))
        elif self.valor_Indicador >= 4 and self.valor_Indicador <= 7 :
            painter.setBrush(QColor("#FBFF08"))
            self.setTexto("AVISO")
        else :
            painter.setBrush(QColor("#C53117"))
            self.setTexto("ERROR")

        painter.setPen(QPen(Qt.black)) 
        lado = min(self.width(), self.height()) #definimos medidas para que el circulo se ajuste
        recto = QRect(
            (self.width() - lado) // 2,   
            (self.height() - lado) // 2,  
            lado,                         
            lado                          
        )
        painter.drawEllipse(recto)
        painter.setPen(QPen(Qt.black)) #definimos color texto
        painter.drawText(recto, Qt.AlignCenter, self._texto)
        
class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Eva Pérez Examen : Panel Control de Incidencias")
        self.resize(500, 500)
        self.__valor = 0

        #definición widgets y layouts
        contenedor = QWidget(self)
        layout = QVBoxLayout(contenedor)

        self.circulo = Circulo()

        self.__etiqueta = QLabel("Incidencias abiertas : 0", self)

        boton_incidencia = QPushButton("Añadir Incidencia")
        boton_incidencia.clicked.connect(self._incrementar)
        boton_incidencia.clicked.connect(self.cambioColor)
        boton_reset = QPushButton("Reset")
        boton_reset.clicked.connect(self.reiniciar)

        layout.addWidget(self.circulo )
        layout.addWidget(self.__etiqueta) #aparece muy separado
        layout.addWidget(boton_incidencia)
        layout.addWidget(boton_reset)

        self.setCentralWidget(contenedor)

        app.setStyle("Fusion")
        #busca la carpeta donde está ubicado el archivo .py
        carpeta_actual = os.path.dirname(os.path.abspath(__file__))
        #busca el nombre del archivo que introduzcamos en la ruta de la carpeta que hemos guardado anteriormente
        ruta_qss = os.path.join(carpeta_actual, "PérezEva_panel.qss")
        #abre el archivo .qss
        with open(ruta_qss, "r") as f:
            app.setStyleSheet(f.read())

    def _incrementar(self): #incrementamos valores del valor
        self.__valor = self.__valor + 1
        self.__etiqueta.setText("Incidencias abiertas : "+str(self.__valor))
        self.circulo.update()

    def reiniciar(self): #reiniciamos el valor del contador
        self.__valor = 0
        self.__etiqueta.setText("Incidencias abiertas : 0")
        self.circulo.update()

#función cambiar de color
    def cambioColor (self):
        self.circulo.valor_Indicador = self.__valor
        self.circulo.update()



if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()





