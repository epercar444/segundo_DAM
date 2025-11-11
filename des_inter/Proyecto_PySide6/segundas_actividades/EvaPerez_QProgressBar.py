# Eva Pérez Carmona
import sys
from PySide6.QtCore import QTimer
from PySide6.QtWidgets import QApplication, QMainWindow, QProgressBar

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Ejemplo QProgressBar")
        self.progreso_actual = 0

        self.progreso = QProgressBar()
        self.progreso.setRange(0, 100)

        self.timer = QTimer()
        self.timer.timeout.connect(self.preguntar_usuario)
        self.timer.start(2000)

        self.setCentralWidget(self.progreso)

    def preguntar_usuario(self):
        print("=== Control de progreso ===")
        print("1 -> Aumentar progreso")
        print("2 -> Retroceder progreso")
        print("0 -> Salir")

        opcion = input("Elige una opción: ")

        if opcion == "1":
            self.cambiar_progreso("aumentar")
        elif opcion == "2":
            self.cambiar_progreso("disminuir")
        elif opcion == "0":
            print("Saliendo del programa...")
            self.timer.stop()
            QApplication.quit()
        else:
            print("Opción no válida.")

    def cambiar_progreso(self, tipo):
        if tipo == "aumentar":
            self.progreso_actual = min(self.progreso_actual + 20, 100)
        else:
            self.progreso_actual = max(self.progreso_actual - 20, 0)

        self.progreso.setValue(self.progreso_actual)

        if self.progreso_actual == 100:
            self.setWindowTitle("¡Tarea completada!")
        else:
            self.setWindowTitle(f"Progreso {self.progreso_actual}%")
            print(f"Progreso actual: {self.progreso_actual}%")

app = QApplication(sys.argv)
window = MainWindow()
window.show()
app.exec()
