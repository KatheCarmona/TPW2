package com.example.going.models;




import java.util.HashSet;

import java.util.Set;

import com.example.going.entities.Comentarios;
import com.example.going.entities.Fotos;




public class LocacionModelo {

	
	
	private int id;
	

	
	private String nombre;
	
	private int valoracion;
	
	private String direccion;
	private String descripcion;
	private Set<Fotos> fotos = new HashSet<>();
	private Set<Comentarios> comentarios = new HashSet<>();
	
	
	public LocacionModelo(int id, String nombre, int valoracion, String direccion, String descripcion,
			Set<PersonaModelo> persona) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.valoracion = valoracion;
		this.direccion = direccion;
		this.descripcion = descripcion;
		this.persona = persona;
	}


	public Set<PersonaModelo> persona = new HashSet<>();


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getValoracion() {
		return valoracion;
	}


	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}


	public Set<PersonaModelo> getPersona() {
		return persona;
	}


	public void setPersona(Set<PersonaModelo> persona) {
		this.persona = persona;
	}

	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public LocacionModelo(int id, String nombre, int valoracion, Set<PersonaModelo> persona) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.valoracion = valoracion;
		this.persona = persona;
	}
	
	
	public LocacionModelo(int id, String nombre, int ranking) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.valoracion = ranking;
		this.persona= new HashSet<>();
	}
	
	
	public LocacionModelo() {
		super();
		
	
	}


	public LocacionModelo(int id, String nombre, int valoracion, String direccion, Set<PersonaModelo> persona) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.valoracion = valoracion;
		this.direccion = direccion;
		this.persona = persona;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Set<Fotos> getFotos() {
		return fotos;
	}


	public void setFotos(Set<Fotos> fotos) {
		this.fotos = fotos;
	}


	public Set<Comentarios> getComentarios() {
		return comentarios;
	}


	public void setComentarios(Set<Comentarios> comentarios) {
		this.comentarios = comentarios;
	}


	public LocacionModelo(int id, String nombre, int valoracion, String direccion, String descripcion,Set<Comentarios> comentarios,
			Set<Fotos> fotos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.valoracion = valoracion;
		this.direccion = direccion;
		this.descripcion = descripcion;
		this.fotos = fotos;
		this.comentarios = comentarios;
	}



	
	

	
	
	
	
	
}
