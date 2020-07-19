package cl.novandi.barajas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.novandi.barajas.model.Usuario;
import cl.novandi.barajas.repo.IUsuarioRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private IUsuarioRepo repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Usuario usuario = repo.findOneByEmail(email);
		
		if(usuario == null) {
			throw new UsernameNotFoundException(String.format("Usuario no existe", email));
		}
		
		List<GrantedAuthority> roles = new ArrayList<>();
		
		roles.add(new SimpleGrantedAuthority(usuario.getPerfil().getNombre()));
		
		UserDetails ud = new User(usuario.getEmail(), usuario.getPassword(), roles);
		
		return ud;
	}
	
	
	
	
}
