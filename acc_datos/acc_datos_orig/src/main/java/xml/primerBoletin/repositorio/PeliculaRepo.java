package xml.primerBoletin.repositorio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import xml.primerBoletin.exceptions.NotAddException;
import xml.primerBoletin.modelo.Pelicula;

public class PeliculaRepo {
    private static final Logger logger = LogManager.getLogger(PeliculaRepo.class);
    private List<Pelicula> peliculas;

    public PeliculaRepo(List<Pelicula> peliculas) {
		super();
		this.peliculas = peliculas;
	}

	public PeliculaRepo() {
        super();
        this.peliculas = new ArrayList<>();
    }

	public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public void addPelicula(Pelicula p) throws NotAddException {
    	if (!peliculas.contains(p)) {
        	peliculas.add(p);
    	}
    	else {
    		throw new NotAddException("La película ya existe en la lista"); 
    	    }
    	}

    public void deletePelicula(Pelicula p) throws NotAddException {
    	if (peliculas.contains(p)) {
        	peliculas.remove(p);
    	}
    	else {
    		throw new NotAddException("La película no existe en la lista"); 
    	    }
    	}

    public void updatePelicula(Pelicula p) throws NotAddException {
        boolean actualizado = false;
        for (int i = 0; i < peliculas.size(); i++) {
            Pelicula p1 = peliculas.get(i);
            if (p1.getTitulo().equals(p.getTitulo())) {
                peliculas.set(i, p);
                actualizado = true;
            }
        }
        if (!actualizado) {
            throw new NotAddException("No existe una película con dichos datos en la lista");
        }
    }


    public void readPelicula(Pelicula p) throws NotAddException {
        if (peliculas.contains(p)) {
            logger.info(p.toString());
        } else {
            throw new NotAddException("La película indicada no está en la lista");
        }
    }
}
