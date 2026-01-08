from PySide6.QtWidgets import (
    QApplication, QMainWindow, QPushButton, QDialog,
    QLabel, QVBoxLayout, QDialogButtonBox
)


class DialogoModo(QDialog):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Seleccionar modo")

        self.boton = None  # Guardará qué botón se pulsó

        etiqueta = QLabel("Selecciona el modo de operación que quieres activar:")

        botones = QDialogButtonBox(
            QDialogButtonBox.Yes |
            QDialogButtonBox.No |
            QDialogButtonBox.Help
        )

        # Conectar cada botón
        botones.button(QDialogButtonBox.Yes).clicked.connect(self.pulsar_yes)
        botones.button(QDialogButtonBox.No).clicked.connect(self.pulsar_no)
        botones.button(QDialogButtonBox.Help).clicked.connect(self.pulsar_help)

        layout = QVBoxLayout()
        layout.addWidget(etiqueta)
        layout.addWidget(botones)

        self.setLayout(layout)

    def pulsar_yes(self):
        self.boton = "YES"
        self.accept()

    def pulsar_no(self):
        self.boton = "NO"
        self.accept()

    def pulsar_help(self):
        self.boton = "HELP"
        self.reject()


class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Selección de modo de operación")

        boton = QPushButton("Elegir modo")
        boton.clicked.connect(self.mostrar_dialogo)
        self.setCentralWidget(boton)

    def mostrar_dialogo(self):
        dialogo = DialogoModo()
        resultado = dialogo.exec()

        if resultado == QDialog.Accepted:
            if dialogo.boton == "YES":
                print("Modo A activado")
            elif dialogo.boton == "NO":
                print("Modo B activado")
        else:
            print("Se ha solicitado ayuda")


app = QApplication([])
ventana = VentanaPrincipal()
ventana.show()
app.exec()
