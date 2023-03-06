package com.example.going.integracion;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.going.entities.Persona;
import com.example.going.entities.Usuario;
import com.example.going.entities.UsuarioRol;
import com.example.going.models.PersonaModelo;
import com.example.going.models.UsuarioModelo;
import com.example.going.models.UsuarioRolModelo;

class UsuarioModeloEntidadITest {
	
	@Autowired
	UsuarioModelo um = new UsuarioModelo();
	
	
	
	@Autowired
	Usuario u = new Usuario();
	
	@Autowired
	Set<UsuarioRolModelo> usuarioRols = new HashSet<UsuarioRolModelo>();
	
	Set<UsuarioRol> usuarioRol = new HashSet<UsuarioRol>();

	@Test
	void crearUsuarioModelo() {
		um = new UsuarioModelo(1, "nombre","123456",true, this.usuarioRols);
		assertTrue(um!=null);
	}
	
	
	@Test
	void crearUsuarioEntidad() {
		u = new Usuario(1, "nombre","123456",true, this.usuarioRol);
		assertTrue(um!=null);
	}
	
	@Test
	void validarDatos() {
		assertEquals(this.u.getId(),this.um.getId());
		assertEquals(this.u.getUsername(),this.um.getUsername());
		
	}
	
	
}
