package com.libros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libros.modelos.Libro;
import com.libros.repository.ILibroRepository;

@Service
public class LibroServiceImpl implements ILibroService {

	@Autowired
	ILibroRepository librorepo;
	
	@Override
	public void guardar(Libro libro) {
		librorepo.save(libro);
		
	}

	@Override
	public List<Libro> obtenerLibros() {
		return librorepo.findAll();
	}

}
