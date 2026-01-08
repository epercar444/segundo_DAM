#Eva Pérez Carmona
import sys
from PySide6.QtWidgets import QApplication, QMainWindow, QTabWidget,QWidget

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Ejemplo QTabWidget")

        self.tab = QTabWidget()
        self.tab.addTab(QWidget(),("Bienvenido")) #QWidget, lo necesita ya que la pestaña necesita algún contenido aunque este esté vacío.
        self.tab.addTab(QWidget(),("Segunda pestaña"))
        self.tab.addTab(QWidget(),("Tercera pestaña"))

        self.tab.currentChanged.connect(self.cambiar_titulo)

        self.setCentralWidget(self.tab)

    def cambiar_titulo(self,indice) :
        print ("Pestaña seleccionada: ",indice)
        self.setWindowTitle("Pestaña"+str(indice))
    

app = QApplication(sys.argv)
window = MainWindow()
window.show()
app.exec()