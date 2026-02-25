import sys, os
from PySide6.QtWidgets import QApplication, QMainWindow, QWidget, QVBoxLayout,
QLabel, QPushButton
from PySide6.QtCore import Qt
from PySide6.QtGui import QIcon
directorio_principal = os.path.dirname(__file__)
class MainWindow(QMainWindow):
 def __init__(self):
 super().__init__()
 self.setWindowTitle("PySide6 executable")
 layout = QVBoxLayout()
 label = QLabel("Hola mundo!")
 label.setAlignment(Qt.AlignCenter)
 layout.addWidget(label)
 button = QPushButton("Cerrar")
 button.setIcon(QIcon(os.path.join(directorio_principal, "iconos",
"cerrar.png")))
 button.clicked.connect(self.close)
 layout.addWidget(button)
 widget = QWidget()
 widget.setLayout(layout)
 self.setCentralWidget(widget)
app = QApplication(sys.argv)
app.setWindowIcon(QIcon(os.path.join(directorio_principal, "iconos", "mano.png")))
window = MainWindow()
window.show()
app.exec()