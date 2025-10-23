# Eva Pérez Carmona

#Me he creado dos lases con los correspondientes atributos y métodos. H edecidio que el constructor no reciba el parámetro de la velocidad para poder inciializarlo a 0 como se pide en el enunciado.

class Vehiculo:
    def __init__(self,marca):
        self.marca = marca
        self.velocidad_inicial = 0

    def setMarca(self, marca):
        self.marca = marca

    def setVelocidad_Inicial(self, velocidad_inicial):
        self.velocidad_inicial = velocidad_inicial

    def acelerar(self, v):
        self.velocidad_inicial += v

    def desacelerar(self, v):
        self.velocidad_inicial -= v

    def mostrar_velocidad(self):
        print("Tu velocidad actual es: ",self.velocidad_inicial)


class Coche(Vehiculo):
    def __init__(self):
        super().__init__()
        self.bocina = "¡tuuut!"

    def setBocina(self, bocina):
        self.bocina = bocina

    def tocar_claxon(self):
        print(self.bocina)


coche_1 = Coche("Peugeot 208")
coche_1.setVelocidad_Inicial(10.5)
print("La velocidad inicial de tu coche es: ",coche_1.velocidad_inicial)
coche_1.acelerar(50)
coche_1.desacelerar(15)
coche_1.mostrar_velocidad()
coche_1.tocar_claxon()
