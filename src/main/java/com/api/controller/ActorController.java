package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.model.Director;
import com.api.service.ActorService;

@RestController
@RequestMapping("/directors")
public class ActorController {
	
	@Autowired
	private ActorService directorService;
	
	@GetMapping
	public List<Director> findAll() {
		return directorService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Director result = directorService.findById(id);
		return result != null ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody Director director) {
		Director saved = directorService.saveDire(director);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@RequestBody Director director, @PathVariable Long id) {
		Director existing = directorService.findById(id);
		if (existing != null) {
			director.setId(id);
			return ResponseEntity.ok(directorService.saveDire(director));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Director existing = directorService.findById(id);
		if (existing != null) {
			directorService.deleteDire(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
