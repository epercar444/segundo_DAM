import sys

from PySide6.QtWidgets import (
QApplication, QMainWindow, QWidget, QLineEdit, QComboBox, QRadioButton, QTextEdit, QFormLayout, QVBoxLayout, QHBoxLayout, QMenuBar, 
QMenu, QToolBar, QMessageBox, QLabel, QStatusBar)
from PySide6.QtGui import QAction
from PySide6.QtCore import Qt


class VentanaPrincipal(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mini Bloc de Notas")
        self.setMinimumSize(500,500)


        #declarar atributos de widgets
        self.line_edit_titulo = None
        self.combo_categoria = None
        self.radio_prioridad_normal = None
        self.radio_prioridad_alta = None
        self.texto_nota = None

        #declarar acciones
        self.accion_limpiar_nota = None
        self.accion_imprimir_nota = None
        self.accion_salir = None
        self.accion_acerca_de = None

        # ConstrucciÃ³n general
        self.crear_central()       
        self.crear_acciones()      
        self.crear_menus()         
        self.crear_toolbar()       # TODO: completar
        self.crear_statusbar()     # TODO: completar
        self.conectar_senales()    # TODO: completar

    # =========================
    # CREACIÃ“N DE LA ZONA CENTRAL
    # =========================
    def crear_central(self):
        widget_central = QWidget()

        #crear widgets del formulario
        self.line_edit_titulo = QLineEdit()
        self.line_edit_titulo.setPlaceholderText("Introduce un título")
        self.line_edit_titulo.setMaxLength(10)


        self.combo_categoria = QComboBox()
        self.combo_categoria.addItems(["Trabajo", "Ideas", "Otros"])


        self.radio_prioridad_normal = QRadioButton("Normal")
        self.radio_prioridad_alta = QRadioButton("Alta")
        self.radio_prioridad_normal.setChecked(True)


        self.texto_nota = QTextEdit()
        self.texto_nota.setPlaceholderText("Escribe aquí tu nota...")

        #crear layouts (formulario + layout principal)
        layout_horizontal = QHBoxLayout()
        layout_horizontal.addWidget(self.radio_prioridad_normal)
        layout_horizontal.addSpacing(20) #hace que haya espacio entre un botón y otro
        layout_horizontal.addWidget(self.radio_prioridad_alta)


        layout_form = QFormLayout()
        layout_principal = QVBoxLayout()

        #añadir widgets al layout del formulario
        layout_form.addRow("Titulo:",self.line_edit_titulo)
        layout_form.addRow("Categoría:",self.combo_categoria)
        layout_form.addRow("Prioridad:",layout_horizontal)


        #añadir layouts al layout principal
        layout_principal.addLayout(layout_form)
        layout_principal.addWidget(self.texto_nota) #para que consiga el mismo ancho que la ventana tenga
        

        #setLayout del widget central
        widget_central.setLayout(layout_principal)

        self.setCentralWidget(widget_central)

    # =========================
    # ACCIONES, MENÃš Y TOOLBAR
    # =========================
    def crear_acciones(self):
        #crear acciones (QAction) con texto y atajos
        self.accion_limpiar_nota = QAction("Limpiar nota", self)
        # self.accion_limpiar_nota.triggered.connect(...)
        self.accion_imprimir_nota = QAction("Imprimir nota", self)
        # self.accion_limpiar_nota.triggered.connect(...)        
        self.accion_salir = QAction("Salir", self)
        # self.accion_limpiar_nota.triggered.connect(...)
        self.accion_acerca_de = QAction("Acerca de", self)
        # self.accion_limpiar_nota.triggered.connect(...)
        pass


    def crear_menus(self):
        #crear la barra de menús y añadir los menús Archivo y Ayuda
        barra_menus = self.menuBar()
        menu_archivo = barra_menus.addMenu("Archivo")
        menu_archivo.addAction(self.accion_limpiar_nota)
        menu_archivo.addAction(self.accion_imprimir_nota)
        menu_archivo.addAction(self.accion_salir)

        menu_ayuda = barra_menus.addMenu("Ayuda")
        menu_ayuda.addAction(self.accion_acerca_de)
        pass


    def crear_toolbar(self):
        #crear barra de herramientas y añadir las acciones básicas
        toolbar = QToolBar()
        toolbar.addAction(self.accion_limpiar_nota)
        toolbar.addAction(self.accion_imprimir_nota)
        self.addToolBar(toolbar)
        pass

    def crear_statusbar(self,valor=None): #valor recibe la señal que emiten al ser modificados
        #crear barra de estado y mostrar un mensaje inicial
        barra_estado = QStatusBar()
        self.setStatusBar(barra_estado)

        self.accion_limpiar_nota.setStatusTip("Limpiando nota")
        self.accion_imprimir_nota.setStatusTip("Imprimiendo nota")
        self.accion_salir.setStatusTip("Saliendo")

        sender = self.sender()  # obtengo el widget que envió la señal

        if sender == self.line_edit_titulo:
            self.statusBar().showMessage("Título modificado:", valor)
        elif sender == self.combo_categoria:
            categoria = self.combo_categoria.currentText()
            self.statusBar().showMessage("Categoría modificada:", categoria)
        elif sender == self.radio_prioridad_normal  or sender == self.radio_prioridad_alta:
            if self.radio_prioridad_normal.isChecked() :
                prioridad = "Normal"
                self.statusBar().showMessage("Prioridad modificada:",prioridad)
            else :
                prioridad = "Alta"
                self.statusBar().showMessage("Prioridad modificada:",prioridad)   
        pass



    # =========================
    # SEÑALES
    # =========================
    def conectar_senales(self):
        # conectar señales como textChanged, currentTextChanged, toggled...
        self.line_edit_titulo.textChanged.connect(self.crear_statusbar)
        self.combo_categoria.currentIndexChanged.connect(self.crear_statusbar)
        self.radio_prioridad_normal.toggled.connect(self.crear_statusbar)
        self.radio_prioridad_alta.toggled.connect(self.crear_statusbar)
        pass



       


if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()
        
