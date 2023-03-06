package com.example.going.integracion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

//import org.junit.Test;

import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.example.going.controllers.AdminController;
import com.example.going.services.IPersonaService;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AdminControladorITest {
	
	@LocalServerPort
	private int port ;
	
	@Autowired
	private TestRestTemplate testTemplate;
	
	@Autowired
	private AdminController controlador;
	
	@Autowired
	//@Qualifier("personaService")
	private IPersonaService personaService;
	
	
	@Test
	void cargarEntorno() throws Exception{
		assertTrue(controlador!=null);
	}
	
	/*
	@Test
	void traerPersonas(Model model) {
		
		
		ModelAndView mAV = controlador.listaDePersonas(model);
		
	
	
		System.out.println("MODEL" +mAV.getModel());
		
		assertTrue(mAV!=null);
		
	}
	*/
	
	/*
	
	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		assertThat(this.testTemplate.getForObject("http://localhost:" + port + "/adminpage",
				String.class)).contains("Administrador");
	}
	*/

}
