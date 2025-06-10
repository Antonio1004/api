package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.model.DirecotorPeliculaId;
import com.api.model.DirectorPelicula;

public interface DirectorPeliculaRepository extends JpaRepository<DirectorPelicula, DirecotorPeliculaId> {

}
