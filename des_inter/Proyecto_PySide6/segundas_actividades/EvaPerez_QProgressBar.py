#Eva Pérez Carmona
import sys
from PySide6.QtCore import QTimer
from PySide6.QtWidgets import QApplication, QMainWindow, QProgressBar,QTimer

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Ejemplo QProgressBar")
        self.progreso_actual = 0

        self.progreso = QProgressBar()
        self.progreso.setRange(0,100)

        self.timer = QTimer()
        self.timer.timeout.connect(self.preguntar_usuario)
        self.timer.start(2000)


        self.setCentralWidget(self.progreso)

    def preguntar_usuario(self) :
        print ("===Control de progreso === 1 -> Aumentar progreso 2 -> Retroceder progreso 0 -> Salir")
        opcion = int(input("Elige una opción: "))
        #if opcion == 1 :



    def cambiar_progreso(self,tipo) :
        if tipo == "aumentar" :
            self.progreso_actual = min(self.progreso_actual+20,100) #se asegura que aunque la suma pase de 100, devuelve 100
        else :
            self.progreso_actual = max(self.progreso_actual - 20,0)
        self.progreso.setValue(self.progreso_actual) 
        if self.progreso_actual == 100 :
            self.setWindowTitle("¡Tarea completada!")
        else :
            self.setWindowTitle("Progreso",self.progreso_actual,"%")
            print("Progreso actual",self.progreso_actual,"%")
    

app = QApplication(sys.argv)
window = MainWindow()
window.show()
app.exec()