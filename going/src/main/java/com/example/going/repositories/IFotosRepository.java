package com.example.going.repositories;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.example.going.entities.Fotos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


@Repository("fotosRepository")
public interface IFotosRepository  extends JpaRepository<Fotos, Serializable>{
	
	public abstract Fotos findById(int id);
	
	@Query("SELECT p FROM Fotos p JOIN FETCH p.locacion WHERE p.id = (:id)")
	public abstract Fotos findByIdAndFetchFotosLocacionEagerly(@Param("id") int id);
	
	/*
	@Modifying
	@Query("UPDATE Fotos u SET u.locacion_id = (:idLoc) WHERE u.locacion_id = ?0")
	public abstract void updateFotoLoc(@Param("idLoc") int idLoc);
	*/
}
