package com.example.going.converters;

import org.springframework.stereotype.Component;

import com.example.going.entities.Comentarios;
import com.example.going.models.ComentarioModelo;


@Component("comentarioConverter")
public class ComentarioConverter {
	

	
	public ComentarioModelo entityToModel(Comentarios coment) {
	
	return new ComentarioModelo(coment.getId(),coment.getDescripcion(),coment.getLocacion());
	
}
	
	public Comentarios modelToEntity(ComentarioModelo comentModel) {
	
	return new Comentarios(comentModel.getId(),comentModel.getDescripcion(),comentModel.getLocacion());
	
	
}


}
