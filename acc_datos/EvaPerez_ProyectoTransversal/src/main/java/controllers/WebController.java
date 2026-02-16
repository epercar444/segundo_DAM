package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import services.AutorService;
import services.LectorService;
import services.LibroService;

@Controller
@RequestMapping("/readly")
public class WebController {
	@Autowired
	private AutorService autorService;
	private LibroService libroService;
	private LectorService lectorService;
}
