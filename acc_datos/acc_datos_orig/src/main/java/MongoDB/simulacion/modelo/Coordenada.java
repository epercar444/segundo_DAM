package MongoDB.simulacion.modelo;

public class Coordenada {
	private double lat,lon;

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public Coordenada(double lat, double lon) {
		super();
		this.lat = lat;
		this.lon = lon;
	}

	public Coordenada() {
		super();
	}

	@Override
	public String toString() {
		return "Coordenada [lat=" + lat + ", lon=" + lon + "]";
	}
	
}
