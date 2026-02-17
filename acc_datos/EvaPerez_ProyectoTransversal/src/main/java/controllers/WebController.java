package controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import exceptions.AutorNotFoundException;
import exceptions.LectorNotFoundException;
import exceptions.LibroNotFoundException;
import models.Autor;
import models.Lector;
import models.Libro;
import services.AutorService;
import services.LectorService;
import services.LibroService;

@Controller
@RequestMapping("/readly")
public class WebController {
	@Autowired
	private AutorService autorService;
	@Autowired
	private LibroService libroService;
	@Autowired
	private LectorService lectorService;
	
	@RequestMapping("/") 
	public String index(Model model) {
		return "index";
	}
	//alta de todas las entidades
	@PostMapping("/autor")
	public ResponseEntity<Autor> addAutor(@RequestBody Autor autor) {
		Autor addedAutor = autorService.createAutor(autor);
		return new ResponseEntity<>(addedAutor, HttpStatus.CREATED);
	}
	
	@PostMapping("/libro")
	public ResponseEntity<Libro> addLibro(@RequestBody Libro libro) {
		Libro addedLibro = libroService.createLibro(libro);
		return new ResponseEntity<>(addedLibro, HttpStatus.CREATED);
	}
	
	@PostMapping("/lector")
	public ResponseEntity<Lector> addLector(@RequestBody Lector lector) {
		Lector addedLector = lectorService.createLector(lector);
		return new ResponseEntity<>(addedLector, HttpStatus.CREATED);
	}
	
	//listado de todas las entidades
	@RequestMapping("/autores") //html
	public String catalogAutor(Model model) {
		List<Autor> autores = autorService.findAll();
		System.out.println(autores);
		model.addAttribute("autores", autores);
		return "autores";
	}
	@ExceptionHandler(AutorNotFoundException.class) //controlamos excepción
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Response> handleException(AutorNotFoundException anf) 
	{
	        Response response = Response.errorResonse(Response.NOT_FOUND, anf.getMessage());
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	 }
	
	@RequestMapping("/libros") //html
	public String catalogLibro(Model model) {
		List<Libro> libros = libroService.findAll();
		System.out.println(libros);
		model.addAttribute("libros", libros);
		return "libros";
	}
	@ExceptionHandler(LibroNotFoundException.class)//controlamos excepción
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Response> handleException(LibroNotFoundException lnf) 
	{
	        Response response = Response.errorResonse(Response.NOT_FOUND, lnf.getMessage());
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	 }
	
	@RequestMapping("/lectores") //html
	public String catalogLector(Model model) {
		List<Lector> lectores = lectorService.findAll();
		System.out.println(lectores);
		model.addAttribute("lectores", lectores);
		return "lectores";
	}
	@ExceptionHandler(LectorNotFoundException.class)//controlamos excepción
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Response> handleException(LectorNotFoundException lectornf) 
	{
	        Response response = Response.errorResonse(Response.NOT_FOUND, lectornf.getMessage());
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	 }
	
    // Método para obtener un producto por ID, get para recuperar, put para actualizar
    @GetMapping("/autor/{id}")
    public ResponseEntity<Autor> getAutorById(@PathVariable Long id) {
        Autor autor = autorService.findAutorById(id);
        return ResponseEntity.ok(autor);
    }
    @PutMapping ("/autor/{id}")
    public ResponseEntity<Autor> getAutorById(@PathVariable Long id,@RequestBody Autor autor) {
        Autor addedAutor = autorService.updateNameAutor(id,autor);
        return new ResponseEntity<>(addedAutor,HttpStatus.OK);
    }
    
    // Método para obtener un producto por ID, get para recuperar, put para actualizar
    @GetMapping("/libro/{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable Long id) {
        Libro libro = libroService.findLibroById(id);
        return ResponseEntity.ok(libro);
    }
    @PutMapping ("/libro/{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable Long id,@RequestBody Libro libro) {
        Libro addedLibro = libroService.updatepagTotalesLibro(id, libro);
        return new ResponseEntity<>(addedLibro,HttpStatus.OK);
    }
    
    // Método para obtener un producto por ID, get para recuperar, put para actualizar
    @GetMapping("/lector/{id}")
    public ResponseEntity<Lector> getLectorById(@PathVariable Long id) {
        Lector lector = lectorService.findLectorById(id);
        return ResponseEntity.ok(lector);
    }
    @PutMapping ("/lector/{id}")
    public ResponseEntity<Lector> getLectorById(@PathVariable Long id,@RequestBody Lector lector) {
        Lector addedLector = lectorService.updateLibrosLector(id, lector);
        return new ResponseEntity<>(addedLector,HttpStatus.OK);
    }
    
    //Método para filtrar por username
    @GetMapping("/lector/{username}")
    public ResponseEntity<Set<Lector>> getLectorByUsername(@PathVariable String username) {
        Set<Lector> lector = lectorService.findByUsername(username);
        return ResponseEntity.ok(lector);
    }
	
}
