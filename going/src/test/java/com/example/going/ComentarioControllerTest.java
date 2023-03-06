package com.example.going;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.example.going.controllers.api.v0.ComentarioControllerRest;
import com.example.going.entities.Comentarios;
import com.example.going.entities.Locacion;
import com.example.going.services.IComentarioService;

public class ComentarioControllerTest {
	
	@Autowired
	@Qualifier("comentarioService")
	private IComentarioService comentarioService;
	
	@Autowired
	ComentarioControllerRest comentaConMock = Mockito.mock(ComentarioControllerRest.class);
	
	Locacion loc=new Locacion();
	
	@BeforeEach
	void setUp() {
			
		Comentarios comentarioMock = new Comentarios(1,"Lindo lugar",loc);
			ResponseEntity<Object> respuesta = ResponseEntity.status(HttpStatus.OK).body(comentarioMock);
			
		
			Mockito.when(comentaConMock.traerUnComentario(1)).thenReturn(respuesta);
			
		
		
			comentarioMock = null;
			respuesta = ResponseEntity.status(HttpStatus.NO_CONTENT).body(comentarioMock);
			
			
			Mockito.when(comentaConMock.traerUnComentario(100)).thenReturn(respuesta);
			
			
			List<Comentarios> listaMok = new ArrayList();
			listaMok.add(comentarioMock);
			ResponseEntity<Object> resp = ResponseEntity.status(HttpStatus.OK).body(listaMok);
			Mockito.when(comentaConMock.comentariosdb()).thenReturn(resp);
			
		
		}

	@Test
	void traerUnComentarioTest() {
		
		ResponseEntity<Object> respuesta;
	
		respuesta = comentaConMock.traerUnComentario(1);
		
		Assertions.assertEquals(1,  ((Comentarios) ((respuesta).getBody())).getId());

	}
	
	@Test
	void traerLocacionComentarioTest() {
		
		ResponseEntity<Object> respuesta;
	
		respuesta = comentaConMock.traerUnComentario(1);
		
		Assertions.assertEquals(loc,  ((Comentarios) ((respuesta).getBody())).getLocacion());

	}
	
	@Test
	void traerDescripcionComentarioTest() {
		
		ResponseEntity<Object> respuesta;
	
		respuesta = comentaConMock.traerUnComentario(1);
		
		Assertions.assertEquals("Lindo lugar",  ((Comentarios) ((respuesta).getBody())).getDescripcion());

	}

	@Test
	void traerUnComentarioInexistenteTest() {	
		ResponseEntity<Object> respuesta;

	respuesta = comentaConMock.traerUnComentario(100);
	
	Assertions.assertEquals(null,  ((Comentarios) (respuesta.getBody())));

	}
	
	@Test
	void traerTodosComentarios() {	
		ResponseEntity<Object> respuesta;
	
	respuesta = comentaConMock.comentariosdb();
	
	Assertions.assertEquals(200, respuesta.getStatusCodeValue());

	}
	


}
