package com.example.going.converters;

import org.springframework.stereotype.Component;

import com.example.going.entities.Avatar;
import com.example.going.models.AvatarModelo;

@Component("avatarConverter")
public class AvatarConverter {
	
	public AvatarModelo entityToModel(Avatar avatar) {
		
		return new AvatarModelo(avatar.getId(),avatar.getImagen());
		
	}
	
	
	
	public Avatar modelToEntity(AvatarModelo avatarModelo) {
		
		return new Avatar(avatarModelo.getId(),avatarModelo.getImagen());
		
		
	}

}
