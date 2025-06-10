package com.api.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "Actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellido")
    private String apellido;

    @Column(name = "Edad")
    private int edad;

    @OneToMany(mappedBy = "actor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("actor")  // Ignora el atributo "actor" en ActorPelicula para evitar ciclo
    private List<ActorPelicula> peliculas;

    public Actor() {}

    public Actor(Long id, String nombre, String apellido, int edad, List<ActorPelicula> peliculas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.peliculas = peliculas;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<ActorPelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<ActorPelicula> peliculas) {
        this.peliculas = peliculas;
    }

    @Override
    public int hashCode() {
        return Objects.hash(apellido, edad, id, nombre, peliculas);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Actor other = (Actor) obj;
        return Objects.equals(apellido, other.apellido) && edad == other.edad && Objects.equals(id, other.id)
                && Objects.equals(nombre, other.nombre) && Objects.equals(peliculas, other.peliculas);
    }
}
