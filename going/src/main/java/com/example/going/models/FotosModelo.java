package com.example.going.models;

import com.example.going.entities.Locacion;

public class FotosModelo {
	
	private int id;
	
	private String imagen;
	private LocacionModelo locacion;
	
	private int locacion_id;
	
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
	public LocacionModelo getLocacion() {
		return locacion;
	}
	public void setLocacion(LocacionModelo locacion) {
		this.locacion = locacion;
	}
	
	
	public int getLocacion_id() {
		return locacion_id;
	}
	public void setLocacion_id(int locacion_id) {
		this.locacion_id = locacion_id;
	}
	public FotosModelo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FotosModelo(int id, String imagen, LocacionModelo locacion) {
		super();
		this.id = id;
		this.imagen = imagen;
		this.locacion = locacion;
	}
	
	public FotosModelo(int id, String imagen, int locacion_id) {
		super();
		this.id = id;
		this.imagen = imagen;
		this.locacion_id = locacion_id;
	}
	public FotosModelo(int id, String imagen) {
		super();
		this.id = id;
		this.imagen = imagen;
	}

	
	
	

}
