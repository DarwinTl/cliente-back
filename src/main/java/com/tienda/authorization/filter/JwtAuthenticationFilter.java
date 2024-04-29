package com.tienda.authorization.filter;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import static com.tienda.authorization.TokenJwtConfig.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tienda.entities.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		String usuario = null;
		String password = null;

		try {
			Usuario user = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
			usuario = user.getUsuario();
			password = user.getPassword();
		} catch (IOException e) {
			e.printStackTrace();
		}
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(usuario,
				password);

		return this.authenticationManager.authenticate(authenticationToken);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		User user = (User) authResult.getPrincipal();
		String username = user.getUsername();

		Collection<? extends GrantedAuthority > roles=authResult.getAuthorities();
		
		Claims  claims= Jwts
				.claims()
				.add("authorities",new  ObjectMapper().writeValueAsString(roles))
				.add("username",username)
				.build();
		
		String jwt = Jwts.builder()
				.subject(username)
				.claims(claims)
				.signWith(SECRET_KEY)
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + 3600000)).compact();

		response.addHeader(HEADER_AUTHORIZATION, PREFIX_TOKEN + jwt);

		Map<String, Object> body = new HashMap<>();

		body.put("token", jwt);
		body.put("usuario", username);
		body.put("mensaje", String.format("Bienvenido %s has iniciado sesión", username));

		response.getWriter().write(new ObjectMapper().writeValueAsString(body));
		response.setContentType(CONTENT_TYPE);
		response.setStatus(200);

	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		Map<String, String> body =new HashMap<>();
		body.put("mensaje","Error usuario y/o contraseña incorrecta");
		body.put("error",failed.getMessage());
		
		response.getWriter().write(new ObjectMapper().writeValueAsString(body));
		response.setContentType(CONTENT_TYPE);
		response.setStatus(401);
	}

}
