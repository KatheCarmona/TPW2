package com.example.going.entities;




import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.EqualsAndHashCode;




@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="locacion")
public class Locacion {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private int valoracion;
	private String direccion;

	 @ManyToMany(mappedBy = "locaciones")
	 @JsonIgnoreProperties("locaciones")
	    public Set<Persona> persona = new HashSet<>();
	 
	@OneToMany(mappedBy = "locacion", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Comentarios> comentarios = new HashSet<>();;
	
	
	public Set<Comentarios> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<Comentarios> comentarios) {
		this.comentarios = comentarios;
	}

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
	
	public Set<Persona> getPersona() {
		return persona;
	}

	public void setPersona(Set<Persona> persona) {
		this.persona = persona;
	}

	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
	public Locacion() {
		super();
	
	}

	public Locacion(int id, String nombre, int valoracion, Set<Persona> persona) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.valoracion = valoracion;
		this.persona = persona;
	}
	
	public Locacion(int id, String nombre, int valoracion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.valoracion = valoracion;
		this.persona =  new HashSet<>();
	}



	public Locacion(int id, String nombre, int valoracion, String direccion, Set<Persona> persona) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.valoracion = valoracion;
		this.direccion = direccion;
		this.persona = persona;
	}
	

	public Locacion(int id, String nombre, int valoracion, String direccion, Set<Persona> persona,
			Set<Comentarios> comentarios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.valoracion = valoracion;
		this.direccion = direccion;
		this.persona = persona;
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", nombre=" + nombre + ", valoracion=" + valoracion + "]";
	}
	

	
	
	
}
