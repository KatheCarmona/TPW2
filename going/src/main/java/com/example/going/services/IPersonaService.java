package com.example.going.services;

import java.util.List;
import java.util.Set;


import com.example.going.entities.Locacion;
import com.example.going.entities.Persona;
import com.example.going.entities.Usuario;
import com.example.going.models.PersonaModelo;
public interface IPersonaService {
	
	
	public List<Persona> getAll();
	
	public PersonaModelo insertOrUpdate(PersonaModelo personaModelo);
	
	//public PersonaModelo insertOrUpdateSet(PersonaModelo personaModelo);
	
	public boolean remove(int id);
	
	public boolean remove(Long id);
	
	public PersonaModelo traerPorId(int id);
	
	public List<PersonaModelo> getAllModel();
	
	public Set<Locacion> locacionesCargadas(int id);

	public List<Persona> getPersonasCompletas();

	public Usuario traerUsuario(int id);

	public PersonaModelo traerPersonaCompletaPorId(int id);
}


