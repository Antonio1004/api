package com.api.model;


import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "Director")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Director other = (Director) obj;
		return Objects.equals(id, other.id);
	}

	@Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellido")
    private String apellido;

    @Column(name = "Edad")
    private int edad;
    
    @OneToMany(mappedBy = "director" )
    private List<DirectorPelicula> peliculas;
    // Constructor vacío
    
    // Getters y Setters
    public Long getId() {
        return id;
    }

    public Director() {
		super();
	}

	public Director(Long id, String nombre, String apellido, int edad, List<DirectorPelicula> peliculas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.peliculas = peliculas;
	}

	public List<DirectorPelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<DirectorPelicula> peliculas) {
		this.peliculas = peliculas;
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
}
