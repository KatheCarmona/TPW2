package com.example.going.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.mapping.Column;
import org.hibernate.mapping.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="fotos")
public class Fotos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String imagen;
	//private int locacion_id;
	

	@ManyToOne
	@JoinColumn(name = "locacion_id")
	@JsonBackReference
	private Locacion locacion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Locacion getLocacion() {
		return locacion;
	}

	public void setLocacion(Locacion locacion) {
		this.locacion = locacion;
	}
	/*
	
	public int getLocacion_id() {
		return locacion_id;
	}

	public void setLocacion_id(int locacion_id) {
		this.locacion_id = locacion_id;
	}
*/

	public Fotos() {
		super();
	}

	public Fotos(int id, String imagen, Locacion locacion) {
		super();
		this.id = id;
		this.imagen = imagen;
		this.locacion = locacion;
	}
	
	
	public Fotos(int id, String imagen, int locacion_id) {
		super();
		this.id = id;
		this.imagen = imagen;
		
	}
	
	

	public Fotos(int id, String imagen) {
		super();
		this.id = id;
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Fotos [id=" + id + ", imagen=" + imagen + ", locacion=" + locacion + "]";
	}
	
	
	


}
