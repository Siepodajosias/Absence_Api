package org.upb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.upb.dao.IRole;
import org.upb.dao.IUtilisateur;
import org.upb.data.Role;
import org.upb.data.Utilisateur;

@Service
@Transactional
public class AccountService implements AccountSservice{
	
	@Autowired
	private BCryptPasswordEncoder  bcryptPasswordEncoder;
	
	@Autowired
	private IUtilisateur utilisateur1;
	
	@Autowired
	private IRole role1;

	@Override
	public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
		String hashPWD= bcryptPasswordEncoder.encode(utilisateur.getPasswordUtilisateur());
		utilisateur.setPasswordUtilisateur(hashPWD);
		return utilisateur1.save(utilisateur);
	}

	@Override
	public Role saveRole(Role role) {
		return role1.save(role);
	}

	@Override
	public void addRoleToUtilisateur(String username, String role) {
		Role role2= role1.findBylibelleRole(role);
		Utilisateur utilisateur2=utilisateur1.findBylogin(username);
		utilisateur2.getRoles().add(role2);
		//role2.getUtilisateurs().add(utilisateur2);
	}

	@Override
	public Utilisateur findBynomUtilisateur(String utilisateurnom) {
		return utilisateur1.findBylogin(utilisateurnom) ;
	}

	@Override
	public Role findBylibelleRole(String role) {
		return role1.findBylibelleRole(role);
	}

}
