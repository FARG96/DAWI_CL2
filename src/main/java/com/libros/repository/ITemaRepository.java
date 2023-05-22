package com.libros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libros.modelos.Tema;

public interface ITemaRepository extends JpaRepository<Tema, Integer>{

}
