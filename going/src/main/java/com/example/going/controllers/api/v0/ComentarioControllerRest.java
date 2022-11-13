package com.example.going.controllers.api.v0;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.going.entities.Comentarios;
import com.example.going.models.ComentarioModelo;
import com.example.going.models.request.ComentarioRequest;
import com.example.going.services.IComentarioService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/v0/comentario")
public class ComentarioControllerRest {
	
	@Autowired
	@Qualifier("comentarioService")
	private IComentarioService comentarioService;
	
	
	@Operation(summary="Todos los comentarios", description="Muestra todos los comentarios de la db")
	@GetMapping("/comentarios")
	public ResponseEntity<Object>comentariosdb(){
		
		List<Comentarios> listaPersonas = comentarioService.getAll();
		
		Object body = "Lista vacia";
				
		if(listaPersonas != null) {
			body = listaPersonas;
			
			return ResponseEntity.status(HttpStatus.OK).body(body);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
		}
		
		
		
	}
	
	@Operation(summary="Agregar Comentario", description="Agrega un comentario en una locación")
	@PostMapping("/agregarComentario")
	public ResponseEntity<Object> agregarComentario(@RequestBody ComentarioRequest comentarioR){
		Object body = "";
		int locacion;
		HttpStatus status = HttpStatus.CONFLICT;
		ComentarioModelo comentario = new ComentarioModelo();
		
		comentario.setDescripcion(comentarioR.getDescripcion());
		locacion = comentarioR.getIdLocacion();
		
		try {
			ComentarioModelo nuevoC = comentarioService.insertOrUpdate(comentario, locacion);
			body = nuevoC;
			status = HttpStatus.CREATED;
		}catch(Exception e) {
			body = "Error... " + e.getMessage();
		}
		
		return ResponseEntity.status(status).body(body);
		
	}
	
	@Operation(summary="Edita un comentario", description = "Edita un comentario de una locacion")
	@PutMapping("/editarComentario/{id}")
	public ResponseEntity<Object> editar(@PathVariable int id, @RequestBody ComentarioRequest comentarioR){
		
		int locacion;
		Object body = "";
		HttpStatus status = HttpStatus.CONFLICT;
		ComentarioModelo cm = comentarioService.traerPorId(id);
		
		cm.setDescripcion(comentarioR.getDescripcion());
		locacion = comentarioR.getIdLocacion();
		
		try {
			ComentarioModelo nuevoC = comentarioService.insertOrUpdate(cm, locacion);
			body = nuevoC;
			status = HttpStatus.CREATED;
		}catch(Exception e) {
			body = "Error... " + e.getMessage();
		}
		
		return ResponseEntity.status(status).body(body);
		
		
	}
	
	@Operation(summary="Trae comentario por Id", description = "Trae un comentario de alguna locacion")
	@GetMapping("/unComentario/{id}")
	public ResponseEntity<Object> traerUnComentario(@PathVariable("id") int id) {
		
		ComentarioModelo cm = comentarioService.traerPorId(id);
		Object body = "";
		
		
		 if (cm == null) {
		    	body ="No se encontró ningun comentario";
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
		    }

		    return ResponseEntity.status(HttpStatus.OK).body(cm);

	}
	
	@Operation(summary="Eliminar un comentario", description = "Elimina un comentario de alguna locacion")
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> eliminarComentario(@PathVariable("id") int id) {
		
		 boolean isRemoved = comentarioService.remove(id);
		 
		 if (!isRemoved) {
		    	Object body ="No se elimino";
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
		    }

		    return ResponseEntity.status(HttpStatus.OK).body("Eliminado id: " +id);
		 
		
	}
	

}
