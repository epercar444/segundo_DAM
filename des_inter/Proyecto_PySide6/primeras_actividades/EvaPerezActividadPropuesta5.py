#Eva Pérez Carmona
import sys
from PySide6.QtCore import Qt
from PySide6.QtWidgets import QApplication, QCheckBox, QMainWindow

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Preferencias del usuario")

        self.etiqueta = QCheckBox("Seleccionar todo")
        
        #self.etiqueta.setChecked(True)

        self.etiqueta.setCheckState(Qt.PartiallyChecked)
        self.etiqueta.setTristate(True)
        
        
        self.etiqueta.stateChanged.connect(self.mostrar_estado)


        self.setCentralWidget(self.etiqueta)

    def mostrar_estado(self, s):
        state = Qt.CheckState(s)
        if state == Qt.Checked:
            print("Marcado completamente")
        elif state == Qt.Unchecked:
            print("Desmarcado")
        else:
            print("Marcado parcialmente")

app = QApplication(sys.argv)
window = VentanaPrincipal()
window.show()
app.exec()