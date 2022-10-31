package com.example.going.services.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.going.converters.PersonaConverter;
import com.example.going.entities.Avatar;
import com.example.going.entities.Locacion;
import com.example.going.entities.Persona;
import com.example.going.entities.Usuario;
import com.example.going.models.PersonaModelo;
import com.example.going.repositories.IAvatarRepository;
import com.example.going.repositories.IPersonaRepository;
import com.example.going.repositories.IUserRepository;
import com.example.going.services.IPersonaService;


@Service("personaService")
public class PersonaService implements IPersonaService {
	
	@Autowired
	@Qualifier("personaRepository")
	private IPersonaRepository personaRepository;
	
	@Autowired
	@Qualifier("personaConverter")
	private PersonaConverter personaConverter;
	
	@Autowired
	@Qualifier("userRepository")
	private IUserRepository usuarioRepository;
	
	
	@Autowired
	@Qualifier("avatarRepository")
	private IAvatarRepository avatarRepository;
	
	@Override
	public List<Persona> getAll(){	
			
			
		return personaRepository.findAll();	
	}
	
	
	public PersonaModelo traerPorId(int id) {
		
		
		return personaConverter.entityToModel(personaRepository.findById(id));
		
	};
	
	public Usuario traerUsuario(int id) {
		
		Persona p = personaRepository.findByIdAndFetchUsuarioEagerly(id);
		Usuario usuario = new Usuario();
		if (p!=null) {
			if(p.getUsuario()!=null) {
				usuario = p.getUsuario();
			}
		}
		
		return usuario;
		
	};
	
	
	public PersonaModelo traerPersonaCompletaPorId(int id) {
		
		List<Persona> listaEntidad = getPersonasCompletas();
		PersonaModelo personaEncontrada = new PersonaModelo();
		for (Persona p: listaEntidad) {
			
			if(p.getId() == id) {
				
				personaEncontrada = personaConverter.entityToModel(p);
				
			}
			
			
		}
		return personaEncontrada;
	}
	
	
	public List<Persona> getPersonasCompletas(){
		
		List<Persona> personas = getAll();
		
		for (Persona p: personas) {
			
			Avatar avatar = avatarRepository.findById(p.getAvatar().getId());
			Usuario usuario = usuarioRepository.findById(p.getUsuario().getId());
			
			Set<Locacion> locaciones = locacionesCargadas(p.getId());
			
			if(avatar != null) {
				p.setAvatar(avatar);
			}
			
			
			if(locaciones!=null) {
			p.setLocaciones(locaciones);
			}
			
			if(usuario!=null) {
			p.setUsuario(usuario);
			}

		}
		
		return personas;
	}
	
	public List<PersonaModelo> getAllModel(){
		
		List<PersonaModelo> listaDePersonas = new ArrayList<PersonaModelo>();
		
		for (Persona p:getAll() ) {
			
			listaDePersonas.add(personaConverter.entityToModel(p));
			
			
		}
	
		
		return listaDePersonas;
	}
	
	@Override
	public PersonaModelo insertOrUpdate(PersonaModelo personaModelo) {
		
	
		
		Persona persona = personaRepository.save(personaConverter.modelToEntity(personaModelo));
		
		return personaConverter.entityToModel(persona);
	}
	
	
//	@Override
//	public PersonaModelo insertOrUpdateSet(PersonaModelo personaModelo) {
//		
//	
//		
//		Persona persona = personaRepository.save(personaConverter.modelToEntitySet(personaModelo));
//		
//		return personaConverter.entityToModelSet(persona);
//	}
	
	
	public Set<Locacion> locacionesCargadas(int id) {
		
		Persona p = personaRepository.findByIdAndFetchLocacionesEagerly(id);
		System.out.println(p);
		Set<Locacion> lista = new HashSet<>();
		if (p!=null) {
			if(p.getLocaciones()!=null) {
				lista = p.getLocaciones();
			}
		}
		return lista;
	}
	

	
	
	
	
	@Override
	public boolean remove(int id) {
		
		try {
			personaRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}

	
	@Override
	public boolean remove(Long id) {
		
		try {
			personaRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}
	

}
