package com.example.going.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.going.entities.Avatar;

@Repository("avatarRepository")
public interface IAvatarRepository extends 
						JpaRepository<Avatar, Serializable> {
	
	
	public abstract Avatar findById(int id);
	
	

	

}
