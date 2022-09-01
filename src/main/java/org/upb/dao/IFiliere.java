package org.upb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upb.data.Filiere;

public interface IFiliere extends JpaRepository<Filiere, Integer>{
	public Filiere findByDesignationFiliere(String filiere);
}
