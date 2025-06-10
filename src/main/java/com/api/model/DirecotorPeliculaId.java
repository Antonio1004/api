package com.api.model;

import java.io.Serializable;

public class DirecotorPeliculaId  implements Serializable{
	
	private Long director;
	private Long pelicula;
	public Long getDirector() {
		return director;
	}
	public void setDirector(Long director) {
		this.director = director;
	}
	public Long getPelicula() {
		return pelicula;
	}
	public void setPelicula(Long pelicula) {
		this.pelicula = pelicula;
	}
	public DirecotorPeliculaId() {
		super();
	}
	

	

}
