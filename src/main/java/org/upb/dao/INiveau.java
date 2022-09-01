package org.upb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upb.data.Niveau;

public interface INiveau extends JpaRepository<Niveau, Integer>{
	public Niveau findBylibelleNiveau(String niveau);
}
