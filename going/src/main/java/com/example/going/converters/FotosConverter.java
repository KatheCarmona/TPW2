package com.example.going.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.going.entities.Fotos;
import com.example.going.models.FotosModelo;

@Component("fotosConverter")
public class FotosConverter {
	
	
	public FotosModelo entityToModel(Fotos fotos) {
		return new FotosModelo(fotos.getId(),fotos.getImagen());
	}
	
	
	public Fotos ModelToEntity (FotosModelo fotosModelo) {
		return new Fotos(fotosModelo.getId(), fotosModelo.getImagen());
	}
	

	
	

}
