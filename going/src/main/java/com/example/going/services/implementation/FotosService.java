package com.example.going.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.going.converters.FotosConverter;
import com.example.going.entities.Fotos;
import com.example.going.models.FotosModelo;
import com.example.going.repositories.IFotosRepository;
import com.example.going.services.IFotosService;

@Service("fotosService")
public class FotosService implements IFotosService {

	@Autowired
	@Qualifier("fotosRepository")
	private IFotosRepository fotosRepository;
	
	@Autowired
	@Qualifier("fotosConverter")
	private FotosConverter fotosConverter;
	
	
	@Override
	public List<Fotos> getAll() {

		return fotosRepository.findAll();
	}

	@Override
	public FotosModelo insertOrUpdate(FotosModelo fotosModelo) {
		Fotos foto = fotosRepository.save(fotosConverter.ModelToEntity(fotosModelo));
		return fotosConverter.entityToModel(foto);
	}

	@Override
	public boolean remove(int id) {
		try {
			fotosRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}	}

	
	@Override
	public boolean setIdLoc(int idLoc) {
		try {
			//fotosRepository.updateFotoLoc(idLoc);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

}
