from PySide6.QtWidgets import QApplication, QMainWindow, QPushButton
class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Mi Aplicación")

        boton = QPushButton("Púlsame!")
        boton.clicked.connect(self.el_boton_fue_pulsado)
        boton.setCheckable(True) #el botón se convierte en un interrumptor
        boton.clicked.connect(self.el_boton_esta_on)
        self.setCentralWidget(boton) #si no se pone no se centra y no aparece

    def el_boton_fue_pulsado(self) :
        print("Pulsado!")

    def el_boton_esta_on (self,checked) :
        print("Está ON?",checked)

app = QApplication()
window = VentanaPrincipal()
window.show()
app.exec()