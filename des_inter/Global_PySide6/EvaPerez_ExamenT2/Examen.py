import sys

from PySide6.QtWidgets import (
QApplication, QMainWindow, QWidget, QLineEdit, QComboBox, QRadioButton, QTextEdit, QFormLayout, QVBoxLayout, QHBoxLayout, QMenuBar, 
QMenu, QToolBar, QMessageBox, QLabel, QStatusBar,QCheckBox,QStackedLayout,QPushButton,QDockWidget,QDialog)
from PySide6.QtGui import QAction,QKeySequence
from PySide6.QtCore import Qt


class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Encuesta de Satisfacción")
        self.setMinimumSize(1000,800)


        #declarar atributos de widgets Pestaña1
        self.nombre = None
        self.telefono = None
        self.company = None
        self.satisfaccionGlobal = None

        #declarar atributos de widgets Pestaña2
        self.cobertura = None
        self.velocidadDatos = None
        self.atencionCliente = None
        self.calidadPrecio = None
        self.checkbox1 = None
        self.checkbox2 = None
        self.checkbox3 = None
        self.checkbox4 = None

        self.recomendado = None
        self.Norecomendado = None

        #declarar acciones
        self.iniciarSesion = None
        self.nuevaEncuesta = None
        self.accion_salir = None
        self.verResumen = None
        self.acercaDe = None

        self.crear_central() 
        self.crear_acciones()            
        self.crear_menus()
        self.crear_toolbar()
        self.crear_statusbar()     
                




    # =========================
    # CREACIÓN DE LA ZONA CENTRAL
    # =========================
    def crear_central(self):
        widget_central = QWidget()
        layout_principal = QVBoxLayout()


        #self.menuVentanas = QStackedLayout()
        #layout_botones = QVBoxLayout()
        #boton1 = QPushButton("Ver datos de la persona")
        #boton2 = QPushButton("Opiniones sobre el servicio")
        #layout_botones.addWidget(boton1)
        #layout_botones.addSpacing(20)
        #layout_botones.addWidget(boton2)
        #layout_principal.addLayout(self.menuVentanas)
        #layout_principal.addLayout(layout_botones)

        #crear widgets de Pestaña1
        self.nombre = QLineEdit()
        self.nombre.setPlaceholderText("Inicia sesión para rellenar el nombre")
        self.nombre.setMaxLength(25)

        self.telefono = QLineEdit()
        self.telefono.setPlaceholderText("Número de Teléfono")
        self.telefono.setMaxLength(9)

        self.company = QComboBox()
        self.company.addItems(["Company1", "Company2", "Company3","Company4","Company5"])
        
        self.satisfaccionGlobal = QComboBox()
        self.satisfaccionGlobal.addItems(["Muy Bien", "Bien", "Regular","Mal","Muy Mal"])


        #crear widgets de Pestaña2
        self.cobertura = QComboBox()
        self.cobertura.addItems(["Muy Bien", "Bien", "Regular","Mal","Muy Mal"])

        self.velocidadDatos = QComboBox()
        self.velocidadDatos.addItems(["Muy Bien", "Bien", "Regular","Mal","Muy Mal"])

        self.atencionCliente = QComboBox()
        self.atencionCliente.addItems(["Muy Bien", "Bien", "Regular","Mal","Muy Mal"])

        self.calidadPrecio = QComboBox()
        self.calidadPrecio.addItems(["Muy Bien", "Bien", "Regular","Mal","Muy Mal"])



        self.checkbox1 = QCheckBox("Valoro más la cobertura que el precio")
        self.checkbox2 = QCheckBox("Valoro más el precio que la veocidad")
        self.checkbox3 = QCheckBox("Me interesan las ofertas")
        self.checkbox4 = QCheckBox("Estoy pensando en cambiar de compañía")



        self.recomendado = QRadioButton("Sí")
        self.Norecomendado = QRadioButton("No")
        self.recomendado.setChecked(True)



        #crear layouts (formulario + layout principal)
        layout_horizontal = QHBoxLayout()
        layout_horizontal.addWidget(self.recomendado)
        layout_horizontal.addSpacing(20) #hace que haya espacio entre un botón y otro
        layout_horizontal.addWidget(self.Norecomendado)


        layout_form = QFormLayout()
        layout_form2 = QFormLayout()

        #añadir widgets al layout de la Pestaña1
        layout_form.addRow("Nombre:",self.nombre)
        layout_form.addRow("Teléfono:",self.telefono)
        layout_form.addRow("Compañía:",self.company)
        layout_form.addRow("Satisfacción Global:",self.satisfaccionGlobal)

        #añadir widgets al layout de la Pestaña1
        layout_form2.addRow("Cobertura:",self.cobertura)
        layout_form2.addRow("Velocidad de Datos:",self.velocidadDatos)
        layout_form2.addRow("Atención al Cliente:",self.atencionCliente)
        layout_form2.addRow("Relación calidad-precio:",self.calidadPrecio)
        layout_form2.addRow("Preferencias del servicio:",self.checkbox1)
        layout_form2.addRow("",self.checkbox2)        
        layout_form2.addRow("",self.checkbox3)        
        layout_form2.addRow("",self.checkbox4)  
        layout_form2.addRow("¿Recomendarías esta compañía a otra persona?",layout_horizontal)      


        self.panel3 = QDockWidget("Notas internas", self)
        self.panel3.setWidget(QTextEdit("Notas internas sobre esta encuesta..."))
        self.panel3.setFeatures(
            QDockWidget.DockWidgetFloatable |
            QDockWidget.DockWidgetClosable
        )  # Flotante + cerrable
        self.addDockWidget(Qt.BottomDockWidgetArea, self.panel3)



        #añadir layouts al layout principal
        layout_principal.addLayout(layout_form)
        layout_principal.addLayout(layout_form2)
        

        #setLayout del widget central
        widget_central.setLayout(layout_principal)
        self.setCentralWidget(widget_central)





    def crear_acciones(self):
        # Crear acciones (QAction) con texto
        self.iniciarSesion = QAction("Iniciar Sesion", self)
        self.iniciarSesion.setShortcut(QKeySequence("Ctrl+L"))
        self.nuevaEncuesta = QAction("Nueva Encuesta", self)
        self.verResumen = QAction("Ver Resumen", self)
        self.accion_salir = QAction("Salir", self)
        self.accion_salir.setShortcut(QKeySequence("Ctrl+S"))
        self.acercaDe = QAction("Acerca de", self)

        self.nuevaEncuesta.triggered.connect(self.slot_nuevaEncuesta)
        self.acercaDe.triggered.connect(self.slot_acerca_de)
        self.accion_salir.triggered.connect(self.slot_salir)
        self.iniciarSesion.triggered.connect(self.slot_iniciarSesion)
        self.verResumen.triggered.connect(self.slot_verResumen)










    
    def crear_menus(self):
        #crear la barra de menús y añadir los menús Archivo y Ayuda
        barra_menus = self.menuBar()
        menu_archivo = barra_menus.addMenu("Encuesta")
        menu_archivo.addAction(self.iniciarSesion)
        menu_archivo.addAction(self.nuevaEncuesta)
        menu_archivo.addAction(self.verResumen)
        menu_archivo.addSeparator()
        menu_archivo.addAction(self.accion_salir)


        menu_ayuda = barra_menus.addMenu("Ayuda")
        menu_ayuda.addAction(self.acercaDe)
        pass

    def crear_toolbar(self):
        #crear barra de herramientas y añadir las acciones básicas
        toolbar = QToolBar()
        toolbar.addAction(self.nuevaEncuesta)
        toolbar.addAction(self.verResumen)
        self.addToolBar(toolbar)
        pass

    def crear_statusbar(self): 
        #crear barra de estado y mostrar un mensaje inicial
        barra_estado = QStatusBar()
        self.setStatusBar(barra_estado)
        barra_estado.showMessage("Aplicación iniciada correctamente", 2000)


    def enviarNuevaEncuenta(self):
        self.nombre.clear()
        self.telefono.clear()
        self.cobertura.setCurrentIndex(0)
        self.velocidadDatos.setCurrentIndex(0)
        self.atencionCliente.setCurrentIndex(0)
        self.calidadPrecio.setCurrentIndex(0)
        self.company.setCurrentIndex(0)
        self.satisfaccionGlobal.setCurrentIndex(0)
        self.recomendado.setChecked(True)
        pass


    def InicioSesion(self):
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
                if password == "interfaces":
                    self.accept()
                else:
                    QMessageBox.warning(self, "Error", "La contraseña es incorrecta")
        dialogo = DialogoLogin()
        resultado = dialogo.exec()
        if resultado == QDialog.Accepted:
            ventana = VentanaPrincipal()
            ventana.showMaximized()
            app.exec()








    def slot_acerca_de(self):
        boton = QMessageBox.information(
            self,
            "Acerca de",
            "Encuesta de satisfacción de compañía de telefonía móvil\nMódulo:Desarrollo de Interfaces\nCiclo:DAM",
            buttons=QMessageBox.Ok,
            defaultButton=QMessageBox.Ok
        )


    def slot_salir(self):
        boton = QMessageBox.question(
            self,
            "Salir",
            "¿Estás segura de que quieres salir?",
            buttons=QMessageBox.Yes | QMessageBox.No,
            defaultButton=QMessageBox.No
        )

        if boton == QMessageBox.Yes:
            self.close()



    def slot_nuevaEncuesta(self):
        boton = QMessageBox.question(
            self,
            "Nueva Encuesta",
            "¿Deseas enviar una nueva encuensta?",
            buttons=QMessageBox.Yes | QMessageBox.No,
            defaultButton=QMessageBox.No
        )
        if boton == QMessageBox.Yes:
            self.enviarNuevaEncuenta()

    def slot_iniciarSesion(self):
        self.InicioSesion()



    def slot_verResumen(self):
        nombre = self.nombre.text()
        company = self.company.currentText()
        satisfaccion = self.satisfaccionGlobal.currentText()
        recomendacion = ''
        if self.recomendado.setChecked :
            recomendacion = "La persona recomienda la compañía"
        else :
            recomendacion = "La persona no recomienda la compañía"

        argumento = f"Nombre: {nombre}\nCompañía: {company}\nSatisfacción Global:{satisfaccion}\n{recomendacion}"
        boton = QMessageBox.information(
            self,
            "Ver Resumen",
            argumento,
            buttons=QMessageBox.Ok,
            defaultButton=QMessageBox.Ok
        )


            





if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    app.exec()