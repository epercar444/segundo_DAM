import sys
import os
from PySide6.QtWidgets import (
    QApplication,
    QMainWindow,
    QWidget,
    QVBoxLayout,
    QLabel,
    QLineEdit,
    QPushButton,
    QCheckBox,
    QRadioButton,
    QComboBox
)


class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Tarea 3.1-Eva Pérez Carmona")

        # --- Widgets ---
        self.presentacionCheckBox = QLabel("CheckBox:")
        self.checkbox = QCheckBox("Acepto los términos y condiciones")
        self.checkbox.setChecked(True)

        self.presentacionLine = QLabel("QLineEdit:")
        self.nombre = QLineEdit()
        self.nombre.setPlaceholderText("Introduce tu nombre")

        self.presentacionCombo = QLabel("QComboBox:")
        self.pregunta_pais = QLabel("Selecciona tu país de residencia")
        self.pais = QComboBox()
        lista_paises = ["España","Alemania","Francia","Italia","Inglaterra"]
        self.pais.addItems(lista_paises)

        self.presentacionPush = QLabel("QPushButton:")
        self.boton_aceptar = QPushButton("Aceptar")
        self.boton_cancelar = QPushButton("Cancelar")

        self.presentacionRadio = QLabel("QRadioButton:")
        self.satisfaccion = QLabel("¿Cómo de satisfecho está con el servicio?")
        self.buena = QRadioButton("Buena")
        self.regular = QRadioButton("Regular")
        self.mala = QRadioButton("Mala")


        # --- Layout ---
        layout = QVBoxLayout()
        layout.addSpacing(20)
        layout.addWidget(self.presentacionLine)
        layout.addWidget(self.nombre)

        layout.addSpacing(20)
        layout.addWidget(self.presentacionCombo)
        layout.addWidget(self.pregunta_pais)
        layout.addWidget(self.pais)
        
        layout.addSpacing(20)
        layout.addWidget(self.presentacionPush)
        layout.addWidget(self.satisfaccion)
        layout.addWidget(self.buena)
        layout.addWidget(self.regular)
        layout.addWidget(self.mala)

        layout.addSpacing(20)
        layout.addWidget(self.presentacionRadio)
        layout.addWidget(self.boton_aceptar)
        layout.addWidget(self.boton_cancelar)

        layout.addSpacing(20)
        layout.addWidget(self.presentacionCheckBox)
        layout.addWidget(self.checkbox)
        layout.addSpacing(20)







        contenedor = QWidget()
        contenedor.setLayout(layout)
        self.setCentralWidget(contenedor)



if __name__ == "__main__":
    app = QApplication(sys.argv)
    app.setStyle("Fusion")

    #busca la carpeta donde está ubicado el archivo .py
    carpeta_actual = os.path.dirname(os.path.abspath(__file__))
    #busca el nombre del archivo que introduzcamos en la ruta de la carpeta que hemos guardado anteriormente
    ruta_qss = os.path.join(carpeta_actual, "Pérez_Eva_estilos_T3.1.qss")
    #abre el archivo .qss
    with open(ruta_qss, "r") as f:
        app.setStyleSheet(f.read())

    ventana = MainWindow()
    ventana.show()
    sys.exit(app.exec())