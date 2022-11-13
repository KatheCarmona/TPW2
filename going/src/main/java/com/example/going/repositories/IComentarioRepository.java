package com.example.going.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.going.entities.Comentarios;
import com.example.going.entities.Persona;



@Repository("comentarioRepository")
public interface IComentarioRepository extends JpaRepository<Comentarios, Serializable> {
	
	public abstract Comentarios findById(int id);
	
	@Query("SELECT p FROM Comentarios p JOIN FETCH p.locacion WHERE p.id = (:id)")
	public abstract Comentarios findByIdAndFetchComentariosLocacionesEagerly(@Param("id") int id);

}
