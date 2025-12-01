package MongoDB.boletin2.controlador;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoDatabase;

import MongoDB.boletin2.modelo.Dispositivo;
import MongoDB.boletin2.modelo.Especificacion;
import MongoDB.boletin2.servicio.DispositivoServicio;
import MongoDB.configuracion.MongoDBConexion;

public class GestionaDispositivos {
	public static void main(String[] args) {
		MongoDBConexion conexion = new MongoDBConexion();
		MongoDatabase db= conexion.getDb();	
		DispositivoServicio servicio = new DispositivoServicio(db);
		
		List<Dispositivo> dispositivos = servicio.read();
		/*for (Dispositivo d : dispositivos) {
			System.out.println(d);
		}*/
		
		//System.out.println(servicio.getXCategoria("Red"));
		
		/*Dispositivo d = new Dispositivo(51, 10, 299.99, "Smartphone X", "Electrónica", new ArrayList<>(), new Especificacion("WiFi 6", "Global", 5));
		servicio.addDispositivo(d);
		System.out.println(servicio.getRepo().getDispositivos());*/
		
		servicio.actualizaDispositivo("Tablet Amazon Fire Max 11", 20);
		for (Dispositivo d : dispositivos) {
			if (d.getNombre().equals("Tablet Amazon Fire Max 11")) {
				System.out.println(d);
			}
		}
	}
	
}
