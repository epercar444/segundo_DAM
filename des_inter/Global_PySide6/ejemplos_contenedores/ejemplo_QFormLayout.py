from PySide6.QtWidgets import (
    QApplication, QMainWindow, QWidget, QFormLayout,
    QLabel, QLineEdit, QSpinBox, QDoubleSpinBox
)
class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Layout vertical")
        # Creamos un objeto layout formulario
        layout_formulario = QFormLayout()
        componente_principal = QWidget()
        componente_principal.setLayout(layout_formulario)
        self.setCentralWidget(componente_principal)
        # Cada fila contendrá una etiqueta y un componente de entrada
        layout_formulario.addRow(QLabel("Texto:"), QLineEdit())
        layout_formulario.addRow(QLabel("Entero:"), QSpinBox())
        layout_formulario.addRow(QLabel("Decimal:"), QDoubleSpinBox())

app = QApplication([])
ventana = VentanaPrincipal()
ventana.show()
app.exec()
