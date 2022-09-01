package org.upb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upb.data.Parent;

public interface IParent extends JpaRepository<Parent, Integer>{
	public Parent findByidParent(int parent);
}
