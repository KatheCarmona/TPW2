package com.example.going.converters;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;


import com.example.going.entities.UsuarioRol;
import com.example.going.models.UsuarioRolModelo;


@Component("userRolconverter")
public class UserRolConverter {
	
	
	public UsuarioRolModelo entityToModel(UsuarioRol usuarioRol) {
		return new UsuarioRolModelo(usuarioRol.getId(), usuarioRol.getRol());
		
	}
	
	public UsuarioRol modelToEntity(UsuarioRolModelo userRolModel) {
		return new UsuarioRol(userRolModel.getId(), userRolModel.getRol());
	}
	

	
	public Set<UsuarioRolModelo> entidadAModeloSet(Set<UsuarioRol> usuarioRol){
		
		Set<UsuarioRolModelo>  lista = new HashSet<>();
		
		for(UsuarioRol u: usuarioRol) {
			
			lista.add(entityToModel(u));
			
			
		}
		
		
		return lista;
	}
	
	public Set<UsuarioRol> modeloAEntidadSet(Set<UsuarioRolModelo> usuarioRolModelo){
		
		Set<UsuarioRol>  lista = new HashSet<>();
		
		for(UsuarioRolModelo u: usuarioRolModelo) {
			
			lista.add(modelToEntity(u));
			
			
		}
		
		
		return lista;
	}

	
	
	
}