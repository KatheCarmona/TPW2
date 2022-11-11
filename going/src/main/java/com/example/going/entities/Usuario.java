package com.example.going.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity

public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="username", unique=true, nullable=false, length=45)
	private String username;
	
	@Column(name="pass", nullable=false, length=60)
	private String password;
	
	@Column(name="enabled")
	private boolean enabled;
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	@OneToOne(mappedBy = "usuario")
	@JsonIgnore
	private Persona persona;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="usuario")
	@JsonIgnore
	private Set<UsuarioRol> usuarioRols = new HashSet<UsuarioRol>();
	
	public Usuario(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}
	
	public Usuario(String username, String password, boolean enabled, Set<UsuarioRol> usuarioRols) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.usuarioRols = usuarioRols;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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

	public Set<UsuarioRol> getUserRoles() {
		return usuarioRols;
	}

	public void setUserRoles(Set<UsuarioRol> usuarioRols) {
		this.usuarioRols = usuarioRols;
	}
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	public Usuario(int id, String username, String password, boolean enabled, LocalDateTime createdAt,
			LocalDateTime updatedAt, Set<UsuarioRol> usuarioRols) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.usuarioRols = usuarioRols;
	}

	public Usuario(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}



	public Usuario(int id, String username, String password, boolean enabled, LocalDateTime createdAt,
			LocalDateTime updatedAt, Persona persona, Set<UsuarioRol> usuarioRols) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.persona = persona;
		this.usuarioRols = usuarioRols;
	}

	public Usuario() {
		super();
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	public String getRol(){//Para la vista
		String rol;
		rol=this.usuarioRols.toString();
		return rol;
	}

	public Usuario(int id, String username, String password, boolean enabled, Set<UsuarioRol> usuarioRols) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.usuarioRols = usuarioRols;
	}
	
	
	
	
}