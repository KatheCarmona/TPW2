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
@Table(name="fotos")
public class Fotos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String imagen;
	
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

	public Fotos() {
		super();
	}

	public Fotos(int id, String imagen, Locacion locacion) {
		super();
		this.id = id;
		this.imagen = imagen;
		this.locacion = locacion;
	}

	@Override
	public String toString() {
		return "Fotos [id=" + id + ", imagen=" + imagen + ", locacion=" + locacion + "]";
	}
	
	
	


}
