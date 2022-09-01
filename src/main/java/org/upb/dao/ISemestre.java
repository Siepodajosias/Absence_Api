package org.upb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upb.data.Semestre;

public interface ISemestre extends JpaRepository<Semestre, Integer>{
	public Semestre findByidSemestre(Integer semestreId);
}
