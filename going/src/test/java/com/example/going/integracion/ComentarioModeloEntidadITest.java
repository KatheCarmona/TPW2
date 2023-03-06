package com.example.going.integracion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.going.entities.Comentarios;
import com.example.going.entities.Locacion;
import com.example.going.entities.Persona;
import com.example.going.models.ComentarioModelo;
import com.example.going.models.LocacionModelo;
import com.example.going.models.PersonaModelo;

class ComentarioModeloEntidadITest {
	
 	@Autowired
 	ComentarioModelo c = new ComentarioModelo();

	@Autowired
	Comentarios co = new Comentarios();
	
	@Autowired
	Locacion loc = new Locacion();
	
	@Autowired
	LocacionModelo locM = new LocacionModelo();
	
	@Test
	void crearComentarioModelo() {
		c = new ComentarioModelo(1, "Hola",this.loc);
		assertTrue(c!=null);
	}
	
	@Test
	void crearComentarioEntidad() {
		co = new Comentarios(1, "Hola",this.loc);
		assertTrue(co!=null);
	}
	
	
	@Test
	void crearComentarioEntidad2() {
		co = new Comentarios(1, "Hola");
		assertTrue(co!=null);
	}
	
	@Test
	void crearComentarioEntidad3() {
		co = new Comentarios("Hola");
		assertTrue(co!=null);
	}
	
	@Test
	void crearComentarioEntidad4() {
		co = new Comentarios("Hola",this.loc);
		assertTrue(co!=null);
	}
	
	@Test
	void validarDatos() {
		assertEquals(this.c.getId(),this.co.getId());
		assertEquals(this.c.getDescripcion(),this.co.getDescripcion());
		assertEquals(this.c.getLocacion(),this.co.getLocacion());
	}
	
	


}
