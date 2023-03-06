package com.example.going.services;

import java.util.List;

import com.example.going.entities.Fotos;
import com.example.going.models.FotosModelo;



public interface IFotosService {
	
	public List<Fotos> getAll();
	
	public FotosModelo insertOrUpdate(FotosModelo fotosModelo);
	
	public boolean remove(int id);
	
	public boolean setIdLoc(int idLoc);

}
