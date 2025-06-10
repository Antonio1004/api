package com.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.model.Director;
import com.api.repository.DirectorRepository;

@Service
public class DirectorService {
	
	@Autowired
	private DirectorRepository directorRepository;	
	
	public List<Director> findAll( ){
		return directorRepository.findAll();
	}
	
	
	public Director findById(Long id){
		return directorRepository.findById(id).orElse(null);
	}
	
	
	public Director saveDire(Director peli){
		return directorRepository.save(peli);
	}
	

	
	
	public void deleteDire(Long id){
		directorRepository.deleteById(id);
	}
}
