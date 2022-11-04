package com.example.going.entities;

import java.time.LocalDateTime;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.EqualsAndHashCode;


@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="persona")
public class Persona {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	@Column(name="nombre")
	private String nombre;
	
	@Column(name="edad")
	private int edad;
	
	@Column(name="email")
	private String email;
	
	@Column(name="locacion")
	private String locacion;
	

	@Column(name="creado")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="actualizado")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "avatar_id", referencedColumnName = "id")
	@JsonIgnore
	private Avatar avatar;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
	@JsonIgnore
	private Usuario usuario;
	


	@ManyToMany(cascade = {
	            CascadeType.PERSIST,
	            CascadeType.MERGE
	  })
	    @JoinTable(name = "persona_locacion",
	            joinColumns = @JoinColumn(name = "persona_id"),
	            inverseJoinColumns = @JoinColumn(name = "locacion_id")
	  )
	 @JsonIgnoreProperties("persona")
	private Set<Locacion> locaciones = new HashSet<>();
	 


	public Persona(int id, String nombre, int edad, String email, String locacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.email = email;
		this.locacion = locacion;
	}
	
	

	public Persona() {
		super();
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getLocacion() {
		return locacion;
	}

	public void setLocacion(String locacion) {
		this.locacion = locacion;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	 public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Persona(int id, String nombre, int edad, String email, String locacion, Avatar avatar) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.email = email;
		this.locacion = locacion;
		this.avatar = avatar;
	}



	public Avatar getAvatar() {
		return avatar;
	}



	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}


	

	public Set<Locacion> getLocaciones() {
		return locaciones;
	}



	public void setLocaciones(Set<Locacion> locaciones) {
		this.locaciones = locaciones;
	}



	public Persona(int id, String nombre, int edad, String email, String locacion, LocalDateTime createdAt,
			LocalDateTime updatedAt, Avatar avatar,Set<Locacion> locaciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.email = email;
		this.locacion = locacion;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.avatar = avatar;
		this.locaciones = locaciones;
	}
	
	
	
	public Persona(int id, String nombre, int edad, String email,  Avatar avatar, Set<Locacion> locaciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.email = email;

	
		this.avatar = avatar;
	
		this.locaciones = locaciones;
	}
	
	



	public Persona(int id, String nombre, int edad, String email, String locacion, LocalDateTime createdAt,
			LocalDateTime updatedAt, Avatar avatar, Usuario usuario, Set<Locacion> locaciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.email = email;
		this.locacion = locacion;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.avatar = avatar;
		this.usuario = usuario;
		this.locaciones = locaciones;
	}
	
	public Persona(int id, String nombre, int edad, String email, LocalDateTime createdAt,
			LocalDateTime updatedAt, Avatar avatar, Usuario usuario, Set<Locacion> locaciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.email = email;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.avatar = avatar;
		this.usuario = usuario;
		this.locaciones = locaciones;
	}



	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", email=" + email + ", locacion=" + locacion
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt;
	}



	public Persona(int id, String nombre, int edad, String email, Set<Locacion> locaciones, Avatar avatar) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.email = email;
		this.avatar = avatar;
		this.locaciones = locaciones;
	}



	public Persona(int id,String nombre, int edad, String email, Usuario usuario, Avatar avatar) {
		super();
		this.id=id;
		this.nombre = nombre;
		this.edad = edad;
		this.email = email;
		this.avatar = avatar;
		this.usuario = usuario;
	}



	
	
	
	
	
}
