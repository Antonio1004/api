package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.model.Actor;

public interface ActorRepository  extends JpaRepository<Actor, Long>{

}
