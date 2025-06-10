package com.api.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "Pelicula_Actor")
@IdClass(AcotrPeliculaId.class)
public class ActorPelicula implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_actor")
    @JsonIgnoreProperties("peliculas")  // Ignora la lista 'peliculas' en Actor para evitar ciclo
    private Actor actor;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_pelicula")
    @JsonIgnoreProperties("actores")  // Ignora la lista 'actores' en Pelicula para evitar ciclo
    private Pelicula pelicula;

    public ActorPelicula() {}

    public ActorPelicula(Actor actor, Pelicula pelicula) {
        this.actor = actor;
        this.pelicula = pelicula;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    @Override
    public int hashCode() {
        return Objects.hash(actor, pelicula);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ActorPelicula other = (ActorPelicula) obj;
        return Objects.equals(actor, other.actor) && Objects.equals(pelicula, other.pelicula);
    }
}
