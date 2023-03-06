package com.example.going.integracion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.example.going.controllers.HomeControlador;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

class HomeControladorITest {

	@LocalServerPort
	private int port ;
	
	@Autowired
	private TestRestTemplate testTemplate;
	
	@Autowired
	private HomeControlador controlador;

	
	@Test
	void cargarEntorno() throws Exception{
		assertTrue(controlador!=null);
	}
	
	
	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		assertThat(this.testTemplate.getForObject("http://localhost:" + port + "",
				String.class)).contains("Home");
	}
	
	

	@Test
	void longinCheckTest() {
		
		
		String mAV = controlador.loginCheck();
		
		assertTrue(mAV!=null);
		
	}
	
	

}
