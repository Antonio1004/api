package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.model.Actor;
import com.api.service.ActorService;

@RestController
@RequestMapping("/actores")
public class ActorController {
	
	@Autowired
	private ActorService directorService;
	
	@GetMapping
	public List<Actor> findAll() {
		return directorService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Actor result = directorService.findById(id);
		return result != null ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody Actor director) {
		Actor saved = directorService.saveDire(director);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@RequestBody Actor actor, @PathVariable Long id) {
		Actor existing = directorService.findById(id);
		if (existing != null) {
			actor.setId(id);
			return ResponseEntity.ok(directorService.saveDire(actor));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Actor existing = directorService.findById(id);
		if (existing != null) {
			directorService.deleteDire(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
