package com.example.going.integracion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.going.converters.FotosConverter;
import com.example.going.converters.LocacionConverter;
import com.example.going.entities.Fotos;
import com.example.going.entities.Locacion;
import com.example.going.models.FotosModelo;
import com.example.going.models.LocacionModelo;

class LocacionConverterITest {
	
	@Autowired
	private LocacionConverter convert = new LocacionConverter() ;
	
	@Test
	void entityToModelTest() throws Exception{
		Locacion locacion = new Locacion();
		LocacionModelo loc = convert.entityToModel(locacion);
		assertEquals(locacion.getId(), loc.getId());
	}
	
	@Test
	void modelToEntityTest() throws Exception{
		LocacionModelo locacion = new LocacionModelo();
		Locacion loc = convert.modelToEntity(locacion);
		assertEquals(locacion.getId(), loc.getId());
	}

}
