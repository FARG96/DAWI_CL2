package com.libros.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.libros.modelos.Tema;

@Service
public interface ITemaService {

	void guardartema(Tema tema);
	List<Tema> listarTemas();
}
