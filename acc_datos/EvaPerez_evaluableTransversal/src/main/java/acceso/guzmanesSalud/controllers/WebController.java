package acceso.guzmanesSalud.controllers;

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

import acceso.guzmanesSalud.models.ConstantesVitales;
import acceso.guzmanesSalud.models.Paciente;
import acceso.guzmanesSalud.models.Response;
import acceso.guzmanesSalud.services.PacientesService;
import exceptions.PacienteNotFoundException;


@Controller
@RequestMapping("/salud")
public class WebController {
	@Autowired
	private PacientesService pacienteService;
	
	@GetMapping("/") 
	public String index(Model model) {
		return "index";
	}
	
    @GetMapping("/detalle/{id}")
    public String getPacienteById(@PathVariable Long id, Model model) {
        Paciente paciente = pacienteService.findById(id);
        model.addAttribute("paciente", paciente); 
        return "detalle";
    }
	@ExceptionHandler(PacienteNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Response> handleException(PacienteNotFoundException pnfe) 
	{
	        Response response = Response.errorResonse(Response.NOT_FOUND, pnfe.getMessage());
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	 }
	@PostMapping("/agregarConstantes/{id}")
	public ResponseEntity<ConstantesVitales> addConstante(@RequestBody Paciente paciente,@RequestBody ConstantesVitales constantes) {
		ConstantesVitales addedConstantes = pacienteService.addConstantesVitales(paciente.getId(), constantes);
		return new ResponseEntity<>(addedConstantes, HttpStatus.CREATED);
	}
}
