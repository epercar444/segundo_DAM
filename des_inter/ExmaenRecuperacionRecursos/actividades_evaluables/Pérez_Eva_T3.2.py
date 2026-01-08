import sys
from PySide6.QtWidgets import (
    QApplication,
    QMainWindow,
    QWidget,
    QVBoxLayout,
    QLabel,
    QPushButton,
    QTextEdit
)
from PySide6.QtCore import Signal
from PySide6.QtGui import QPalette, QColor


class TextoLimitado(QTextEdit): 
    
    # Señales personalizadas
    longitud_cambiada = Signal(int)
    limite_superado = Signal(bool)
    
    def __init__(self, parent=None):
        super().__init__(parent)
        
        self.limite_max = 200     #Definimos un límite máximo de caracteres

        self.textChanged.connect(self.controlar_longitud)  # Conectamos la señal que se emitirá cada vez que el texto cambie
        
        self.aplicar_color_fondo(QColor("#FFFFFF")) #color blanco
    
    def controlar_longitud(self):
        texto_actual = self.toPlainText()
        longitud_actual = len(texto_actual) #obtenemos tanto el texto como la longitud del mismo
        
        if longitud_actual > self.limite_max: #si se supera los caracteres establecidos
            cursor = self.textCursor()
            posicion = cursor.position()
            self.setPlainText(texto_actual[:self.limite_max]) #obtenemos y guardamos la posicion del cursor y cortamos su texto al limite (200)
            
            cursor.setPosition(min(posicion, self.limite_max)) #establecemos una posición mínima (la posición que hemos establecido antes que se actualizará a 200 si es mayor que) y una máxima (200)
            self.setTextCursor(cursor) #colocamos el cursor en la posicion que hemos establecido
            
            longitud_actual = self.limite_max
            self.limite_superado.emit(True) #emitimos la señal de que se ha igualado el límite establecido para que el usuario no pueda seguir escribiendo
        else:
            self.limite_superado.emit(False) #en el caso de que no se supere el límite establecido, el usuario sigue escribiendo
        
        porcentaje = (longitud_actual / self.limite_max) * 100 #calculamos el porcentaje con la longitud actual y con la longitud máxima
        
        if porcentaje < 80:         #aplicamos colores según el porcentaje
            self.aplicar_color_fondo(QColor("#FFFFFF"))
        elif porcentaje < 100:
            self.aplicar_color_fondo(QColor("#EEEC78"))
        else:
            self.aplicar_color_fondo(QColor("#E45C5C"))
        
        self.longitud_cambiada.emit(longitud_actual)         #emitimos la señal con la longitud cambiada
    
    def aplicar_color_fondo(self, color): #definimos un método desde que llamamos a QPalette para cambiar los colores
        paleta = self.palette()
        paleta.setColor(QPalette.Base, color)
        self.setPalette(paleta) 
    
    def obtener_limite_maximo(self): #devuelve el límite máximo de caracteres (200)
        return self.limite_max
    
    def limpiar_contenido(self): #limpia el contenido del texto
        self.clear()


class ContadorCaracteres(QLabel): 
    def __init__(self, limite_max=200, parent=None):
        super().__init__(parent)
        
        self.limite_max = limite_max
        self.longitud_actual = 0
        
        #obtenemos el texto inicial
        self.actualizar_texto()
        self.aplicar_color_texto(QColor("#000000"))
    
    def actualizar_contador(self, longitud): #vamos contando los caracteres de nuestro texto y lo actualizamos
        self.longitud_actual = longitud
        self.actualizar_texto()
        
        porcentaje = (longitud / self.limite_max) * 100
        if porcentaje < 80:
            self.aplicar_color_texto(QColor("#000000"))
        elif porcentaje < 100:
            self.aplicar_color_texto(QColor("#F7C171"))
        else:
            self.aplicar_color_texto(QColor("#E45C5C"))
    
    def actualizar_texto(self): #actualiza el texto que se muestra en la etiqueta a medida que el usuario escribe
        texto = "Caracteres: " + str(self.longitud_actual) + " / " + str(self.limite_max)
        self.setText(texto)
    
    def aplicar_color_texto(self, color): #aplicamos el color usando QPalette
        paleta = self.palette()
        paleta.setColor(QPalette.WindowText, color)
        self.setPalette(paleta)


class LimpiarAviso(QPushButton): #botón conectado a una función para limpiar el texto y lanzar un mensaje
    texto_limpiado = Signal() #señal personalizada
    def __init__(self, parent=None):
        super().__init__("Limpiar texto", parent)
        
        self.aplicar_color_fondo(QColor("#616161"))
        
        self.clicked.connect(self.accion_limpiar) #conectar con la acción cuando se pulse el botón
    
    def accion_limpiar(self):
        self.aplicar_color_fondo(QColor("#8AE986")) #cambiamos el color del botón
        
        self.texto_limpiado.emit() #emitimos la señal cuando el texto se limpie
    
    def aplicar_color_fondo(self, color): #aplicamos colores mediante QPalette
        paleta = self.palette()
        paleta.setColor(QPalette.Button, color)
        self.setPalette(paleta)
        self.setAutoFillBackground(True) #hacemos el color visible
    
    def restaurar_color(self):
        self.aplicar_color_fondo(QColor("#616161"))


class VentanaPrincipal(QMainWindow): 
    def __init__(self):
        super().__init__()
        
        self.setWindowTitle("Editor de notas con avisos")
        self.setMinimumSize(500, 500)
        
        # Contenedor y layout
        contenedor = QWidget()
        layout = QVBoxLayout()
        
        # Crear los widgets derivados
        self.texto = TextoLimitado()
        limite_max = self.texto.obtener_limite_maximo()
        
        self.contador = ContadorCaracteres(limite_max)
        self.boton_limpiar = LimpiarAviso()
        
        # etiqueta informativa inicial
        self.etiqueta_info = QLabel("")
        
        #añadimos los widgets al layout
        layout.addWidget(self.contador)
        layout.addWidget(self.texto)
        layout.addWidget(self.boton_limpiar)
        layout.addWidget(self.etiqueta_info)
        
        contenedor.setLayout(layout)
        self.setCentralWidget(contenedor)
        
        self.conectar_senales() #conectamos señales
    
    def conectar_senales(self):
        self.texto.longitud_cambiada.connect(self.contador.actualizar_contador)
        self.boton_limpiar.texto_limpiado.connect(self.manejar_limpieza)
    
    def manejar_limpieza(self): #se llama a este métodod cuando se emite la señal de que el texto ha sido limpiado
        self.texto.limpiar_contenido() #limpiamos el texto
        self.etiqueta_info.setText("Texto limpiado mediante el botón") #actualizamos etiqueta informativa
    



if __name__ == "__main__":
    app = QApplication(sys.argv)
    ventana = VentanaPrincipal()
    ventana.show()
    sys.exit(app.exec())