package com.example.going.models;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.example.going.entities.Usuario;


public class PersonaModelo {
	
	
	private int id;
	
	@Size(min=4, max =12)
	private String nombre;
	
	@Min(0)
	private int edad;
	
	@Email
	@Min(4)
	@Max(30)
	private String email;
	
	private Usuario usuario;
	
	
	private AvatarModelo avatar;
	

	
	private Set<LocacionModelo> locaciones = new HashSet<>();
	
	public PersonaModelo() 
	{
		super();
		
	}
	
	
	public PersonaModelo(String nombre, int edad, String email) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.email = email;
	}

	


	@Override
	public String toString() {
		return "PersonaModelo [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", email=" + email
				+ ", avatar=" + avatar + "]";
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
	

	public PersonaModelo(@Size(min = 4, max = 12) String nombre, @Min(0) int edad, @Email @Min(4) @Max(30) String email,
			Usuario usuario, AvatarModelo avatar) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.email = email;
		this.usuario = usuario;
		this.avatar = avatar;
	}


	public PersonaModelo(int id, @Size(min = 4, max = 12) String nombre, @Min(0) int edad, @Min(4) @Max(30) String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.email = email;

	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public AvatarModelo getAvatar() {
		return avatar;
	}


	public void setAvatar(AvatarModelo avatar) {
		this.avatar = avatar;
	}


	public PersonaModelo(int id, @Size(min = 4, max = 12) String nombre, @Min(0) int edad, @Min(4) @Max(30) String email, AvatarModelo avatar) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.email = email;
		this.avatar = avatar;
	}


	



	public PersonaModelo(int id, @Size(min = 4, max = 12) String nombre, @Min(0) int edad,
			@Email @Min(4) @Max(30) String email,  Set<LocacionModelo> locaciones, AvatarModelo avatar) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.email = email;
		this.avatar = avatar;
		this.locaciones = locaciones;
	}


	public Set<LocacionModelo> getLocaciones() {
		return locaciones;
	}


	public void setLocaciones(Set<LocacionModelo> locaciones) {
		this.locaciones = locaciones;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	
	
	

}
