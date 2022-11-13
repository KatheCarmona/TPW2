package com.example.going.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ComentarioRequest {
	@JsonProperty("descripcion")
	private String descripcion;
	
	
	@JsonProperty("idLocacion")
	private int idLocacion;


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getIdLocacion() {
		return idLocacion;
	}


	public void setIdLocacion(int idLocacion) {
		this.idLocacion = idLocacion;
	}


	public ComentarioRequest(String descripcion, int idLocacion) {
		super();
		this.descripcion = descripcion;
		this.idLocacion = idLocacion;
	}


	@Override
	public String toString() {
		return "ComentarioRequest [descripcion=" + descripcion + ", locacionid=" + idLocacion + "]";
	}
	
	
	
	
}