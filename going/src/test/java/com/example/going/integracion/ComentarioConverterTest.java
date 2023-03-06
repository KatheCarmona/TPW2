package com.example.going.integracion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.going.converters.ComentarioConverter;
import com.example.going.converters.LocacionConverter;
import com.example.going.entities.Comentarios;
import com.example.going.entities.Locacion;
import com.example.going.models.ComentarioModelo;
import com.example.going.models.LocacionModelo;

class ComentarioConverterTest {
	@Autowired
	private LocacionConverter convertLoc = new LocacionConverter() ;
	
	@Autowired
	private ComentarioConverter comentConvert = new ComentarioConverter() ;

	@Test
	void entityToModelTest() throws Exception{
		Locacion locacion = new Locacion();
		Comentarios c = new Comentarios();
		
		LocacionModelo loc = convertLoc.entityToModel(locacion);
		c.setLocacion(locacion);
		ComentarioModelo co = comentConvert.entityToModel(c);
		
		assertEquals(locacion.getId(), loc.getId());
		assertEquals(c.getId(), co.getId());
	}
	
	@Test
	void modelToEntityTest() throws Exception{
		LocacionModelo locacion = new LocacionModelo();
		ComentarioModelo c = new ComentarioModelo();
		
		Locacion loc = convertLoc.modelToEntity(locacion);
		c.setLocacion(loc);;
		Comentarios co = comentConvert.modelToEntity(c);
		
		assertEquals(locacion.getId(), loc.getId());
		assertEquals(c.getId(), co.getId());
	}

}
