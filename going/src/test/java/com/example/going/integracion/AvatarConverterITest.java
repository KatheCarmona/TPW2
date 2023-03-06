package com.example.going.integracion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.going.controllers.HomeControlador;
import com.example.going.converters.AvatarConverter;
import com.example.going.entities.Avatar;
import com.example.going.entities.Persona;
import com.example.going.models.AvatarModelo;

public class AvatarConverterITest{
	
	@Autowired
	private AvatarConverter convert = new AvatarConverter() ;
	
	
	@Test
	void entityToModelTest() throws Exception{
	
		Avatar avatar= new Avatar(1,"img");
		
		AvatarModelo avMo = convert.entityToModel(avatar);
		assertEquals(avatar.getImagen(), avMo.getImagen());
	}
	
	@Test
	void modelToEntityTest() throws Exception{
	
		AvatarModelo avatar= new AvatarModelo(1,"img");
		
		Avatar avMo = convert.modelToEntity(avatar);
		assertEquals(avatar.getImagen(), avMo.getImagen());
	
	}

}
