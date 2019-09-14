package com.femkhra.Services;

import java.util.ArrayList;
import java.util.List;

import com.femkhra.Models.Role;
import com.femkhra.Models.Usuario;
import com.femkhra.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void createUser(Usuario usuario) {
		BCryptPasswordEncoder  encoder = new  BCryptPasswordEncoder();
		usuario.setPassword(encoder.encode(usuario.getPassword())); 
		Role usuarioRole = new Role("USUARIO");
		List<Role> roles = new ArrayList<>();
		roles.add(usuarioRole);
		usuario.setRoles(roles);
		userRepository.save(usuario);
	}
	
	public void createAdmin(Usuario usuario) {
		BCryptPasswordEncoder  encoder = new  BCryptPasswordEncoder();
		usuario.setPassword(encoder.encode(usuario.getPassword())); 
		Role usuarioRole = new Role("ADMIN");
		List<Role> roles = new ArrayList<>();
		roles.add(usuarioRole);
		usuario.setRoles(roles);
		userRepository.save(usuario);
	}
	
	public Usuario findOne(String email) {
		
	  return userRepository.findOne(email);
	}

	public boolean isUserPresent(String email) {
		// TODO Auto-generated method stub
		Usuario u=userRepository.findOne(email);
		if(u!=null)
			return true;
		
		return false;
	}

	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public List<Usuario> findByName(String name) {
		// TODO Auto-generated method stub
		return  userRepository.findByNameLike("%"+name+"%");
	}

}
