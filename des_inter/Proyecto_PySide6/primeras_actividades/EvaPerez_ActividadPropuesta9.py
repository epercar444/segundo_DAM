from PySide6.QtWidgets import (
    QApplication, QMainWindow, QWidget,
    QVBoxLayout, QHBoxLayout, QPushButton
)

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Actividad Propuesta 9")

        layout_principal = QHBoxLayout() #creación layout principal

        layout_izquierdo = QVBoxLayout() #layout_vertical
        layout_izquierdo.addWidget(QPushButton("V1"))
        layout_izquierdo.addWidget(QPushButton("V2"))
        layout_izquierdo.addWidget(QPushButton("V3"))
        layout_izquierdo.addWidget(QPushButton("V4"))

        layout_derecho = QHBoxLayout() #layout_horizontal
        layout_derecho.addWidget(QPushButton("H1"))
        layout_derecho.addWidget(QPushButton("H2"))
        layout_derecho.addWidget(QPushButton("H3"))
        layout_derecho.addWidget(QPushButton("H4"))

        #añadimos los layouts al principal
        layout_principal.addLayout(layout_izquierdo)
        layout_principal.addLayout(layout_derecho)

        componente_principal = QWidget() #componente principal para la ventana
        componente_principal.setLayout(layout_principal) #le asignamos el layout principal

        self.setCentralWidget(componente_principal) #centramos el layout principal

app = QApplication([])
ventana = VentanaPrincipal()
ventana.show()
app.exec()
