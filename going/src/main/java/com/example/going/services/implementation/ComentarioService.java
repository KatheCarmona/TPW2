package com.example.going.services.implementation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.going.converters.ComentarioConverter;
import com.example.going.entities.Comentarios;
import com.example.going.entities.Locacion;

import com.example.going.models.ComentarioModelo;
import com.example.going.repositories.IComentarioRepository;
import com.example.going.repositories.ILocacionRepository;
import com.example.going.services.IComentarioService;

@Service("comentarioService")
public class ComentarioService implements IComentarioService {
	
	@Autowired
	@Qualifier("comentarioRepository")
	private IComentarioRepository comentarioRepository;
	
	@Autowired
	@Qualifier("comentarioConverter")
	private ComentarioConverter comentarioConverter;
	
	@Autowired
	@Qualifier("locacionRepository")
	private ILocacionRepository locacionRepository;

	@Override
	public List<Comentarios> getAll() {
		
		return comentarioRepository.findAll();
	}

	@Override
	public boolean remove(int id) {
		try {
			comentarioRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public ComentarioModelo insertOrUpdate(ComentarioModelo comentarioModel, int idLocacion) {
		Locacion l = locacionRepository.findById(idLocacion);
		comentarioModel.setLocacion(l);
		
		Comentarios comentario = comentarioRepository.save(comentarioConverter.modelToEntity(comentarioModel));
		
		return comentarioConverter.entityToModel(comentario);
	}

	@Override
	public ComentarioModelo traerPorId(int id) {
		
		return comentarioConverter.entityToModel(comentarioRepository.findById(id));
	}
	
	

	
	

}
