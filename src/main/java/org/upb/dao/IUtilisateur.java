package org.upb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upb.data.Utilisateur;

public interface IUtilisateur extends JpaRepository<Utilisateur, Integer>{
	
	public Utilisateur findBylogin(String rnom);

}
