package com.api.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "Pelicula")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Titulo")
    private String titulo;

    @Column(name = "Categoria")
    private String categoria;

    @Column(name = "Presupuesto")
    private Double presupuesto;

    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference // No serializa esta relación para evitar ciclo
    private List<ActorPelicula> directores;

    public Pelicula() {}

    public Pelicula(Long id, String titulo, String categoria, Double presupuesto, List<ActorPelicula> directores) {
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.presupuesto = presupuesto;
        this.directores = directores;
    }

    // Getters y setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public List<ActorPelicula> getDirectores() {
        return directores;
    }

    public void setDirectores(List<ActorPelicula> directores) {
        this.directores = directores;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Pelicula))
            return false;
        Pelicula other = (Pelicula) obj;
        return Objects.equals(id, other.id);
    }
}
