import sys
import os
from PySide6.QtWidgets import (
    QPushButton, QMainWindow, QApplication, QToolBar, QStatusBar,
    QDockWidget, QLabel, QWidget, QVBoxLayout, QComboBox,
    QCheckBox, QFormLayout, QLineEdit, QTextEdit,
    QDialog, QDialogButtonBox, QMessageBox
)
from PySide6.QtGui import QAction, QKeySequence, QIcon, QPalette, QColor, QPainter, QPen
from PySide6.QtCore import Qt, QRect, Signal


class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Aula Inteligente-Proyecto Integrador")
        self.setMinimumSize(500, 500)

        self.reestablecer = None
        self.salir = None
        self.acercaDe = None

        self.modos = None
        self.iluminacion = None
        self.proyector = None
        self.climatizacion = None

        self.nombre = None
        self.observaciones = None
        self.widgetNuevo = None

        self.crear_central()
        self.crear_acciones()
        self.crear_menus()
        self.crear_toolbar()
        self.crear_statusbar()
        self.crear_dockwidget()

        app.setStyle("Fusion")
        carpeta_actual = os.path.dirname(os.path.abspath(__file__))
        ruta_qss = os.path.join(carpeta_actual, "estilos.qss")
        with open(ruta_qss, "r") as f:
            app.setStyleSheet(f.read())

    def crear_central(self):
        widget_central = QWidget()
        layout_principal = QVBoxLayout()
        form_layout = QFormLayout()

        self.modos = QComboBox()
        self.modos.addItems(["Clase Normal", "Examen", "Presentación", "Charla"])
        form_layout.addRow("Modo del aula:", self.modos)

        self.iluminacion = QCheckBox("Iluminación encendida")
        self.proyector = QCheckBox("Proyector activo")
        self.climatizacion = QCheckBox("Climatización activa")

        layout_checks = QVBoxLayout()
        layout_checks.addWidget(self.iluminacion)
        layout_checks.addWidget(self.proyector)
        layout_checks.addWidget(self.climatizacion)
        form_layout.addRow("Controles:", layout_checks)

        self.nombre = CampoNombreAula()
        form_layout.addRow("Nombre del aula:", self.nombre)

        self.observaciones = QTextEdit()
        self.observaciones.setPlaceholderText("Introduce aquí tus observaciones")
        form_layout.addRow("Observaciones:", self.observaciones)

        self.widgetNuevo = IndicadorEstadoAula()
        form_layout.addRow("Indicador Estado Aula:", self.widgetNuevo)

        layout_principal.addLayout(form_layout)
        widget_central.setLayout(layout_principal)
        self.setCentralWidget(widget_central)

        self.modos.currentTextChanged.connect(self.actualizar_indicador)
        self.iluminacion.stateChanged.connect(self.actualizar_indicador)
        self.proyector.stateChanged.connect(self.actualizar_indicador)
        self.climatizacion.stateChanged.connect(self.actualizar_indicador)

        self.widgetNuevo.estadoCambiado.connect(self.cambiar_estado_aula)

    def crear_acciones(self):
        ruta_icono = os.path.join(os.path.dirname(__file__), "icono.png")

        self.reestablecer = QAction("Restablecer Aula", self)
        self.reestablecer.setShortcut(QKeySequence("Ctrl+R"))
        self.reestablecer.setIcon(QIcon(ruta_icono))
        self.reestablecer.setIconVisibleInMenu(False)
        self.reestablecer.triggered.connect(self.restablecer_aula)

        self.salir = QAction("Salir", self)
        self.salir.setShortcut(QKeySequence("Ctrl+S"))
        self.salir.triggered.connect(self.salir_app)

        self.acercaDe = QAction("Acerca de", self)
        self.acercaDe.setShortcut(QKeySequence("Ctrl+A"))
        self.acercaDe.triggered.connect(self.mostrar_acerca_de)

    def crear_menus(self):
        barra_menus = self.menuBar()

        menu_archivo = barra_menus.addMenu("Archivo")
        menu_archivo.addAction(self.reestablecer)
        menu_archivo.addAction(self.salir)

        menu_ayuda = barra_menus.addMenu("Ayuda")
        menu_ayuda.addAction(self.acercaDe)

    def crear_toolbar(self):
        toolbar = QToolBar()
        toolbar.setToolButtonStyle(Qt.ToolButtonTextBesideIcon)
        toolbar.addAction(self.reestablecer)
        self.addToolBar(toolbar)

    def crear_statusbar(self):
        barra_estado = QStatusBar()
        self.setStatusBar(barra_estado)

        self.estado_aula_label = QLabel()
        barra_estado.addPermanentWidget(self.estado_aula_label)

        self._estado_aula = ""
        self.actualizar_estado_aula()

    def actualizar_estado_aula(self):
        self.estado_aula_label.setText(f"Estado del aula: {self._estado_aula}")

    def cambiar_estado_aula(self, nuevo_estado):
        self._estado_aula = nuevo_estado
        self.actualizar_estado_aula()

    def actualizar_indicador(self):
        self.widgetNuevo.actualizar_estado(
            self.modos.currentText(),
            self.iluminacion.isChecked(),
            self.proyector.isChecked(),
            self.climatizacion.isChecked()
        )

    def restablecer_aula(self):
        self.modos.setCurrentIndex(0)
        self.iluminacion.setChecked(False)
        self.proyector.setChecked(False)
        self.climatizacion.setChecked(False)
        self.nombre.clear()
        self.observaciones.clear()
        self.widgetNuevo.resetear()
        self.statusBar().showMessage("Aula restablecida", 3000)

    def salir_app(self):
        respuesta = QMessageBox.question(
            self,
            "Salir",
            "¿Estás seguro de que deseas salir?",
            QMessageBox.Yes | QMessageBox.No
        )
        if respuesta == QMessageBox.Yes:
            QApplication.quit()

    def mostrar_acerca_de(self):
        QMessageBox.information(
            self,
            "Acerca de",
            "Aula Inteligente\nProyecto Integrador DAM\nEva Pérez Carmona"
        )

    def crear_dockwidget(self):
        dock = QDockWidget("Configuración rápida", self)
        dock.setAllowedAreas(Qt.BottomDockWidgetArea)
        dock.setFeatures(QDockWidget.DockWidgetMovable | QDockWidget.DockWidgetFloatable)

        contenedor = QWidget()
        layout = QVBoxLayout()

        btn_config = QPushButton("Configuración avanzada")
        btn_config.clicked.connect(self.abrir_dialogo)

        layout.addWidget(btn_config)
        contenedor.setLayout(layout)

        dock.setWidget(contenedor)
        self.addDockWidget(Qt.BottomDockWidgetArea, dock)

    def abrir_dialogo(self):
        dialogo = DialogoConfiguracion(self)
        dialogo.exec()


