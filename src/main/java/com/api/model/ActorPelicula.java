package com.api.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "Pelicula_Director")
@IdClass(AcotrPeliculaId.class)
public class ActorPelicula implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_director")
    @JsonBackReference // Este lado no serializa para romper ciclo
    private Director director;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_pelicula")
    @JsonManagedReference // Este lado sí serializa
    private Pelicula pelicula;

    public ActorPelicula() {}

    public ActorPelicula(Director director, Pelicula pelicula) {
        this.director = director;
        this.pelicula = pelicula;
    }

    // Getters y setters

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

    @Override
    public int hashCode() {
        return Objects.hash(director, pelicula);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof ActorPelicula))
            return false;
        ActorPelicula other = (ActorPelicula) obj;
        return Objects.equals(director, other.director) && Objects.equals(pelicula, other.pelicula);
    }
}
