package com.libros.service;

import java.util.List;
import com.libros.modelos.Libro;


public interface ILibroService {
	void guardar(Libro libro);
	List<Libro> obtenerLibros();

}
