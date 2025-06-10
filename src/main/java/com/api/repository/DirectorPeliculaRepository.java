package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.model.AcotrPeliculaId;
import com.api.model.ActorPelicula;

public interface DirectorPeliculaRepository extends JpaRepository<ActorPelicula, AcotrPeliculaId> {

}
