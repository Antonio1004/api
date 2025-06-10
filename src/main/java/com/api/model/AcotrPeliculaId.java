package com.api.model;

import java.io.Serializable;

public class AcotrPeliculaId  implements Serializable{
	
	private Long actor;
	private Long pelicula;
	public Long getActor() {
		return actor;
	}
	public void setActor(Long actor) {
		this.actor = actor;
	}
	public Long getPelicula() {
		return pelicula;
	}
	public void setPelicula(Long pelicula) {
		this.pelicula = pelicula;
	}
	public AcotrPeliculaId() {
		super();
	}

	

	

}
