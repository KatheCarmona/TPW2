package com.example.going.entities;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="comentario")
public class Comentarios {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "locacion_id")
	@JsonBackReference
	private Locacion locacion;
	
	
	

	public Locacion getLocacion() {
		return locacion;
	}

	public void setLocacion(Locacion locacion) {
		this.locacion = locacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public Comentarios(int id, String descripcion, Locacion locacion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.locacion = locacion;
	}
	
	
	public Comentarios() {
		super();
		
	}
	
	
	public Comentarios(String descripcion, Locacion locacion) {
		super();
		this.descripcion = descripcion;
		this.locacion = locacion;
	}
	
	public Comentarios(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	
	}
	
	
	public Comentarios(String descripcion) {
		super();

		this.descripcion = descripcion;
	
	}

	@Override
	public String toString() {
		return "comentario [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
	
	
	
	
	
}
