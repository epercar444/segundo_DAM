from PySide6.QtWidgets import (
    QApplication, QMainWindow, QPushButton, QMessageBox
)


class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Gestión de tareas")

        boton = QPushButton("Gestionar tarea")
        boton.clicked.connect(self.gestionar_tarea)
        self.setCentralWidget(boton)

    def gestionar_tarea(self):
        respuesta = QMessageBox.question(
            self,
            "Acción sobre la tarea",
            "¿Qué quieres hacer con la tarea seleccionada?",
            QMessageBox.Yes | QMessageBox.No | QMessageBox.Ignore,
            QMessageBox.Ignore  # Botón por defecto
        )

        if respuesta == QMessageBox.Yes:
            QMessageBox.information(self, "Resultado", "La tarea se ha marcado como completada.")
        elif respuesta == QMessageBox.No:
            QMessageBox.information(self, "Resultado", "La tarea se ha pospuesto para más tarde.")
        else:  # Ignore
            QMessageBox.information(self, "Resultado", "La tarea se mantiene sin cambios.")


app = QApplication([])
ventana = VentanaPrincipal()
ventana.show()
app.exec()
