from PySide6.QtWidgets import (
    QApplication, QMainWindow, QDialog, QLabel, QPushButton,
    QVBoxLayout, QLineEdit, QMessageBox
)
from PySide6.QtCore import Qt

# Diálogo de inicio de sesión
class DialogoLogin(QDialog):
    def __init__(self):
        super().__init__()

        # Título del diálogo
        self.setWindowTitle("Iniciar sesión")

        # Layout principal
        layout = QVBoxLayout()

        # Campo de usuario
        self.campo_usuario = QLineEdit()
        self.campo_usuario.setPlaceholderText("Usuario")

        # Campo de contraseña
        self.campo_password = QLineEdit()
        self.campo_password.setPlaceholderText("Contraseña")
        self.campo_password.setEchoMode(QLineEdit.Password)

        # Botón de acceso
        boton_login = QPushButton("Acceder")
        boton_login.clicked.connect(self.validar)

        # Añadir widgets al layout
        layout.addWidget(self.campo_usuario)
        layout.addWidget(self.campo_password)
        layout.addWidget(boton_login)

        # Establecer layout
        self.setLayout(layout)

    # Validar credenciales
    def validar(self):
        usuario = self.campo_usuario.text()
        password = self.campo_password.text()

        # Comprobar usuario y contraseña
        if usuario == "admin" and password == "admin":
            self.accept()
        else:
            QMessageBox.warning(self, "Error", "El usuario o la contraseña son incorrectos")


# Ventana principal
class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

        # Título ventana principal
        self.setWindowTitle("Aplicación")

        # Texto centrado
        etiqueta = QLabel("Ventana principal")
        etiqueta.setAlignment(Qt.AlignCenter)

        # Establecer QLabel como widget central
        self.setCentralWidget(etiqueta)


# Crear aplicación
app = QApplication([])

# Crear y ejecutar diálogo de login
dialogo = DialogoLogin()
resultado = dialogo.exec()

# Si el login es correcto, mostrar ventana principal maximizada
if resultado == QDialog.Accepted:
    ventana = VentanaPrincipal()
    ventana.showMaximized()
    app.exec()
