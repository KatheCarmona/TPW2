package com.example.going.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.going.entities.Persona;
import com.example.going.models.PersonaModelo;

@Component("personaConverter")
public class PersonaConverter {
	
	
	@Autowired
	@Qualifier("avatarConverter")
	private AvatarConverter avatarConverter;
	
	@Autowired
	@Qualifier("locacionConverter")
	private LocacionConverter locacionConverter;
	
	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;
	
//	public PersonaModelo entityToModelSet(Persona persona) {
//		
//		
//	
//		return new PersonaModelo(persona.getId(), persona.getNombre(), persona.getEdad(), persona.getEmail(), 
//				avatarConverter.entityToModel(persona.getAvatar()), locacionConverter.entidadAModeloSet(persona.getLocaciones()));
//		
//		
//	}
//	
//	
//	
//	public Persona modelToEntitySet(PersonaModelo personaModelo) {
//		
//	
//		return new Persona(personaModelo.getId(), personaModelo.getNombre(), personaModelo.getEdad(),
//				personaModelo.getEmail(), avatarConverter.modelToEntity(personaModelo.getAvatar()), 
//				locacionConverter.modeloAEntidadSet(personaModelo.getLocaciones()));
//		
//		
//	}
//	
	
	
	
	public PersonaModelo entityToModel(Persona persona) {
		
		
		
		return new PersonaModelo(persona.getId(),persona.getNombre(), persona.getEdad(), persona.getEmail(), 
				usuarioConverter.entityToModel(persona.getUsuario()),avatarConverter.entityToModel(persona.getAvatar()));
		
		
	}
	
	
	
	public Persona modelToEntity(PersonaModelo personaModelo) {
		
	personaModelo.toString();
		return new Persona(personaModelo.getId(),personaModelo.getNombre(),personaModelo.getEdad(),personaModelo.getEmail(),
				usuarioConverter.modelToEntity(personaModelo.getUsuario()),avatarConverter.modelToEntity(personaModelo.getAvatar()));
		
		
	}
	
	
	

}
