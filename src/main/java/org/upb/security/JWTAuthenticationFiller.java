package org.upb.security;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.upb.data.Utilisateur;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFiller extends UsernamePasswordAuthenticationFilter {

	
	@Autowired
	private AuthenticationManager authenticationManager;
	

	
    public JWTAuthenticationFiller(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}
    
	@Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
		throws AuthenticationException {
		
	    Utilisateur utilisateur=null;

	   try {
		   
		utilisateur=new ObjectMapper().readValue(request.getInputStream(), Utilisateur.class);

	} catch (Exception e) {
		throw new RuntimeException(e);
	}
	   System.out.println(" salut "+utilisateur.getLogin());
	   
	   System.out.println(" salut "+utilisateur.getPasswordUtilisateur());
	    return authenticationManager.authenticate(
	    		new UsernamePasswordAuthenticationToken(utilisateur.getLogin(),utilisateur.getPasswordUtilisateur())
	    		);
   }
	
	@Override
	protected void successfulAuthentication(
			HttpServletRequest request,
			HttpServletResponse response, 
			FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		//User userspring=(User) authResult.getPrincipal();
		String user1=  authResult.getName();
		System.out.println(" salut "+ user1);
		Collection<? extends GrantedAuthority> user2=  authResult.getAuthorities();
		String jwtToken=Jwts.builder()
				.setSubject(user1)
				.setExpiration(new Date(
						System.currentTimeMillis()+SecurityConstantes.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS256, SecurityConstantes.SECRET)
				.claim("role", user2)
				.compact();
		System.out.println(" salut "+ jwtToken);
		response.addHeader(SecurityConstantes.HEADER_STRING,SecurityConstantes.TOKEN_PREFIXE + jwtToken);
	}
}
