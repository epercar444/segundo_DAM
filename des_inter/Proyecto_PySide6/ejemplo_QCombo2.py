import sys
from PySide6.QtWidgets import QApplication, QMainWindow, QComboBox

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("QComboBox editable")

        combo = QComboBox()
        combo.addItems(["Uno", "Dos", "Tres"])
        combo.setEditable(True)
        combo.setInsertPolicy(QComboBox.InsertAlphabetically)
        combo.setMaxCount(5)

        combo.currentIndexChanged.connect(self.cambio_indice)
        combo.currentTextChanged.connect(self.cambio_texto)

        self.setCentralWidget(combo)

    def cambio_indice(self, i):
        print("Índice:", i)

    def cambio_texto(self, s):
        print("Texto:", s)


app = QApplication(sys.argv)
window = MainWindow()
window.show()
app.exec()