class DialogoConfiguracion(QDialog):
    def __init__(self, parent=None):
        super().__init__(parent)
        self.setWindowTitle("Configuración avanzada del aula")
        self.setModal(True)

        layout = QVBoxLayout()

        self.opcion1 = QCheckBox("Modo ahorro energético")
        self.opcion2 = QCheckBox("Bloquear controles")

        layout.addWidget(self.opcion1)
        layout.addWidget(self.opcion2)

        botones = QDialogButtonBox(
            QDialogButtonBox.Ok | QDialogButtonBox.Cancel
        )
        botones.accepted.connect(self.accept)
        botones.rejected.connect(self.reject)

        layout.addWidget(botones)
        self.setLayout(layout)


class CampoNombreAula(QLineEdit):

    estadoCambiado = Signal(bool)

    def __init__(self, parent=None):
        super().__init__(parent)
        self.setInputMask("<Aaaaaaaaaaa")
        self.setPlaceholderText("Introduce el nombre del aula")
        self.textChanged.connect(self.validar)
        self.valido = False
        self.validar()

    def validar(self):
        texto = self.text().strip()
        if texto == "":
            self.cambiar_color("blanco")
            self.valido = False
        elif len(texto) >= 3:
            self.cambiar_color("verde")
            self.valido = True
        else:
            self.cambiar_color("rojo")
            self.valido = False
        self.estadoCambiado.emit(self.valido)

    def cambiar_color(self, color):
        palette = self.palette()
        if color == "blanco":
            palette.setColor(QPalette.Base, QColor("#ffffff"))
        elif color == "verde":
            palette.setColor(QPalette.Base, QColor("#94ec99"))
        elif color == "rojo":
            palette.setColor(QPalette.Base, QColor("#e68e8e"))
        self.setPalette(palette)


class IndicadorEstadoAula(QWidget):

    estadoCambiado = Signal(str)

    def __init__(self, parent=None):
        super().__init__(parent)
        self.estado = ""
        self.setMinimumSize(100, 100)

    def actualizar_estado(self, modo, iluminacion, proyector, climatizacion):
        if modo == "Presentación" and iluminacion == True and proyector == True:
            self.estado = "Correcto"
        elif modo == "Examen":
            self.estado = "Preparando"
        elif climatizacion == False:
            self.estado = "Incidencia"

        self.estadoCambiado.emit(self.estado)
        self.update()

    def resetear(self):
        self.estado = ""
        self.estadoCambiado.emit("")
        self.update()

    def paintEvent(self, event):
        painter = QPainter(self)
        painter.setRenderHint(QPainter.Antialiasing)

        if self.estado == "Correcto":
            color = QColor("#227908")
        elif self.estado == "Preparando":
            color = QColor("#F7E224")
        elif self.estado == "Incidencia":
            color = QColor("#FF0303")
        else:
            color = QColor("#6B6B6B")

        lado = min(self.width(), self.height())
        recto = QRect(
            (self.width() - lado) // 2,
            (self.height() - lado) // 2,
            lado,
            lado
        )

        painter.setBrush(color)
        painter.drawEllipse(recto)
        painter.setPen(QPen(Qt.white))
        painter.drawText(recto, Qt.AlignCenter, self.estado)


if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()
