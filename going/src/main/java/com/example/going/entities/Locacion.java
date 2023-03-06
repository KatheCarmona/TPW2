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
	private String descripcion;

	 @ManyToMany(mappedBy = "locaciones")
	 @JsonIgnoreProperties("locaciones")
	    public Set<Persona> persona = new HashSet<>();
	 
	@OneToMany(mappedBy = "locacion", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Comentarios> comentarios = new HashSet<>();;
	
	@OneToMany(mappedBy = "locacion", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Fotos> fotos = new HashSet<>();;
	
	
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
	

	public Locacion(int id, String nombre, String direccion, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.descripcion = descripcion;
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
	
	

	public Set<Fotos> getFotos() {
		return fotos;
	}
	
	public String getUnaFoto() {
		Fotos fto1 = new Fotos();
		for (Fotos fto: this.fotos) {
			fto1= fto;
		}
		
		return fto1.getImagen();
	}

	public void setFotos(Set<Fotos> fotos) {
		for(Fotos item: fotos) {
			item.setLocacion(this);
		}
		this.fotos = fotos;
	}

	
	public Locacion(int id, String nombre, int valoracion, String direccion, Set<Persona> persona,
			Set<Comentarios> comentarios, Set<Fotos> fotos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.valoracion = valoracion;
		this.direccion = direccion;
		this.persona = persona;
		this.comentarios = comentarios;
		this.fotos = fotos;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", nombre=" + nombre + ", valoracion=" + valoracion + "]";
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Locacion(int id, String nombre, int valoracion, String direccion, String descripcion,
			Set<Comentarios> comentarios, Set<Fotos> fotos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.valoracion = valoracion;
		this.direccion = direccion;
		this.descripcion = descripcion;
		this.comentarios = comentarios;
		this.fotos = fotos;
	}
	

	
	
	
}
