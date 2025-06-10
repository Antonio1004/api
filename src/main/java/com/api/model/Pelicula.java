package com.api.model;

import java.util.List;

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

    @OneToMany(mappedBy = "pelicula" )
    private List<DirectorPelicula> directores;
    
    
    public Pelicula() {
		super();
	}

	public Pelicula(Long id, String titulo, String categoria, Double presupuesto, List<DirectorPelicula> directores) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.categoria = categoria;
		this.presupuesto = presupuesto;
		this.directores = directores;
	}

	public List<DirectorPelicula> getDirectores() {
		return directores;
	}

	public void setDirectores(List<DirectorPelicula> directores) {
		this.directores = directores;
	}

	// Getters y Setters
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
}
