package com.example.going.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.example.going.entities.Persona;


public class UsuarioModelo {
	
	private int id;
	private String username;
	private boolean enabled;
	private PersonaModelo persona;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private String password;
	private Set<UsuarioRolModelo> usuarioRols = new HashSet<UsuarioRolModelo>();
	
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
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public PersonaModelo getPersona() {
		return persona;
	}
	public void setPersona(PersonaModelo persona) {
		this.persona = persona;
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

	public UsuarioModelo(int id, String username, boolean enabled, PersonaModelo persona, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.username = username;
		this.enabled = enabled;
		this.persona = persona;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Set<UsuarioRolModelo> getUsuarioRols() {
		return usuarioRols;
	}
	public void setUsuarioRols(Set<UsuarioRolModelo> usuarioRols) {
		this.usuarioRols = usuarioRols;
	}
	@Override
	public String toString() {
		return "UsuarioModelo [id=" + id + ", username=" + username + ", enabled=" + enabled + ", persona=" + persona
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", usuarioRols=" + usuarioRols + "]";
	}
	public UsuarioModelo(int id, String username, boolean enabled, PersonaModelo persona, Set<UsuarioRolModelo> usuarioRols) {
		super();
		this.id = id;
		this.username = username;
		this.enabled = enabled;
		this.persona = persona;
		this.usuarioRols = usuarioRols;
	}
	public UsuarioModelo(int id, String username, String password, boolean enabled, Set<UsuarioRolModelo> usuarioRols) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.usuarioRols = usuarioRols;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UsuarioModelo() {
		super();
	}

	
	

}
