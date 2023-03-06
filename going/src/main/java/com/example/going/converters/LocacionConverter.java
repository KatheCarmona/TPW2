package com.example.going.converters;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.going.entities.Locacion;
import com.example.going.models.LocacionModelo;


@Component("locacionConverter")
public class LocacionConverter {
	
	@Autowired
	@Qualifier("fotosConverter")
	private FotosConverter fotoConverter;
	
	public LocacionModelo entityToModel(Locacion locacion) {
		
		
	
		return new LocacionModelo(locacion.getId(), locacion.getNombre(), locacion.getValoracion(),locacion.getDireccion(),
				locacion.getDescripcion(),locacion.getComentarios(),locacion.getFotos());
		
		
	}
	
	
	
	public Locacion modelToEntity(LocacionModelo locacionModelo) {
		
	
		return new Locacion(locacionModelo.getId(), locacionModelo.getNombre(), locacionModelo.getValoracion(),locacionModelo.getDireccion(),
				locacionModelo.getDescripcion(), locacionModelo.getComentarios(),locacionModelo.getFotos());
		
		
	}

}
