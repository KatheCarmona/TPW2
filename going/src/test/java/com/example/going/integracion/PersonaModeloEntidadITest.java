package com.example.going.integracion;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.going.entities.Avatar;
import com.example.going.entities.Locacion;
import com.example.going.entities.Persona;
import com.example.going.entities.Usuario;
import com.example.going.entities.UsuarioRol;
import com.example.going.models.AvatarModelo;
import com.example.going.models.LocacionModelo;
import com.example.going.models.PersonaModelo;

class PersonaModeloEntidadITest {

	@Autowired
	PersonaModelo p = new PersonaModelo();
	
	@Autowired
	Persona pe = new Persona();
	
	@Test
	void crearPersonaModelo() {
		this.p= new PersonaModelo("Nombre",12,"email");
		assertTrue(p!=null);
	}
	
	@Test
	void crearPersonaModelo2() {
		this.p= new PersonaModelo(1,"Nombre",12,"email");
		assertTrue(p!=null);
	}
	
	@Test
	void crearPersonaModelo3() {
		AvatarModelo av = new AvatarModelo();
		this.p= new PersonaModelo(1,"Nombre",12,"email",av);
		assertTrue(p!=null);
	}
	
	@Test
	void crearPersonaModelo4() {
		AvatarModelo av = new AvatarModelo();
		Set<LocacionModelo> loc = new HashSet<LocacionModelo>();
		this.p= new PersonaModelo(1,"Nombre",12,"email",loc,av);
		assertTrue(p!=null);
	}
	
	@Test
	void crearPersonaEntidad() {
		this.pe= new Persona(1,"Nombre",12,"email");
		assertTrue(pe!=null);
	}
	
	@Test
	void crearPersonaEntidad2() {
		Avatar av = new Avatar();
		this.pe= new Persona(1,"Nombre",12,"email","hola",av);
		assertTrue(pe!=null);
	}
	
	@Test
	void crearPersonaEntidad3() {
		Avatar av = new Avatar();
		Set<Locacion> loc = new HashSet<Locacion>();
		this.pe= new Persona(1,"Nombre",12,"email",loc,av);
		assertTrue(pe!=null);
	}
	
	@Test
	void crearPersonaEntidad4() {
		Avatar av = new Avatar();
		Set<Locacion> loc = new HashSet<Locacion>();
		this.pe= new Persona(1,"Nombre",12,"email",av,loc);
		assertTrue(pe!=null);
	}
	@Test
	void crearPersonaEntidad5() {
		Avatar av = new Avatar();
		Usuario u = new Usuario();
		this.pe= new Persona(1,"Nombre",12,"email",u,av);
		assertTrue(pe!=null);
	}
	
	@Test
	void validarDatos() {
		assertEquals(this.p.getId(),this.pe.getId());
		assertEquals(this.p.getNombre(),this.pe.getNombre());
		assertEquals(this.p.getEmail(),this.pe.getEmail());
	}
	

}
