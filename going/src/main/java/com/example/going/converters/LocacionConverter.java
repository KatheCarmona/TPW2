package com.example.going.converters;


import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.example.going.entities.Locacion;
import com.example.going.models.LocacionModelo;


@Component("locacionConverter")
public class LocacionConverter {
	
	
	
	public LocacionModelo entityToModel(Locacion locacion) {
		
		
	
		return new LocacionModelo(locacion.getId(), locacion.getNombre(), locacion.getValoracion(),locacion.getDireccion(),
				locacion.getDescripcion(),locacion.getComentarios(),locacion.getFotos());
		
		
	}
	
	
	public Set<LocacionModelo> entidadAModeloSet(Set<Locacion> lugar){
		
		Set<LocacionModelo>  lista = new HashSet<>();
		
		for(Locacion p: lugar) {
			
			lista.add(entityToModel(p));
			
			
		}
		
		
		return lista;
	}
	
	
	public Set<Locacion> modeloAEntidadSet(Set<LocacionModelo> lugar){
		
		Set<Locacion>  lista = new HashSet<>();
		
		for(LocacionModelo p: lugar) {
			
			lista.add(modelToEntity(p));
			
			
		}
		
		
		return lista;
	}
	
	
	
	
	public Locacion modelToEntity(LocacionModelo locacionModelo) {
		
	
		return new Locacion(locacionModelo.getId(), locacionModelo.getNombre(), locacionModelo.getValoracion(),locacionModelo.getDireccion(),
				locacionModelo.getDescripcion(), locacionModelo.getComentarios(),locacionModelo.getFotos());
		
		
	}

}
