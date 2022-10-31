package com.example.going.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.going.entities.Persona;


@Repository("personaRepository")
public interface IPersonaRepository extends 
						JpaRepository<Persona, Serializable> {
	
	
	public abstract Persona findByNombre(String nombre);
	
	public abstract Persona findById(int id);
	
	
	
	
	@Query("SELECT p FROM Persona p JOIN FETCH p.locaciones WHERE p.id = (:id)")
	public abstract Persona findByIdAndFetchLocacionesEagerly(@Param("id") int id);
	
	@Query("SELECT p FROM Persona p JOIN FETCH p.usuario WHERE p.id = (:id)")
	public abstract Persona findByIdAndFetchUsuarioEagerly(@Param("id") int id);
	
	
	
	

}
