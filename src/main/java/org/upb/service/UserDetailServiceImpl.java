package org.upb.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.upb.data.Utilisateur;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	private AccountSservice accountSservice;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur utilisateur=accountSservice.findBynomUtilisateur(username);
		
		if(utilisateur ==null) throw new UsernameNotFoundException(username); 
		Collection<GrantedAuthority> listrole=new ArrayList<>();
		utilisateur.getRoles().forEach(r->{
			listrole.add(new SimpleGrantedAuthority(r.getLibelleRole()));
		});
		return new User(utilisateur.getLogin(),utilisateur.getPasswordUtilisateur(),listrole);
	}

}
