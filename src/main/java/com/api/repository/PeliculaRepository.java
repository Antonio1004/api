package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.model.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

}
