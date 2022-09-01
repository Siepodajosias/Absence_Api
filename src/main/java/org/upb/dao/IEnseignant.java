package org.upb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upb.data.Enseignant;

public interface IEnseignant extends JpaRepository<Enseignant, Integer> {
	public Enseignant findByidEnseignant(int etudiant); 
}
