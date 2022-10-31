package com.example.going.services;

import java.util.List;
import java.util.Set;

import com.example.going.entities.Comentarios;
import com.example.going.entities.Fotos;
import com.example.going.entities.Locacion;

import com.example.going.models.LocacionModelo;

public interface ILocacionService {
	
	
	public List<Locacion> getAll();
	
	public LocacionModelo insertOrUpdate(LocacionModelo locacionModelo);
	
	public boolean remove(int id);
	
	public LocacionModelo traerPorId(int id);
	
	public List<LocacionModelo> getAllModel();
	
	public Set<Comentarios> comentariosDeLaLocacion(int id);
	
	public Set<Fotos> fotosDeLaLocacion(int id);
	
	


}


