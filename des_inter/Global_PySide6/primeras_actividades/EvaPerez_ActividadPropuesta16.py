from PySide6.QtWidgets import (
    QApplication, QMainWindow, QWidget, QVBoxLayout, QPushButton,
    QLabel, QFileDialog, QColorDialog, QFontDialog
)
from PySide6.QtGui import QFont


class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Gestión de archivo y preferencias")

        #  Widget central 
        contenedor = QWidget()
        layout = QVBoxLayout()
        contenedor.setLayout(layout)
        self.setCentralWidget(contenedor)

        #  QLabel donde mostraremos el texto del archivo 
        self.label_texto = QLabel("")
        self.label_texto.setStyleSheet("padding: 10px; background-color: white;")
        layout.addWidget(self.label_texto)

        #  Botones 
        boton_abrir = QPushButton("Abrir archivo de texto")
        boton_guardar = QPushButton("Guardar archivo como...")
        boton_color = QPushButton("Elegir color de fondo")
        boton_fuente = QPushButton("Cambiar fuente del texto")

        layout.addWidget(boton_abrir)
        layout.addWidget(boton_guardar)
        layout.addWidget(boton_color)
        layout.addWidget(boton_fuente)

        #  Conexiones 
        boton_abrir.clicked.connect(self.abrir_archivo)
        boton_guardar.clicked.connect(self.guardar_archivo)
        boton_color.clicked.connect(self.cambiar_color)
        boton_fuente.clicked.connect(self.cambiar_fuente)


    # 1. Abrir archivo de texto

    def abrir_archivo(self):
        ruta, _ = QFileDialog.getOpenFileName(
            self,
            "Abrir archivo de texto",
            "",
            "Archivos de texto (*.txt)"
        )

        if ruta:
            with open(ruta, "r", encoding="utf-8") as f:
                contenido = f.read()
            self.label_texto.setText(contenido)


    # 2. Guardar archivo como

    def guardar_archivo(self):
        ruta, _ = QFileDialog.getSaveFileName(
            self,
            "Guardar archivo como",
            "",
            "Archivos de texto (*.txt)"
        )

        if ruta:
            with open(ruta, "w", encoding="utf-8") as f:
                f.write(self.label_texto.text())


    # 3. Elegir color de fondo

    def cambiar_color(self):
        color = QColorDialog.getColor()

        if color.isValid():
            self.label_texto.setStyleSheet(
                f"background-color: {color.name()}; padding: 10px;"
            )


    # 4. Cambiar fuente del texto

    def cambiar_fuente(self):
        fuente, ok = QFontDialog.getFont()

        if ok:
            self.label_texto.setFont(fuente)


#  Programa principal 
app = QApplication([])
ventana = VentanaPrincipal()
ventana.show()
app.exec()
