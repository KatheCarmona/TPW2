package com.example.going.models;


public class AvatarModelo {
	
	
	private int id;
	

	private String imagen;
	
	private PersonaModelo persona;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public AvatarModelo(int id) {
		super();
		this.id = id;
	}

	
	public AvatarModelo() {
		super();
		
	}
	public PersonaModelo getPersona() {
		return persona;
	}
	public void setPersona(PersonaModelo persona) {
		this.persona = persona;
	}
	public AvatarModelo(int id, PersonaModelo persona) {
		super();
		this.id = id;
		this.persona = persona;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public AvatarModelo(int id, String imagen, PersonaModelo persona) {
		super();
		this.id = id;

		this.imagen = imagen;
		this.persona = persona;
	}
	public AvatarModelo(int id, String imagen) {
		super();
		this.id = id;

		this.imagen = imagen;
	
	}
	
	@Override
	public String toString() {
		return "AvatarModelo [id=" + id + ", imagen=" + imagen
				+ ", persona=" + persona + "]";
	}
	
	

}
