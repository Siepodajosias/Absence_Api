package org.upb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upb.data.Role;
import java.util.Set;
public interface IRole2 extends JpaRepository<Role, Integer>{

	 public Set<Role> findBylibelleRole(String role);
}
