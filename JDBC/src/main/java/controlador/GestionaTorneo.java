package controlador;

import java.sql.Date;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelo.Jugador;
import modelo.Partida;
import servicio.JugadorServicio;
import servicio.PartidaServicio;
import utils.TipoResultado;

public class GestionaTorneo {
	private static final Logger logger = LogManager.getLogger(GestionaTorneo.class);
	public static void main(String[] args) {
		
		//JUGADORES
		JugadorServicio servicioJ = new JugadorServicio();
		
		//addJugador	
		/*for (int i = 0; i < 6; i++) { //añadimos dos jugadores más del que nos dice el enunciado para poder crearnos las partidas que dice este
			Jugador j = new Jugador("jugador"+(i+1)+"@prueba.com", "Jugador"+(i+1), 50*(i+1));
			logger.info(servicioJ.addJugador(j));
		}*/
		
		//getPlayerMaxPunt
		//logger.info(servicioJ.getPlayerMaxPunt());
		
		//orderBy
		/*List<Jugador> jugadoresOrderBy = servicioJ.orderBy();
		for (Jugador j : jugadoresOrderBy) {
			logger.info(j);
		}*/
		
		
		//PARTIDAS
		PartidaServicio servicioP = new PartidaServicio();
		
		//addPartida
		/*Random r = new Random(); //necesario para crear fechas aleatorias
		TipoResultado[] opciones = TipoResultado.values(); //guardarmos los valores del enum
		for (int i = 0; i < 6; i++) { //añadimos 6 partidas de manera que en la última saltará una excepción controlada
			TipoResultado resultadoRotativo = opciones[i % opciones.length]; //los rotamos de manera que no todos los resultados sean iguales 
			Jugador j = new Jugador("jugador"+(i+1)+"@prueba.com", "Jugador"+(i+1), 50*(i+1));
			j.setId(i + 1); //forzamos que tenga un id que aparezca en la base de datos para que se pueda insertar
			Partida p = new Partida(j, new Date(System.currentTimeMillis() - (r.nextInt(365) * 86400000L)), resultadoRotativo,i+1); //el long son los milisegundos que tiene un día
			//la cuenta de Date es necesaria para que nos dé fechas diferentes y podamos ordenarlas
			
			logger.info(servicioP.addPartida(p));
		}*/
		
		//updatePuntNarrador
		/*logger.info(servicioP.updatePuntNarrados(3, TipoResultado.ALGUNOS));
		logger.info(servicioP.updatePuntNarrados(4, TipoResultado.TODOS));*/
		
		//updateNOAcertante
		/*logger.info(servicioP.updateNOAcertantes(1, TipoResultado.NADIE));
		logger.info(servicioP.updateNOAcertantes(2, TipoResultado.TODOS));
		logger.info(servicioP.updateNOAcertantes(4, TipoResultado.ALGUNOS));*/

		//updateAcertante
		/*logger.info(servicioP.updateAcertante(4, TipoResultado.ALGUNOS));
		logger.info(servicioP.updateAcertante(5, TipoResultado.NADIE));
		logger.info(servicioP.updateAcertante(6, TipoResultado.TODOS));*/
		
		//orderByDate
		/*List<Partida> partidasOrderBy = servicioP.orderByDate();
		for (Partida p : partidasOrderBy) {
			logger.info(p);
		}*/
	}
}
