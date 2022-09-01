package org.upb.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTAutorizationFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers", 
				"Origin,Accept,X-Resquested-With,"
				+ "Content-Type,"
				+ "Access-Control-Request-Method,"
				+ "Access-Control-Request-Headers,"
				+ "Authorization");
		response.addHeader("Access-Control-Expose-Headers", 
				"Access-Control-Allow-Origin,"
				+ "Access-Control-Allow-Credentials,"
				+ "Authorization");
		if(request.getMethod().equals("OPTIONS")) {
			response.setStatus(HttpServletResponse.SC_OK);
		}
	
		String jwt=request.getHeader(SecurityConstantes.HEADER_STRING);
		if(jwt==null || !jwt.startsWith(SecurityConstantes.TOKEN_PREFIXE)) {
			filterChain.doFilter(request, response);
			return;
		}
		
		Claims claims=Jwts.parser()
				.setSigningKey(SecurityConstantes.SECRET)
				.parseClaimsJws(jwt.replace(SecurityConstantes.TOKEN_PREFIXE, ""))
				.getBody();
		String username=claims.getSubject();
		@SuppressWarnings("unchecked")
		ArrayList<Map<String, String>> roles=(ArrayList<Map<String, String>>)claims.get("role");
		
		Collection<GrantedAuthority> listrole=new ArrayList<>();
		roles.forEach(r->{
			listrole.add(new SimpleGrantedAuthority(r.get("libelleRole")));
		});
		UsernamePasswordAuthenticationToken authentificationUser=new UsernamePasswordAuthenticationToken(username,null, listrole);
		SecurityContextHolder.getContext().setAuthentication(authentificationUser);
		filterChain.doFilter(request, response);
		
	}

}
