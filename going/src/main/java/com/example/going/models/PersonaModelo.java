package com.example.going.models;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


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
	
	@Size(min=4, max =40)
	private String pais;
	
	
	private AvatarModelo avatar;
	

	
	private Set<LocacionModelo> paises = new HashSet<>();
	
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

	
	
	
	public PersonaModelo(@Size(min = 4, max = 12) String nombre, @Min(0) int edad, @Min(4) @Max(30) String email,
			@Size(min = 4, max = 40) String pais) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.email = email;
		this.pais = pais;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	@Override
	public String toString() {
		return "PersonaModelo [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", email=" + email + ", pais=" + pais
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

	
	

	public PersonaModelo(int id, @Size(min = 4, max = 12) String nombre, @Min(0) int edad, @Min(4) @Max(30) String email,
			@Size(min = 4, max = 40) String pais, AvatarModelo avatar, Set<LocacionModelo> paises) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.email = email;
		this.pais = pais;
		this.avatar = avatar;
		this.paises = paises;
	}


	public PersonaModelo(int id, @Size(min = 4, max = 12) String nombre, @Min(0) int edad, @Min(4) @Max(30) String email,
			@Size(min = 4, max = 40) String pais) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.email = email;
		this.pais = pais;
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


	public PersonaModelo(int id, @Size(min = 4, max = 12) String nombre, @Min(0) int edad, @Min(4) @Max(30) String email,
			@Size(min = 4, max = 40) String pais, AvatarModelo avatar) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.email = email;
		this.pais = pais;
		this.avatar = avatar;
	}





	public Set<LocacionModelo> getPaises() {
		return paises;
	}


	public void setPaises(Set<LocacionModelo> paises) {
		this.paises = paises;
	}
	
	
	
	
	
	

}
