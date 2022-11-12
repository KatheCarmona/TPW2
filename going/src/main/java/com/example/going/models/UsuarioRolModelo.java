package com.example.going.models;

import java.time.LocalDateTime;

import com.example.going.entities.Usuario;

public class UsuarioRolModelo {
	private int id;
	private UsuarioModelo usuario;
	private String rol;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UsuarioModelo getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioModelo usuario) {
		this.usuario = usuario;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
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
	@Override
	public String toString() {
		return "UsuarioRolModelo [id=" + id + ", usuario=" + usuario + ", rol=" + rol + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
	public UsuarioRolModelo(int id, UsuarioModelo usuario, String rol, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.rol = rol;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public UsuarioRolModelo(int id, String rol) {
		super();
		this.id = id;
		this.rol = rol;
	}
	public UsuarioRolModelo() {
		super();
	}
	
	
	

}
