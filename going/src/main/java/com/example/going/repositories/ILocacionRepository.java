package com.example.going.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.going.entities.Locacion;


@Repository("locacionRepository")
public interface ILocacionRepository extends 
						JpaRepository<Locacion, Serializable> {
	

	public abstract Locacion findByNombre(String nombre);
	
	public abstract Locacion findById(int id);
	

	@Query("SELECT p FROM Locacion p JOIN FETCH p.locacion WHERE p.id = (:id)")
	public abstract Locacion findByIdAndFetchLocacionEagerly(@Param("id") int id);
	

	

}
