package com.example.going;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

import com.example.going.controllers.ExploradorController;
import com.example.going.entities.Locacion;
import com.example.going.helpers.ViewRouteHelper;
import com.example.going.models.LocacionModelo;

public class ExploradorControlerTest {
	
	@Autowired
	ExploradorController exConMock = Mockito.mock(ExploradorController.class);
	
	
	@BeforeEach
	void setUp() {
		
		//Locacion locMock = new Locacion(1, "LocPrueba", "calle 123","Una locacion de prueba");
		//ResponseEntity<Object> respuesta = ResponseEntity.status(HttpStatus.OK).body(locMock);
		
		ModelAndView mV = new ModelAndView(ViewRouteHelper.EXPLO);
		Mockito.when(exConMock.explorador()).thenReturn(mV);
		
		
		
	}
	
	@Test
	void explorador() {
	
		ModelAndView respuesta = new ModelAndView(ViewRouteHelper.EXPLO);
	
		respuesta = exConMock.explorador();
		
		Assertions.assertEquals(ViewRouteHelper.EXPLO, respuesta.getViewName());

	}
	
	@Test
	void exploradorIncorrecto() {
	
		ModelAndView respuesta = new ModelAndView(ViewRouteHelper.ADMINPAGE);
	
		respuesta = exConMock.explorador();
		
		Assertions.assertNotEquals(ViewRouteHelper.ADMINPAGE, respuesta.getViewName());

	}

}
