package com.example.going.converters;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.going.entities.Usuario;
import com.example.going.models.UsuarioModelo;




@Component("usuarioConverter")
public class UsuarioConverter {
	
	@Autowired
	@Qualifier("userRolconverter")
	private UserRolConverter userRolConverter;
	

	
	public UsuarioModelo entityToModel(Usuario usuario) {
		return new UsuarioModelo(usuario.getId(),usuario.getUsername(),usuario.getPassword(),usuario.isEnabled(),
				userRolConverter.entidadAModeloSet(usuario.getUserRoles()));
	}
	
	public Usuario modelToEntity(UsuarioModelo userModel) {
		return new Usuario(userModel.getId(), userModel.getUsername(), userModel.getPassword(), userModel.isEnabled(),
				userRolConverter.modeloAEntidadSet(userModel.getUsuarioRols()));
	}
	

}
