package com.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.model.Actor;
import com.api.repository.ActorRepository;

@Service
public class ActorService {
	
	@Autowired
	private ActorRepository directorRepository;	
	
	public List<Actor> findAll( ){
		return directorRepository.findAll();
	}
	
	
	public Actor findById(Long id){
		return directorRepository.findById(id).orElse(null);
	}
	
	
	public Actor saveDire(Actor peli){
		return directorRepository.save(peli);
	}
	

	
	
	public void deleteDire(Long id){
		directorRepository.deleteById(id);
	}
}
