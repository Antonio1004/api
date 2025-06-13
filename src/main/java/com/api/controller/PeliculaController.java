package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Pelicula;
import com.api.service.PeliculaService;


@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

	@Autowired
	private PeliculaService peliculaService;
	
	@GetMapping
	public List<Pelicula> findAll() {
		return peliculaService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Pelicula result = peliculaService.findById(id);
		return result != null ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody Pelicula pelicula) {
		Pelicula saved = peliculaService.savePeli(pelicula);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@RequestBody Pelicula pelicula, @PathVariable Long id) {
		Pelicula existing = peliculaService.findById(id);
		if (existing != null) {
			pelicula.setId(id);
			return ResponseEntity.ok(peliculaService.savePeli(pelicula));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Pelicula existing = peliculaService.findById(id);
		if (existing != null) {
			peliculaService.deletePeli(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
