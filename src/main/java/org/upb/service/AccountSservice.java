package org.upb.service;

import org.upb.data.Role;
import org.upb.data.Utilisateur;

public interface AccountSservice {
 
	public Utilisateur saveUtilisateur(Utilisateur utilisateur);
	public Role saveRole(Role role);
	public void addRoleToUtilisateur(String username,String role);
	public Utilisateur findBynomUtilisateur(String utilisateurnom);
	public Role findBylibelleRole(String role);
	
}
