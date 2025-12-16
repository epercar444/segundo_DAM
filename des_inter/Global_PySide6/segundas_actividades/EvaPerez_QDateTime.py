# Eva Pérez Carmona
import sys
from PySide6.QtWidgets import QApplication, QMainWindow, QDateTimeEdit
from PySide6.QtCore import QDateTime

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Ejemplo QDateTimeEdit")
        self.editor = QDateTimeEdit()
        self.editor.setDateTime(QDateTime.currentDateTime())
        self.editor.setDisplayFormat("dddd, d 'de' MMMM 'de' yyyy hh:mm") #definimos formato en el que queremos que salga la fecha
        self.editor.setCalendarPopup(True)
        self.editor.dateTimeChanged.connect(self.mostrar_fecha_hora)
        self.setCentralWidget(self.editor)

    def mostrar_fecha_hora(self, datetime):
        print(datetime.toString("dddd, d 'de' MMMM 'de' yyyy hh:mm"))

app = QApplication(sys.argv)
window = MainWindow()
window.show()
app.exec()
