package com.example.going.services.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.going.converters.LocacionConverter;
import com.example.going.entities.Comentarios;
import com.example.going.entities.Fotos;
import com.example.going.entities.Locacion;
import com.example.going.models.LocacionModelo;
import com.example.going.repositories.ILocacionRepository;
import com.example.going.services.ILocacionService;


@Service("locacionService")
public class LocacionService implements ILocacionService {
	
	@Autowired
	@Qualifier("locacionRepository")
	private ILocacionRepository locacionRepository;
	
	@Autowired
	@Qualifier("locacionConverter")
	private LocacionConverter locacionConverter;
	
	@Override
	public List<Locacion> getAll(){	
			
			
		return locacionRepository.findAll();	
	}
	
	
	public LocacionModelo traerPorId(int id) {
		
		
		return locacionConverter.entityToModel(locacionRepository.findById(id));
		
	};
	
	
	
	
	public List<LocacionModelo> getAllModel(){
		
		List<LocacionModelo> locacionesList = new ArrayList<LocacionModelo>();
		
		for (Locacion iter:getAll() ) {
			
			locacionesList.add(locacionConverter.entityToModel(iter));
			
			
		}
	
		
		return locacionesList;
	}
	
	@Override
	public LocacionModelo insertOrUpdate(LocacionModelo locacionModelo) {
		
	
		
		Locacion locacion = locacionRepository.save(locacionConverter.modelToEntity(locacionModelo));
		
		return locacionConverter.entityToModel(locacion);
	}
	
	@Override
	public boolean remove(int id) {
		
		try {
			locacionRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}
	
	public Set<Comentarios> comentariosDeLaLocacion(int id) {
		
		Locacion p = locacionRepository.findByIdAndFetchcomentariosEagerly(id);
		
		Set<Comentarios> lista = new HashSet<>();
		if (p!=null) {
			if(p.getComentarios()!=null) {
					lista = p.getComentarios();
			}
		}else {
			System.out.println("la lista esta vacia");
		}
		return lista;
	}
	
	public Set<Fotos> fotosDeLaLocacion(int id) {
		
		Locacion p = locacionRepository.findByIdAndFetchFotosEagerly(id);
		
		Set<Fotos> lista = new HashSet<>();
		if (p!=null) {
			if(p.getFotos()!=null) {
					lista = p.getFotos();
			}
		}
		return lista;
	}
	


}
