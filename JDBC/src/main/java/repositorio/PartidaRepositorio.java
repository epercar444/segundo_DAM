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
import modelo.Partida;
import utils.MiExcepcion;
import utils.TipoResultado;

public class PartidaRepositorio {
	private static final Logger logger = LogManager.getLogger(PartidaRepositorio.class);
	private MySqlConector conector;
	public MySqlConector getConector() {
		return conector;
	}
	public void setConector(MySqlConector conector) {
		this.conector = conector;
	}
	public PartidaRepositorio() throws MiExcepcion {
		super();
			this.conector = new MySqlConector();
	}
	
	private int connectAdd(Partida p) { //método para añadir partidas a la bbdd
		int filas = 0;
	    String sql = "INSERT INTO PérezEvaPartida (torneo_id,narrador_id, fecha, resultado) VALUES (?, ?, ?, ?)"; 

	    try {
	    	PreparedStatement stmt = conector.getConnect().prepareStatement(sql); //conectamos con la bbdd
	        	stmt.setInt(1, p.getTorneo_id()); 
	        	stmt.setInt(2, p.getNarrador().getId()); 
		        stmt.setDate(3, p.getFecha());
		        stmt.setString(4, p.getResultado().toString());
		        filas = stmt.executeUpdate(); //devuelve las filas que han sido "modificadas", devolviendola comprobamos que hemos hecho lo que queríamos o no
	    }
	    catch (SQLException e) {
	    	logger.info(e.getMessage());
	    }
	    return filas;
	}
	
	public int addPartido (Partida p) throws MiExcepcion { //método que valida si se puede añadir una partida
	    String sql = "SELECT COUNT(*) FROM PérezEvaPartida"; 
	    int filas = 0;
	    			
	    try {
				PreparedStatement stmt = conector.getConnect().prepareStatement(sql);
		    	ResultSet rs = stmt.executeQuery();
		    	
		    	while (rs.next()) {
		    		int count = rs.getInt(1); //coge los datos de la primera fila, es decir si el count devuelve 3 la variable tendría valor 3
		    		
		    		if (count < 5) {
		    			filas = connectAdd(p);
		    		}
		    		else {
		    			throw new MiExcepcion("No se pueden añadir más de 5 partidas");
		    		}
			} } catch (SQLException e) {
				// TODO Auto-generated catch block
    			logger.info(e.getMessage());
			}
			return filas;
	}
	
	public int updatePuntNarrador (int id,TipoResultado tipoResultado) {
		int filas = 0;
	    String sql = "UPDATE PérezEvaJugador SET puntosTotales = puntosTotales + 3 WHERE id = ?"; 
	    
	    if (tipoResultado.equals(TipoResultado.ALGUNOS)) { //si se cumple la condición se ejecutará la query
	    	try {
	    		PreparedStatement stmt = conector.getConnect().prepareStatement(sql);
	    		stmt.setInt(1, id);
		    	filas = stmt.executeUpdate();
	    	}
	    		catch (SQLException e) {
	    			// TODO Auto-generated catch block
	    			logger.info(e.getMessage());
		}
	    }
	    return filas;
	}
	
	public int updateNOAcertante (int id,TipoResultado tipoResultado) {
		int filas = 0;
	    String sql = "UPDATE PérezEvaJugador SET puntosTotales = puntosTotales + 2 WHERE id = ?"; 
	    
	    if (tipoResultado.equals(TipoResultado.TODOS) || tipoResultado.equals(TipoResultado.NADIE)) {
	    	try {
	    		PreparedStatement stmt = conector.getConnect().prepareStatement(sql);
	    		stmt.setInt(1, id);
		    	filas = stmt.executeUpdate();
	    	}
	    		catch (SQLException e) {
	    			// TODO Auto-generated catch block
	    			logger.info(e.getMessage());
		}
	    }
	    return filas;
	}
	
	public int updateAcertante (int id,TipoResultado tipoResultado) {
		int filas = 0;
	    String sql = getQuery(tipoResultado); 
	    	try {
	    		PreparedStatement stmt = conector.getConnect().prepareStatement(sql);
	    		stmt.setInt(1, id);
		    	filas = stmt.executeUpdate();
	    	}
	    		catch (SQLException e) {
	    			// TODO Auto-generated catch block
	    			logger.info(e.getMessage());
		}
	    return filas;
}
	
	private String getQuery (TipoResultado tipoResultado) { //devuelve la query dependiendo del tipoResultado
		String query = "";
		if (tipoResultado.equals(TipoResultado.ALGUNOS)) {
			query = "UPDATE PérezEvaJugador SET puntosTotales = puntosTotales + 3 WHERE id = ?";
		}
		else {
			query = "UPDATE PérezEvaJugador SET puntosTotales = puntosTotales + 2 WHERE id = ?";
		}
		return query;
	}
	
	public List<Partida> orderByDate () {
		List<Partida> partidas = new ArrayList<>();
		String sql ="SELECT * FROM PérezEvaPartida ORDER BY fecha;";
		try {
			PreparedStatement stmt = conector.getConnect().prepareStatement(sql);
	    	ResultSet rs = stmt.executeQuery(); 
	    	while (rs.next()) { 
	            Partida p = new Partida();
            	p.setId(rs.getInt("id"));
            	p.setFecha(rs.getDate("fecha"));
            	p.setTorneo_id(rs.getInt("torneo_id"));
            	p.setNarrador(getJugador(p.getId()));
            	p.setResultado(TipoResultado.valueOf(rs.getString("resultado")));            	
		        partidas.add(p); //añadimos el jugador a una lista para que nos devuelva a todos los jugadores de la bbdd
             }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	    	logger.info(e.getMessage());
		}
		return partidas;
	}
	
	private Jugador getJugador(int id_Partida){ //devuelve el tipo Jugador necesario para crear la partida
	    Jugador jugador = null;
	    String sql = "SELECT id, nombre, email, puntosTotales FROM PérezEvaJugador WHERE id = ?";

	    try (PreparedStatement stmt = conector.getConnect().prepareStatement(sql)) {
	        stmt.setInt(1, getIdXPartida(id_Partida)); 
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            jugador = new Jugador();
	            jugador.setEmail(rs.getString("email"));
	            jugador.setNombre(rs.getString("nombre"));
	            jugador.setPuntos_totales(rs.getInt("puntosTotales"));
	            jugador.setId(rs.getInt("id"));
	        }
	    } catch (SQLException e) {
	    	logger.info(e.getMessage());
	    }

	    return jugador; 
	}
	
	private int getIdXPartida (int id_Partida) { //devuelve el id_Narrador que será lo que utilicemos para crear el objeto
		int idNarrador = 0;
	    String sql = "SELECT narrador_id FROM PérezEvaPartida WHERE id = ?";
	    try (PreparedStatement stmt = conector.getConnect().prepareStatement(sql)) {
	        stmt.setInt(1, id_Partida); 
	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	        	idNarrador = rs.getInt("narrador_id");
	        }
	    } catch (SQLException e) {
	    	logger.info(e.getMessage());
	    }
	    return idNarrador;
	}

}
