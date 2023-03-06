package com.example.going.integracion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.going.entities.UsuarioRol;
import com.example.going.models.UsuarioRolModelo;

class UsuarioRolModeloEntidadITest {
	
	@Autowired
	UsuarioRolModelo rolM = new UsuarioRolModelo();
	
	@Autowired
	UsuarioRol rol = new UsuarioRol();

	@Test
	void crearRolModelo() {
		assertTrue(rolM!=null);
	}
	
	@Test
	void crearRolentidad() {
		assertTrue(rol!=null);
	}
	
	@Test
	void validarDatos() {
		assertEquals(this.rolM.getId(),this.rol.getId());
		
	}
	
	
	

}
