package repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import configuracion.MySqlConector;
import modelo.Jugador;
import utils.MiExcepcion;

public class JugadorRepositorio {
	private static final Logger logger = LogManager.getLogger(JugadorRepositorio.class);
	private MySqlConector conector;
	private List<Jugador> jugadores;
	
	public JugadorRepositorio() throws MiExcepcion {
		super();
		this.conector = new MySqlConector();
		this.jugadores = new ArrayList<>();
	}
	public MySqlConector getConector() {
		return conector;
	}
	public void setConector(MySqlConector conector) {
		this.conector = conector;
	}
	public void cargarJugadores() { //carga la lista jugadores con la información de nuestra BBDD
	    String sql = "SELECT * FROM PérezEvaJugador;";

	    try {
	        PreparedStatement stmt = conector.getConnect().prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            Jugador j = new Jugador();
	            j.setId(rs.getInt("id"));
	            j.setNombre(rs.getString("nombre"));
	            j.setEmail(rs.getString("email"));
	            j.setPuntos_totales(rs.getInt("puntosTotales"));
	            this.jugadores.add(j);
	        }
	    } catch (SQLException e) {
	        logger.info(e.getMessage());
	    }
	}
	
	public int addJugador(Jugador j){
		int filas = 0;
	    String sql = "INSERT INTO PérezEvaJugador (nombre, email, puntosTotales) VALUES (?, ?, ?)"; //definimos nuestra query

	    try {
	    	PreparedStatement stmt = conector.getConnect().prepareStatement(sql); //conectamos con la bbdd
		        stmt.setString(1, j.getNombre()); //insertamos los datos del jugador a insertar
		        stmt.setString(2, j.getEmail());
		        stmt.setInt(3, j.getPuntos_totales());
		        filas = stmt.executeUpdate(); //devuelve las filas que han sido "modificadas", devolviendola comprobamos que hemos hecho lo que queríamos o no
		        jugadores.add(j);
	    }
	    catch (SQLException e) {
	    	logger.info(e.getMessage());
	    }
	    return filas;
	}
	
	public Jugador getPlayerMaxPunt () {
		Jugador j = null;
	    String sql = "SELECT * FROM PérezEvaJugador ORDER BY puntosTotales DESC LIMIT 1;";
			try {
				PreparedStatement stmt = conector.getConnect().prepareStatement(sql);
		    	ResultSet rs = stmt.executeQuery(); //devuelve las filas al ejecutar el query
		    	while (rs.next()) { //las recorremos
		            j = new Jugador();//nos cremos un objeto Jugador que será el que devolvamos
		                j.setId(rs.getInt("id"));
		            	j.setNombre(rs.getString("nombre"));
		            	j.setEmail(rs.getString("email"));
		                j.setPuntos_totales(rs.getInt("puntosTotales"));
		             }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
		    	logger.info(e.getMessage());
			}
			return j;
	    }
	
	
	public List<Jugador> getByPuntosTotales () {
		List<Jugador> jugadores = new ArrayList<>();
	    String sql = "SELECT nombre,puntosTotales FROM PérezEvaJugador ORDER BY puntosTotales;";
			try {
				PreparedStatement stmt = conector.getConnect().prepareStatement(sql);
		    	ResultSet rs = stmt.executeQuery(); 
		    	while (rs.next()) { 
		            Jugador j = new Jugador();
	            	j.setNombre(rs.getString("nombre"));
	                j.setPuntos_totales(rs.getInt("puntosTotales"));
			        jugadores.add(j); //añadimos el jugador a una lista para que nos devuelva a todos los jugadores de la bbdd
	             }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
		    	logger.info(e.getMessage());
			}
			return jugadores;
	    }
	}


