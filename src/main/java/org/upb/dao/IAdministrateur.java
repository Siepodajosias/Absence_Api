package org.upb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upb.data.Administrateur;

public interface IAdministrateur extends JpaRepository<Administrateur, Integer>{
	public Administrateur findByidResponsable(int administrateur);
}
