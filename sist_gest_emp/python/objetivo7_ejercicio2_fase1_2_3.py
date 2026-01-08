#Eva Pérez Carmona

class Video:
    def __init__(self,titulo_video,duracion_mn,categoria):
        self.titulo = titulo_video
        self.duracion_mn = duracion_mn
        self.categoria = categoria

    def mirar_video (self) :
        print("Iniciando el video...")
        print("El video que estás viendo se titula '",self.titulo,"' de la categoria '",self.categoria,"' con una duración de '",self.duracion_mn,"'")

    def detener_video (self) :
        print("Deteniendo el video")

class Audio:
    def __init__(self,titulo_audio,nombre_artista):
        self.titulo = titulo_audio
        self.nombre_artista = nombre_artista

    def escuchar_audio (self) :
        print("Iniciando el audio...")
        print("El audio que estás escuchando es '",self.titulo,"' producido por el artista' ",self.nombre_artista,"'")

    def detener_audio (self) :
        print("Deteniendo la reproducción del audio")

class Media(Video,Audio) :
    def __init__(self,titulo_video,duracion_mn,categoria,nombre_artista):
        self.titulo = titulo_video
        self.duracion_mn = duracion_mn
        self.categoria = categoria
        self.nombre_artista = nombre_artista

medio_1 = Media("Titulo 1", 180,"infantil", "Artista 1")
medio_1.escuchar_audio()
medio_1.mirar_video()
medio_1.detener_audio()
medio_1.detener_video()

