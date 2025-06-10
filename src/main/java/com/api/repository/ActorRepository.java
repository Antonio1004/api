package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.model.Director;

public interface ActorRepository  extends JpaRepository<Director, Long>{

}
