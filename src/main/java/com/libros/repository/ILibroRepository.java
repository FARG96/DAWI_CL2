package com.libros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libros.modelos.Libro;

public interface ILibroRepository  extends JpaRepository<Libro, Integer>{

}
