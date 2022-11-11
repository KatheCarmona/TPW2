package com.example.going.services.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.going.converters.AvatarConverter;
import com.example.going.converters.UsuarioConverter;
import com.example.going.entities.Avatar;
import com.example.going.entities.Usuario;
import com.example.going.entities.UsuarioRol;
import com.example.going.models.AvatarModelo;
import com.example.going.models.UsuarioModelo;
import com.example.going.repositories.IUserRepository;

@Service("userService")
public class UserService implements UserDetailsService {

	@Autowired
	@Qualifier("userRepository")
	private IUserRepository userRepository;
	
	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.example.going.entities.Usuario usuario = userRepository.findByUsernameAndFetchUserRolesEagerly(username);
		return buildUser(usuario, buildGrantedAuthorities(usuario.getUserRoles()));
	}
	
	private User buildUser(com.example.going.entities.Usuario usuario, List<GrantedAuthority> grantedAuthorities) {
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.isEnabled(),
						true, true, true, //accountNonExpired, credentialsNonExpired, accountNonLocked,
						grantedAuthorities);
	}
	
	private List<GrantedAuthority> buildGrantedAuthorities(Set<UsuarioRol> usuarioRols) {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		for(UsuarioRol usuarioRol: usuarioRols) {
			grantedAuthorities.add(new SimpleGrantedAuthority(usuarioRol.getRol()));
		}
		return new ArrayList<GrantedAuthority>(grantedAuthorities);
	}
	
	
	public UsuarioModelo insertOrUpdate(UsuarioModelo usuarioModelo) {
		
		Usuario usuario = userRepository.save(usuarioConverter.modelToEntity(usuarioModelo));
		
		return usuarioConverter.entityToModel(usuario);
	}
	
}
