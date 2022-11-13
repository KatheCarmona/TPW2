package com.example.going.services;

import java.util.List;


import com.example.going.entities.Comentarios;
import com.example.going.models.ComentarioModelo;


public interface IComentarioService {
	public List<Comentarios> getAll();
	
	public boolean remove(int id);
	
	public ComentarioModelo insertOrUpdate (ComentarioModelo comentarioModel,int idLocacion);
	
	public ComentarioModelo traerPorId(int id);

}
