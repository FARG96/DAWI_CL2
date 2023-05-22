package com.libros.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.libros.modelos.Libro;
import com.libros.modelos.Tema;
import com.libros.service.ILibroService;
import com.libros.service.ITemaService;

import jakarta.validation.Valid;



@Controller
public class LibroController {
	
	@Autowired
	ILibroService libroservice;
	
	@Autowired
	ITemaService temaservice;
	
	// Listar Libros
	@GetMapping(value = "/listarlibros")
	public String libro(Model model) {
		List<Libro> libros = libroservice.obtenerLibros();
		List<Tema> temas = temaservice.listarTemas();
		model.addAttribute("libro", libros);
		model.addAttribute("tema", temas);
		return "/listarlibros";
	}
	
	// Registrar Libro - GET
	@GetMapping(value = "/registrarlibros")
	public String registrarLibro(Model model) {
		Libro libros = new Libro();
		List<Tema> temas = temaservice.listarTemas();
		
		model.addAttribute("libro", libros);
		model.addAttribute("tema", temas);
		return "/registrarlibros";
	}
	
	// Registar libro - POST
	@PostMapping(value = "/registrarlibros")
	public String saveLibro(@Valid @ModelAttribute Libro libro,
								BindingResult result,
								Model model,
								RedirectAttributes redirectAttributes
								) {
		List<Tema> temas = temaservice.listarTemas();
		if(result.hasErrors()) {
			model.addAttribute("libro", libro);
			model.addAttribute("tema", temas);
			return "/registrarlibros";
		}
		
		libroservice.guardar(libro);
		redirectAttributes.addFlashAttribute("mensaje", "Libro registrado exitosamente.");
		
		return "redirect:/listarlibros";
	}

}
