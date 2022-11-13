package com.example.going.models;

import com.example.going.entities.Locacion;

public class ComentarioModelo {
	
	private int id;
	private String descripcion;
	private Locacion locacion;
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
	public Locacion getLocacion() {
		return locacion;
	}
	public void setLocacion(Locacion locacion) {
		this.locacion = locacion;
	}
	public ComentarioModelo(int id, String descripcion, Locacion locacion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.locacion = locacion;
	}
	public ComentarioModelo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ComentarioModelo [id=" + id + ", descripcion=" + descripcion + ", locacion=" + locacion + "]";
	}
	
	

}
