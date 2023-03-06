package com.example.going.integracion;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.going.entities.Fotos;
import com.example.going.models.LocacionModelo;

class LocacionModeloITest {

	@Autowired
	LocacionModelo locModelo = new LocacionModelo();
	
	@Test
	void testNombre() {
		locModelo.setNombre("Locacion Prueba");
		
		assertEquals("Locacion Prueba", locModelo.getNombre());
		assertNotEquals("Locacion", locModelo.getNombre());
		
	}
	
	@Test
	void testSetFotos() {
		Fotos fto = new Fotos();
		Set<Fotos> fotos = new HashSet<>();
		fotos.add(fto);
		locModelo.setFotos(fotos);
		
		assertTrue(locModelo.getFotos()!=null);
		assertEquals(fotos, locModelo.getFotos());
		
		
	}

}
