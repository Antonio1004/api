package com.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "DirectorPelicula")
@IdClass(DirecotorPeliculaId.class)
public class DirectorPelicula {



    @ManyToOne
    @JoinColumn(name = "id_director")
    private Director director;

    @ManyToOne
    @JoinColumn(name = "id_pelicula")
    private Pelicula pelicula;

    // Constructor vacío
    public DirectorPelicula() {}

    // Constructor con parámetros
    public DirectorPelicula(Director director, Pelicula pelicula) {
        this.director = director;
        this.pelicula = pelicula;
    }

  

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
}
