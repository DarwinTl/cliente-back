package com.tienda.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tienda.entities.Usuario;
import com.tienda.repositories.IUsuarioDao;

@Service
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Usuario> optUser = usuarioDao.findByUsuario(username);
		if (optUser.isEmpty()) {
			throw new UsernameNotFoundException(String.format("El usuario %s  no esta registrado", username));
		}

		Usuario usuario = optUser.orElseThrow();

		List<GrantedAuthority> authorities = usuario.getRoles().stream()
				.map(rol -> new SimpleGrantedAuthority(rol.getNombre())).collect(Collectors.toList());

		return new User(username, usuario.getPassword(), true, true, true, true, authorities);
	}

}
