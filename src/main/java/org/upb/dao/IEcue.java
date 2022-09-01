package org.upb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upb.data.Ecue;

public interface IEcue extends JpaRepository<Ecue, Integer>{
	 public Ecue findBylibelleEcue(String ecue);
}
