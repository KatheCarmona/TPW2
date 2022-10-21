package com.example.going.converters;


import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.example.going.entities.Locacion;
import com.example.going.models.LocacionModelo;


@Component("paisConverter")
public class LocacionConverter {
	
	
	
	public LocacionModelo entityToModel(Locacion locacion) {
		
		
	
		return new LocacionModelo(locacion.getId(), locacion.getNombre(), locacion.getValoracion());
		
		
	}
	
	
	public Set<LocacionModelo> entidadAModeloSet(Set<Locacion> paises){
		
		Set<LocacionModelo>  lista = new HashSet<>();
		
		for(Locacion p: paises) {
			
			lista.add(entityToModel(p));
			
			
		}
		
		
		return lista;
	}
	
	
	public Set<Locacion> modeloAEntidadSet(Set<LocacionModelo> paises){
		
		Set<Locacion>  lista = new HashSet<>();
		
		for(LocacionModelo p: paises) {
			
			lista.add(modelToEntity(p));
			
			
		}
		
		
		return lista;
	}
	
	
	
	
	public Locacion modelToEntity(LocacionModelo locacionModelo) {
		
	
		return new Locacion(locacionModelo.getId(), locacionModelo.getNombre(), locacionModelo.getValoracion());
		
		
	}

}
