package com.example.going.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="avatar")
public class Avatar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	
	private String imagen;
	
	@OneToOne(mappedBy = "avatar")
	@JsonIgnore
	private Persona persona;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Avatar(int id) {
		super();
		this.id = id;

	}
	
	public Avatar() {
		super();
		
	}
	@Override
	public String toString() {
		return imagen;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public Avatar(int id,  String imagen, Persona persona) {
		super();
		this.id = id;
		this.imagen = imagen;
		this.persona = persona;
	}
	
	
	public Avatar(int id, String imagen) {
		super();
		this.id = id;
		this.imagen = imagen;
		
	}
	

	
	
	
}
