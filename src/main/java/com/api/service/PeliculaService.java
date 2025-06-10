package com.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.model.Pelicula;
import com.api.repository.PeliculaRepository;

@Service
public class PeliculaService {
	@Autowired
	private PeliculaRepository peliculaRepository;	
	public List<Pelicula> findAll( ){
		return peliculaRepository.findAll();
	}
	
	
	public Pelicula findById(Long id){
		return peliculaRepository.findById(id).orElse(null);
	}
	
	
	public Pelicula savePeli(Pelicula peli){
		return peliculaRepository.save(peli);
	}
	

	
	
	public void deletePeli(Long id){
		peliculaRepository.deleteById(id);
	}
}
