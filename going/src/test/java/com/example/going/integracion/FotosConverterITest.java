package com.example.going.integracion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.going.converters.AvatarConverter;
import com.example.going.converters.FotosConverter;
import com.example.going.entities.Avatar;
import com.example.going.entities.Fotos;
import com.example.going.models.AvatarModelo;
import com.example.going.models.FotosModelo;

class FotosConverterITest {
	
	@Autowired
	private FotosConverter convert = new FotosConverter() ;

	@Test
	void entityToModelTest() throws Exception{
		Fotos foto = new Fotos(1,"img");
		FotosModelo fto = convert.entityToModel(foto);
		assertEquals(foto.getImagen(), fto.getImagen());
	}
	
	
	@Test
	void modelToEntityTest() throws Exception{
		FotosModelo foto = new FotosModelo(1,"img");
		Fotos fto = convert.ModelToEntity(foto);
		assertEquals(foto.getImagen(), fto.getImagen());
	}
	
	
	


}
