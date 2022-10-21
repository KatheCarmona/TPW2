package com.example.going.services;

import java.util.List;

import com.example.going.entities.Avatar;
import com.example.going.models.AvatarModelo;
public interface IAvatarService {
	
	
	public List<Avatar> getAll();
	
	public AvatarModelo insertOrUpdate(AvatarModelo avatarModelo);
	
	public boolean remove(int id);

}


