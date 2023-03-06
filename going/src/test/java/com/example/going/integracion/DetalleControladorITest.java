package com.example.going.integracion;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.example.going.controllers.detalleController;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DetalleControladorITest {
	
	@LocalServerPort
	private int port ;
	
	@Autowired
	private TestRestTemplate testTemplate;
	
	
	@Autowired
	private detalleController controlador;
	
	@Test
	void cargarEntorno() throws Exception{
		assertTrue(controlador!=null);
	}
	

}
