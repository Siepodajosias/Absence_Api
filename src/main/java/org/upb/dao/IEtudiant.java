package org.upb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upb.data.Etudiant;

public interface IEtudiant extends JpaRepository<Etudiant, String> {
	 public Etudiant findBymatriculeEtudiant(String etudiant);
}
